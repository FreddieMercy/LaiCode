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

using namespace std;


// Definition for singly-linked list.
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {

		if (l1 == NULL&&l2 == NULL)
		{
			return NULL;
		}

		ListNode *f = l1;
		ListNode *s = l2;

		ListNode *b = (ListNode *)malloc(sizeof(ListNode));
		b->next = NULL;
		ListNode *a = b;
		bool carryout = false;


		while (f != NULL && s != NULL)
		{
			int ans = f->val + s->val;

			if (carryout)
			{
				ans++;
				carryout = false;
			}

			if (ans > 9)
			{
				carryout = true;
				ans -= 10;
			}

			a->val = ans;

			f = f->next;
			s = s->next;


			if (f != NULL && s != NULL)
			{
				if (a->next == NULL)
				{
					a->next = (ListNode *)malloc(sizeof(ListNode));
					a->next->next = NULL;
				}

				a = a->next;
			}

		}

		if (f != NULL)
		{
			if (a->next == NULL)
			{
				a->next = (ListNode *)malloc(sizeof(ListNode));
				a->next->next = NULL;
			}

			a = a->next;

			while (f != NULL)
			{
				int ans = f->val;

				if (carryout)
				{
					ans++;
					carryout = false;
				}

				if (ans > 9)
				{
					carryout = true;
					ans -= 10;
				}

				a->val = ans;

				f = f->next;

				if (f != NULL)
				{
					if (a->next == NULL)
					{
						a->next = (ListNode *)malloc(sizeof(ListNode));
						a->next->next = NULL;
					}


					a = a->next;
				}

			}
		}
		else if (s != NULL)
		{
			if (a->next == NULL)
			{
				a->next = (ListNode *)malloc(sizeof(ListNode));
				a->next->next = NULL;
			}

			a = a->next;

			while (s != NULL)
			{
				int ans = s->val;

				if (carryout)
				{
					ans++;
					carryout = false;
				}

				if (ans > 9)
				{
					carryout = true;
					ans -= 10;
				}

				a->val = ans;

				s = s->next;

				if (s != NULL)
				{
					if (a->next == NULL)
					{
						a->next = (ListNode *)malloc(sizeof(ListNode));
						a->next->next = NULL;
					}

					a = a->next;
				}

			}
		}

		if (carryout)
		{
			if (a->next == NULL)
			{
				a->next = (ListNode *)malloc(sizeof(ListNode));
				a->next->next = NULL;
			}

			a = a->next;
			a->val = 1;
		}

		return b;

	}
};