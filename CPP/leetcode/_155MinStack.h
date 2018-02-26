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

class MinStack {
private:
	stack<int> _s;
	priority_queue<int, vector<int>, greater<int>> _q;

public:
	/** initialize your data structure here. */
	MinStack() {

	}

	void push(int x) {
		_s.push(x);
		_q.push(x);
	}

	void pop() {
		if (_s.size() > 0 && _q.size() > 0)
		{
			vector<int> v;
			int x = _s.top();
			_s.pop();

			while (!_q.empty())
			{
				v.push_back(_q.top());
				_q.pop();
				if (v[v.size() - 1] == x)
				{
					break;
				}
			}

			for (size_t i = 0; i < v.size() - 1; ++i)
			{
				_q.push(v[i]);
			}
		}
	}

	int top() {
		return _s.top();
	}

	int getMin() {
		return _q.top();
	}
};

/**
* Your MinStack object will be instantiated and called as such:
* MinStack obj = new MinStack();
* obj.push(x);
* obj.pop();
* int param_3 = obj.top();
* int param_4 = obj.getMin();
*/
