class Solution:
    def longestPalindrome(self, s: str) -> str:
        size = len(s)
        if size < 2:
            return s

        dp = [[False for _ in range(size)] for _ in range(size)]

        for i in range(size):
            dp[i][i] = True

        max_len = 1
        start = 0

        for j in range(1, size):
            for i in range(0, j):
                if s[i] == s[j]:
                    if j - i < 3:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                else:
                    dp[i][j] = False

                if dp[i][j]:
                    curlen = j - i + 1
                    if curlen > max_len:
                        max_len = curlen
                        start = i
        return s[start:start + max_len]