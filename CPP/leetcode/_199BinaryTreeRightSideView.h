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
	map<int, int> m;
	void rightSideView_helper(TreeNode* root, int level = 0) {
		if (root == NULL) {
			return;
		}
		if (m.find(level) == m.end()) {
			m[level] = root->val;
		}
		rightSideView_helper(root->right, level + 1);
		rightSideView_helper(root->left, level + 1);
	}
public:
	vector<int> rightSideView(TreeNode* root) {
		rightSideView_helper(root);
		vector<int> ans;

		for (int i = 0; i < m.size();++i) {
			ans.push_back(m[i]);
		}
		return ans;
	}
};