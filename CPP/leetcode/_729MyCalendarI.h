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

class MyCalendar {
	struct node {
		int start, end;
		node *left, *right;
		node(int s, int e) {
			start = s;
			end = e;
			left = right = nullptr;
		}
	};
	node* root;
public:
	MyCalendar() {
		root = new node(-1, 0);
	}

	bool book(int start, int end) {
		node *curr = root;
		while (curr) {
			if (start >= curr->end) {
				if (curr->right)
					curr = curr->right;
				else {
					curr->right = new node(start, end);
					return true;
				}
			}
			else if (end <= curr->start) {
				if (curr->left)
					curr = curr->left;
				else {
					curr->left = new node(start, end);
					return true;
				}
			}
			else return false;
		}
	}
};

/**
* Your MyCalendar object will be instantiated and called as such:
* MyCalendar obj = new MyCalendar();
* bool param_1 = obj.book(start,end);
*/