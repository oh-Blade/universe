#!/usr/local/bin python3
# -*- coding: utf-8 -*-
# ProjectName: universe
# Author: naikuo
# CreateTime: 2020/2/16 1:53 PM
# Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
# ----------------------------------


class Solution(object):
    def twoSum(self, nums, target):
        for i in range(0, len(nums)):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [nums[i], nums[j]]
        return []
