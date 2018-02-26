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
#include <set>

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
	void bT(TreeNode *root, vector<string> &v, string &l, string &r)
	{
		if (NULL == root)
		{
			return;
		}

		l += to_string(root->val);
		r += to_string(root->val);

		if (root->left == NULL && root->right == NULL)
		{
			v.push_back(l);
			return;
		}

		if (root->left != NULL)
		{

			l += "->";
			string tmp = l;
			bT(root->left, v, l, tmp);

		}

		if (root->right != NULL)
		{

			r += "->";
			string tmp = r;
			bT(root->right, v, r, tmp);
		}

	}

public:
	vector<string> binaryTreePaths(TreeNode* root) {
		vector<string> s;
		string l = "";
		string r = "";
		bT(root, s, l, r);
		return s;
	}
};