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
	vector<int> preorderTraversals(TreeNode* root, vector<int> &v) {

		if (NULL == root)
		{
			return v;
		}

		v.push_back(root->val);

		if (root->left != NULL)
		{
			preorderTraversals(root->left, v);
		}
		if (root->right != NULL)
		{
			preorderTraversals(root->right, v);
		}

		return v;
	}
public:
	vector<int> preorderTraversal(TreeNode* root) {

		vector<int> v;

		preorderTraversals(root, v);

		return v;
	}
};