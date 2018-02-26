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
// Definition for a binary tree node.
 struct TreeNode {
     int val;
     TreeNode *left;
     TreeNode *right;
     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 };

class Solution {
public:
	TreeNode* mergeTrees(TreeNode* t1, TreeNode* t2) {
		if (t1 == NULL&&t2 == NULL) {
			return NULL;
		}
		TreeNode *tree = (TreeNode *)malloc(sizeof(TreeNode));
		TreeNode *left1 = NULL, *left2 = NULL, *right1 = NULL, *right2 = NULL;
		int x = 0;
		int y = 0;
		if (t1 != NULL) {
			x = t1->val;
			left1 = t1->left;
			left2 = t1->right;
		}
		if (t2 != NULL) {
			y = t2->val;
			right1 = t2->left;
			right2 = t2->right;
		}
		tree->val = x + y;
		tree->left = mergeTrees(left1 , right1);
		tree->right = mergeTrees(left2, right2);

		return tree;
	}
};