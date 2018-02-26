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

class Solution {
public:
	int findMaximizedCapital(int k, int W, vector<int>& Profits, vector<int>& Capital) {
		
		map<int, priority_queue<int>> m;
		set<int> tmp(Capital.begin(), Capital.end());
		//sort(tmp.begin(), tmp.end());
		priority_queue<int, vector<int>, greater<int>> q(tmp.begin(), tmp.end());
		priority_queue<int> now;

		for (int i = 0; i < Profits.size();++i) {
			if (W>=Capital[i]) {
				now.push(Profits[i]);
			}
			else {
				m[Capital[i]].push(Profits[i]);
			}
		}

		while (k > 0 && (now.size() > 0||(q.size()>0&&W>=q.top())))
		{
			while(q.size()>0&&W >= q.top()) {
				while (m[q.top()].size()>0) {
					now.push(m[q.top()].top());
					m[q.top()].pop();
				}
				q.pop();
			}
			if (now.size() > 0) {
				W += now.top();
				now.pop();
				k--;
			}
		}

		return W;
	}
};