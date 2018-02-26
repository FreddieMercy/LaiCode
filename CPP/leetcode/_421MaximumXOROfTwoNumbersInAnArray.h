#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>
#include <climits>
#include <cmath>
#include <map>

using namespace std;

/*
class Solution { //https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/#/solutions
public:
	class TreeNode {
	public:
		TreeNode* next[2];
		TreeNode() { next[0] = NULL; next[1] = NULL; };
	};
	TreeNode* buildTree(vector<int>& nums) {
		TreeNode* root = new TreeNode(), *cur;
		int n = nums.size();
		for (int i = 0; i < n; i++) {
			int num = nums[i];
			cur = root;
			for (int j = 31; j >= 0; j--) {
				int index = ((num >> j) & 1);
				if (cur->next[index] == NULL)
					cur->next[index] = new TreeNode();
				cur = cur->next[index];
			}
		}
		return root;
	}

	int helper(TreeNode* cur, int num) {
		int res = 0;
		for (int i = 31; i >= 0; i--) {
			int index = ((num >> i) & 1) ? 0 : 1;
			if (cur->next[index]) {
				res <<= 1;
				res |= 1;
				cur = cur->next[index];
			}
			else {
				res <<= 1;
				res |= 0;
				cur = cur->next[index ? 0 : 1];
			}
		}
		return res;
	}

	int findMaximumXOR(vector<int>& nums) {
		int res = 0;
		TreeNode* root = buildTree(nums);

		for (auto i : nums) {
			res = max(res, helper(root, i));
		}

		return res;
	}
};
*/

class Solution {
public:
	int findMaximumXOR(vector<int>& nums) {
		vector<int> tmp = nums;
		vector<int> big;
		vector<int> sml;
		vector<int> allBig;
		int n, op = 0, greatest = INT_MIN;

		size_t j = tmp.size() - 1;

		int retVal = 0;

		sort(tmp.begin(), tmp.end());
		n = floor(log2(tmp[tmp.size() - 1]));

		while (tmp.size() != 0)
		{
			if (tmp[j] >= pow(2, n))
			{
				big.push_back(tmp[j]);

				if (greatest < tmp[j])
				{
					greatest = tmp[j];
				}

				if (op == 0)
				{
					op = tmp[j] - (int)pow(2, n);
					allBig.push_back(op);
				}
				else
				{
					int sth = tmp[j] - (int)pow(2, n);
					op &= sth;
					allBig.push_back(sth);
				}

				tmp.pop_back();
			}
			else
			{
				break;
			}

			j--;
		}

		if (tmp.size() > 0)
		{
			vector<int> pro;
			size_t i = tmp.size() - 1;

			while (tmp.size() != 0)
			{
				while (n > 0 && floor(log2(op)) < n)
				{
					n--;
				}

				if ((tmp[i] >= pow(2, n) && tmp[i] < pow(2, n + 1)) | tmp[i] == 0)
				{
					pro.push_back(tmp[i]);
					tmp.pop_back();
				}
				else if (tmp[i] >= pow(2, n + 1))
				{
					sml.push_back(tmp[i]);
					tmp.pop_back();
				}
				else if (tmp[i] < pow(2, n))
				{
					op -= pow(2, n);
					i++;
					pro.clear();
				}

				i--;
			}

			if (sml.size() == 0)
			{
				sml = pro;
			}

			//use DP

			for (size_t index = 0; index < sml.size(); ++index)
			{
				for (size_t a = 0; a < big.size(); ++a)
				{
					retVal = max(retVal, sml[index] ^ big[a]);
				}
			}

		}
		else if (allBig.size() > 1)
		{
			if (floor(log2(greatest)) > allBig.size())
			{
				for (size_t index = 0; index <big.size()-1; ++index)
				{
					for (size_t a = index+1; a < big.size(); ++a)
					{
						retVal = max(retVal, big[index] ^ big[a]);
					}
				}
			}
			else
			{
				retVal = findMaximumXOR(allBig);
			}
		}

		return retVal;
	}
};

/*
class Solution {
public:
	int findMaximumXOR(vector<int>& nums) {
		int retVal = 0;
		for (size_t index = 0; index <nums.size() - 1; ++index)
		{
			for (size_t a = index + 1; a < nums.size(); ++a)
			{
				retVal = max(retVal, nums[index] ^ nums[a]);
			}
		}

		return retVal;
	}
};
*/