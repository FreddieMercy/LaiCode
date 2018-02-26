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
#include <utility>
#include <stdint.h>
#include <algorithm>
#include <stack>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
private:
	map<TreeNode *, int> lm;
	map<TreeNode *, int> rm;
	int leftMost(TreeNode *root)
	{
		int _max = root->val;

		if (lm.find(root) != lm.end())
		{
			return lm[root];
		}

		if (root->left != NULL)
		{
			_max = min(_max, leftMost(root->left));
		}

		lm[root] = _max;

		return _max;
	}

	int rightMost(TreeNode *root)
	{
		int _max = root->val;

		if (rm.find(root) != rm.end())
		{
			return rm[root];
		}

		if (root->right != NULL)
		{
			_max = max(_max, rightMost(root->right));
		}

		rm[root] = _max;

		return _max;
	}

public:
	bool isValidBST(TreeNode* root) {

		if (NULL == root)
		{
			return true;
		}

		if ((root->left != NULL && rightMost(root->left) >= root->val) || (root->right != NULL && leftMost(root->right) <= root->val))
		{
			return false;
		}

		return isValidBST(root->left) && isValidBST(root->right);
	}
};