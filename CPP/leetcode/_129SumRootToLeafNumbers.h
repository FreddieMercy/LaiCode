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
	void sumNumber(TreeNode* root, string s, vector<string> &v) {

		if (root == NULL)
		{
			return;
		}

		s += to_string(root->val);

		if (root->left != NULL)
		{
			sumNumber(root->left, s, v);
		}

		if (root->right != NULL)
		{
			sumNumber(root->right, s, v);
		}

		if (root->left == NULL && root->right == NULL)
		{
			v.push_back(s);
		}
	}
public:
	int sumNumbers(TreeNode* root) {
		string s = "";
		vector<string> v;
		int total = 0;

		sumNumber(root, s, v);

		for (string n : v)
		{
			string k = "";

			size_t i = 0;

			while (n[i] == '0'&& i <= n.length())
			{
				i++;
			}

			if (i == n.length())
			{
				i--;
			}

			k = n.substr(i, n.length() - i);

			total += stoi(k, nullptr, 0);
		}

		return total;
	}
};