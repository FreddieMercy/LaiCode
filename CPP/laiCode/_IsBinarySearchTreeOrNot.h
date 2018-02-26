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


class TreeNode {
 public:
  int value;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int v) : value(v), left(NULL), right(NULL) {}
};

class Solution {
public:
	bool isBST(TreeNode* root, int Limit = INT_MAX, int Parent = INT_MAX, bool isLeft = true, bool isTwist = false) {
		return root == NULL || (((isLeft^isTwist) ? (root->value < Limit) : (root->value > Limit)) && (root->left == NULL || root->left->value<root->value) && (root->right == NULL || root->right->value> root->value) && isBST(root->left, ((!isLeft) ? Parent : root->value), root->value, true, !isLeft) && isBST(root->right, ((isLeft) ? Parent : root->value), root->value, false, isLeft));
	}
};