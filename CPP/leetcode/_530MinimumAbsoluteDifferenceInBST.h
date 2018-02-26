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
	vector<int> v;
	void add(TreeNode *root) {
		if (root != NULL) {
			v.push_back(root->val);
			add(root->left);
			add(root->right);
		}
	}
public:
	int getMinimumDifference(TreeNode* root) {
		add(root);
		sort(v.begin(), v.end());
		int ans = INT_MAX;
		for (int i = 1; i < v.size(); ++i) {
			ans = min(ans, abs(v[i - 1] - v[i]));
		}

		return ans;
	}
};