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
	void a(TreeNode* root, vector<int> &v)
	{
		if (root != NULL)
		{
			if (root->left != NULL)
			{
				a(root->left, v);
			}
			v.push_back(root->val);
			if (root->right != NULL)
			{
				a(root->right, v);
			}
		}
	}
public:
	vector<int> inorderTraversal(TreeNode* root) {
		vector<int> v;
		a(root, v);
		return v;
	}
};