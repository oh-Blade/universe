class Solution(object):
    def lengthOfLongestSubstring(self, s) -> int:
        if len(s) == 1:
            return 1
        mid, target = "", ""
        for i, x in enumerate(s):
            if (mid.find(x) >= 0):
                if (len(mid) > len(target)):
                    target = mid
                mid = mid[mid.index(x) + 1:] + x
            else:
                mid = mid + x
        return max(len(mid), len(target))


s = Solution()
print(s.lengthOfLongestSubstring("dvdf"))
