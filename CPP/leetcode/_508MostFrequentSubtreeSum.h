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


// Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
private:
	int getSum(TreeNode *root, map<int, int> &m, vector<int> &pi, int &ai)
	{
		int sum = 0;

		if (root == NULL)
		{
			m[sum] = m[sum] + 1;
			if (ai == m[sum])
			{
				pi.push_back(sum);
			}
			else if (m[sum] > ai)
			{
				ai = m[sum];
				pi.clear();
				pi.push_back(sum);
			}
			return sum;
		}

		if (root->left != NULL)
		{
			sum += getSum(root->left, m, pi, ai);
		}

		if (root->right != NULL)
		{
			sum += getSum(root->right, m, pi, ai);
		}

		sum += root->val;
		m[sum] = m[sum] + 1;
		if (ai == m[sum])
		{
			pi.push_back(sum);
		}
		else if (m[sum] > ai)
		{
			ai = m[sum];
			pi.clear();
			pi.push_back(sum);
		}
		return sum;
	}
public:
	vector<int> findFrequentTreeSum(TreeNode* root) {
		map<int, int> m;
		vector<int> pi;
		int ai = 0;

		if (root != NULL)
		{
			int tmp = getSum(root, m, pi, ai);
		}
		return pi;
	}
};
