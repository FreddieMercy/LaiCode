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
using namespace std;

// Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {//https://leetcode.com/problems/binary-tree-maximum-path-sum/#/solutions

private:
	int maxValue;
	int maxPathDown(TreeNode *node) {
		if (node == NULL)
		{
			return 0;
		}

		int left = fmax(0, maxPathDown(node->left));
		int right = fmax(0, maxPathDown(node->right));
		maxValue = fmax(maxValue, left + right + node->val);
		return fmax(left, right) + node->val;
	}

public:
	int maxPathSum(TreeNode *root) {
		maxValue = INT_MIN;
		maxPathDown(root);
		return maxValue;
	}
};