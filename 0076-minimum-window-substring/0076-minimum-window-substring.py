class Solution(object):
    def minWindow(self, s, t):
        from collections import Counter
        c = Counter(t); m = len(t); l = i = j = 0
        for r, ch in enumerate(s, 1):
            if c[ch] > 0: m -= 1
            c[ch] -= 1
            if not m:
                while c[s[l]] < 0:
                    c[s[l]] += 1; l += 1
                if not j or r - l < j - i: i, j = l, r
                c[s[l]] += 1; m += 1; l += 1
        return s[i:j]
