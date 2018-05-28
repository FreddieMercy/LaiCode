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
#include <string.h>

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
	int findHeight(TreeNode* root) {
		if (root == NULL) {
			return 0;
		}

		return max(findHeight(root->left), findHeight(root->right)) + 1;
	}
};
