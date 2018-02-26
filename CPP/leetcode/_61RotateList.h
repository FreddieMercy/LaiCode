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

class Solution {
public:
	ListNode * rotateRight(ListNode* head, int k) {
		if (head == NULL) {
			return NULL;
		}

		int size = 1;
		ListNode *root = head;
		ListNode *t = head;
		stack<ListNode *> f;
		while (t!=NULL && t->next!=NULL)
		{
			f.push(t);
			t = t->next;
			size++;
		}

		size = k % size;

		while (size>0)
		{
			f.top()->next = NULL;
			t->next = root;
			root = t;
			t = f.top();
			f.pop();
			size--;
		}

		return root;
	}
};