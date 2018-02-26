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


//Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
private:
	void treeToArray(TreeNode* root, map<int, vector<int>> &m, int index)
	{
		if (root != NULL)
		{
			m[index].push_back(root->val);
			treeToArray(root->left, m, index + 1);
			treeToArray(root->right, m, index + 1);
		}
	}
public:
	vector<vector<int>> levelOrder(TreeNode* root) {
		map<int, vector<int>> m;
		vector<vector<int>> n;
		vector<int> o;

		treeToArray(root, m, 0);

		for (size_t i = 0; i < m.size(); ++i)
		{
			o.clear();
			for (size_t j = 0; j < m[i].size(); ++j)
			{
				o.push_back(m[i][j]);
			}

			if (o.size() > 0)
			{
				n.push_back(o);
			}
		}

		return n;
	}
};