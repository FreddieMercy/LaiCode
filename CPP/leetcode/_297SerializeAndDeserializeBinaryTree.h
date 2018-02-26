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

class Codec {
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

	// Encodes a tree to a single string.
	string serialize(TreeNode* root) {

		map<int, vector<string>> m;
		string s = "";

		treeToArray(root, m, 0);

		for (size_t i = 0; i < m.size(); ++i)
		{
			for (size_t j = 0; j < m[i].size(); ++j)
			{
				s += m[i][j] + ",";
			}
		}

		return s.substr(0, s.length() - 1);
	}

	// Decodes your encoded data to tree.
	TreeNode* deserialize(string data) {

		vector<string> v;
		string s = "";
		int _log = 0;
		map<int, vector<TreeNode *>> m;
		TreeNode *cur;
		bool nodes = true;
		int nulls[2] = { 0, 0 };

		int now = 0, then = 1;

		for (char c : data)
		{
			if (c != ']'&&c != '[')
			{
				if (c != ',')
				{
					s += c;
				}
				else
				{
					v.push_back(s);
					s = "";
				}
			}
		}

		v.push_back(s);

		for (size_t i = 0; i < v.size(); ++i)
		{
			int tmp = pow(2, _log);

			nulls[now] = 0;

			while (tmp > 0 && i < v.size() && (_log == 0 || m[_log].size() < 2 * nulls[then]))
			{
				TreeNode *t;

				if (v[i] == "null")
				{
					t = NULL;
				}
				else
				{
					t = (TreeNode *)malloc(sizeof(TreeNode));
					t->left = NULL;
					t->right = NULL;
					t->val = stoi(v[i], nullptr, 0);
					nulls[now]++;
				}

				m[_log].push_back(t);

				i++;

				tmp--;
			}
			swap(now, then);
			i--;
			_log++;
		}

		for (size_t i = 0; i < m.size(); ++i)
		{
			int tracer = 0;
			for (size_t j = 0; j < m[i].size(); ++j)
			{
				cur = m[i][j];

				if (cur != NULL)
				{
					if (m.size() > i+1)
					{
						if (m[i+1].size()>tracer)
						{
							cur->left = m[i + 1][tracer];
						}

						if (m[i + 1].size() > tracer + 1)
						{
							cur->right = m[i + 1][tracer + 1];
						}

						tracer += 2;
					}
				}
			}
		}

		return m[0][0];

	}
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));