class SegmentTree:
    def __init__(self, xs):
        self.xs = xs
        self.n = len(xs) - 1
        self.cnt = [0] * (4 * self.n)
        self.covered = [0.0] * (4 * self.n)

    def update(self, node, l, r, ql, qr, val):
        if ql <= l and r <= qr:
            self.cnt[node] += val
        else:
            mid = (l + r) // 2
            if ql < mid:
                self.update(2 * node, l, mid, ql, qr, val)
            if qr > mid:
                self.update(2 * node + 1, mid, r, ql, qr, val)

        if self.cnt[node] > 0:
            self.covered[node] = self.xs[r] - self.xs[l]
        else:
            if r - l == 1:
                self.covered[node] = 0.0
            else:
                self.covered[node] = self.covered[2 * node] + self.covered[2 * node + 1]

class Solution:
    def separateSquares(self, squares: list[list[int]]) -> float:
        events = []
        x_set = set()

        for x, y, l in squares:
            events.append((y, 1, x, x + l))
            events.append((y + l, -1, x, x + l))
            x_set.add(x)
            x_set.add(x + l)

        events.sort(key=lambda e: e[0])
        sorted_x = sorted(x_set)
        x_map = {x: i for i, x in enumerate(sorted_x)}

        tree = SegmentTree(sorted_x)
        strips = []  # (prev_y, curr_y, covered_width)
        prev_y = events[0][0]

        for y, val, x1, x2 in events:
            if y > prev_y:
                width = tree.covered[1]
                if width > 0:
                    strips.append((prev_y, y, width))
                prev_y = y
            tree.update(1, 0, len(sorted_x) - 1, x_map[x1], x_map[x2], val)

        total_area = sum((y2 - y1) * w for y1, y2, w in strips)
        half_area = total_area / 2.0

        curr_area = 0.0
        for y1, y2, w in strips:
            strip_area = (y2 - y1) * w
            if curr_area + strip_area >= half_area:
                return y1 + (half_area - curr_area) / w
            curr_area += strip_area

        return 0.0