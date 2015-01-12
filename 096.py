
from copy import deepcopy


class Item:

    def __init__(self, value, row, col):
        self.value = value
        if self.value is None:
            self.possible = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        else:
            self.possible = []
        self.row = row
        self.col = col
        self.cell = (row // 3) * 3  + col // 3

    @property
    def is_solved(self):
        return self.value is not None

    def set_value(self, val):
        if not val in self.possible:
            print "ERROR setting to impossible value"
            exit()
        self.value = val
        self.possible = []

    def update_possible_values(self, used_vals):
        self.possible = [p for p in self.possible if not p in used_vals]
        if len(self.possible) == 1:
            self.set_value(self.possible[0])
            return True
        return False

    def __str__(self):
        if self.value is None:
            return "x"
        else: return str(self.value)


class Sudoku:

    def __init__(self, string):
        self.from_raw(string)
        self.depth = 0

    def from_raw(self, string):
        self.grid = []
        for i, line in enumerate(string.split("\n")):
            row = []
            for j, col in enumerate(line):
                if col == "0":
                    row.append(Item(None, i, j))
                else:
                    row.append(Item(int(col), i, j))
            if len(row) == 9:
                self.grid.append(row)

    def row(self, i):
        return self.grid[i]

    def column(self, i):
        return [row[i] for row in self.grid]

    def cell(self, i):
        row = i // 3
        col = i % 3
        res = []
        for r in range(3):
            for c in range(3):
                res.append(self.grid[row * 3 + r][col * 3 + c])
        return res

    @property
    def items(self):
        for row in self.grid:
            for item in row:
                yield item

    def update_possible_values(self):
        vals_in_rows = []
        vals_in_cols = []
        vals_in_cells = []
        for i in range(9):
            vals_in_cols.append(set([item.value for item in self.column(i) if item.value is not None]))
            vals_in_rows.append(set([item.value for item in self.row(i) if item.value is not None]))
            vals_in_cells.append(set([item.value for item in self.cell(i) if item.value is not None]))

        is_change = False
        for item in self.items:
            if not item.is_solved:
                is_change = is_change or item.update_possible_values(vals_in_cols[item.col])
                is_change = is_change or item.update_possible_values(vals_in_rows[item.row])
                is_change = is_change or item.update_possible_values(vals_in_cells[item.cell])
        return is_change


    def test_single_possible_group(self, items):
        unplaced = []
        is_change = False
        for item in items:
            for pos in item.possible:
                unplaced.append(pos)
        # does unplaced contain a number only once?
        for num in set(unplaced):
            if unplaced.count(num) == 1:
                for item in items:
                    if num in item.possible:
                        item.set_value(num)
                        is_change = True
                        break
        return is_change

    def test_single_possible(self):
        is_change = False
        for i in range(9):
            is_change = is_change or self.test_single_possible_group(self.row(i))
            is_change = is_change or self.test_single_possible_group(self.column(i))
            is_change = is_change or self.test_single_possible_group(self.cell(i))
        return is_change


    def solve(self):
        is_change = True
        while not self.is_solved and is_change:
            is_change = False
            is_change = is_change or self.update_possible_values()
            is_change = is_change or self.test_single_possible()

        # not able to solve it. set a field and try that sudoku
        if not self.is_solved and self.is_solvable and self.depth == 0:
            for item in sorted(self.items, key=lambda x: len(x.possible)):
                for pos in item.possible:
                    sudoku = deepcopy(self)
                    sudoku.depth = self.depth + 1
                    sudoku.row(item.row)[item.col].set_value(pos)
                    sudoku.solve()
                    if sudoku.is_solved:
                        self.grid = sudoku.grid
                        return

    @property
    def is_solved(self):
        return self.unsolved == 0

    @property
    def is_solvable(self):
        for item in self.items:
            if not item.is_solved and len(item.possible) == 0:
                return False
        return True

    @property
    def unsolved(self):
        return len([1 for item in self.items if not item.is_solved])

    def __str__(self):
        ret = ""
        for i, row in enumerate(self.grid):
            if i % 3 == 0:
                ret += "\n"
            for j, item in enumerate(row):
                if j % 3 == 0:
                    ret += " "
                ret += str(item)
            ret += "\n"
        return ret


def read_sudokus():
    with open("data/p096_sudoku.txt") as fin:
        current = ""
        for row in fin:
            if row.startswith("Grid"):
                if current != "":
                    yield Sudoku(current)
                current = ""
            else:
                current += row
        yield Sudoku(current)


res = 0
for i, sudoku in enumerate(read_sudokus()):
    sudoku.solve()
    res += int("".join([str(item.value) for item in sudoku.row(0)[0:3]]))

print res
