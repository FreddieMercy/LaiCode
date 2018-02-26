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

// Definition for binary tree with next pointer.
struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};


class Solution {
private:
	void treeToArray(TreeLinkNode* root, map<int, vector<TreeLinkNode *>> &m, int index)
	{
		if (root != NULL)
		{
			m[index].push_back(root);
			treeToArray(root->left, m, index + 1);
			treeToArray(root->right, m, index + 1);
		}
	}

	void levelOrder(TreeLinkNode* root) {

		map<int, vector<TreeLinkNode *>> m;

		treeToArray(root, m, 0);

		for (size_t i = 0; i < m.size(); ++i)
		{
			for (size_t j = 0; j < m[i].size() - 1; ++j)
			{
				m[i][j]->next = m[i][j + 1];
			}

			m[i][m[i].size() - 1]->next = NULL;
		}
	}

public:
	void connect(TreeLinkNode *root) {

		levelOrder(root);
	}
};



