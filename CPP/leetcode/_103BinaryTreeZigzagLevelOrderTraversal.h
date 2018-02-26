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

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}

};

class Solution {
private:
	void treeToArray(TreeNode* root, map<int, vector<string>> &m, int index)
	{
		if (root != NULL)
		{
			m[index].push_back(to_string(root->val));
			treeToArray(root->left, m, index + 1);
			treeToArray(root->right, m, index + 1);
		}
		else
		{
			m[index].push_back("null");
		}
	}
public:
	vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
		map<int, vector<string>> m;
		vector<vector<int>> n;
		vector<int> o;

		treeToArray(root, m, 0);

		for (size_t i = 0; i < m.size(); ++i)
		{
			o.clear();
			for (size_t j = 0; j < m[i].size(); ++j)
			{
				if (i % 2 == 0)
				{
					if (m[i][j] != "null")
					{
						o.push_back(stoi(m[i][j], nullptr, 0));
					}
				}
				else
				{
					if (m[i][m[i].size() - 1 - j] != "null")
					{
						o.push_back(stoi(m[i][m[i].size() - 1 - j], nullptr, 0));
					}
				}
			}

			if (o.size() > 0)
			{
				n.push_back(o);
			}
		}

		return n;
	}
};