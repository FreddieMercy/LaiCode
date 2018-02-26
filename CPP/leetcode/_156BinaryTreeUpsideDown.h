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
public:
	TreeNode* upsideDownBinaryTree(TreeNode* root) {
		TreeNode *tmp = root;
		stack<TreeNode *> s;
		while (tmp != NULL&&tmp->left != NULL) {
			s.push(tmp);
			tmp = tmp->left;
		}
		TreeNode *ans = tmp;
		while (!s.empty()) {
			TreeNode *node = s.top();
			s.pop();
			tmp->right = node;
			tmp->left = node->right;
			node->left = NULL;
			node->right = NULL;
			tmp = tmp->right;
		}
		return ans;
	}
};