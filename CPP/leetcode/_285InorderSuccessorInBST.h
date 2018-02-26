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
 public:
	 TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
		 TreeNode *tmp = root;
		 stack<TreeNode *> s;
		 while (tmp->val != p->val) {
			 s.push(tmp);
			 if (tmp->val > p->val) {
				 tmp = tmp->left;
			 }
			 else {
				 tmp = tmp->right;
			 }
		 }
		 if (tmp->right!=NULL) {
			 tmp = tmp->right;
			 while (tmp->left != NULL) {
				 tmp = tmp->left;
			 }
		 }
		 else {
			 while (!s.empty()&&tmp==s.top()->right)
			 {
				 tmp = s.top();
				 s.pop();
			 }
			 if (s.empty()) {
				 tmp = NULL;
			 }
			 else {
				 tmp = s.top();
			 }
		 }
		 return tmp;
	 }
 };