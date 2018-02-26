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


// Definition for singly-linked list.
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

// Definition for a binary tree node.
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {

private:

	TreeNode* ToBST(vector<TreeNode *> v)
	{
		if (v.size() < 2)
		{
			if (v.size() == 1)
			{
				return v[0];
			}

			return NULL;
		}

		TreeNode *root = v[v.size() / 2];
		root->left = ToBST(vector<TreeNode *>(v.begin(), v.begin() + v.size() / 2));
		root->right = ToBST(vector<TreeNode *>(v.begin() + v.size() / 2 + 1, v.end()));

		return root;
	}

public:

	TreeNode* sortedListToBST(ListNode* head) {

		if (head == NULL)
		{
			return NULL;
		}

		vector<TreeNode *> v;

		while (head != NULL)
		{
			TreeNode *tree = new TreeNode(head->val);
			v.push_back(tree);
			head = head->next;
		}

		return ToBST(v);
	}

	//TreeNode* sortedListToBST(ListNode* head) {

	//	if (head == NULL)
	//	{
	//		return NULL;
	//	}

	//	size_t guide = 0;
	//	vector<vector<TreeNode *>> v;
	//	ListNode *root = head;

	//	v.push_back(vector<TreeNode *>());

	//	while (root != NULL)
	//	{
	//		TreeNode *tree = new TreeNode(root->val);

	//		if (v[v.size() - 1].size() < (size_t)pow(2, v.size() - 1))
	//		{
	//			if (v.size() > 1)
	//			{
	//				TreeNode *tmp = v[v.size() - 2][guide];
	//				if (tmp->left == NULL)
	//				{
	//					tmp->left = tree;
	//				}
	//				else if (tmp->right == NULL)
	//				{
	//					tmp->right = tree;
	//				}
	//				else
	//				{
	//					guide++;
	//					v[v.size() - 2][guide]->left = tree;
	//				}
	//			}

	//		}
	//		else
	//		{
	//			guide = 0;
	//			v.push_back(vector<TreeNode *>());
	//			v[v.size() - 2][guide]->left = tree;
	//		}

	//		v[v.size() - 1].push_back(tree);
	//		root = root->next;
	//	}

	//	return v[0][0];
	//	
	//}
};
