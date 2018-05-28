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

class Solution {
public:
	int evalRPN(vector<string> tokens) {
		// write your solution here

		stack<int> stk;
		for (vector<string>::iterator it = tokens.begin(); it != tokens.end(); ++it) {
			if (*it == "+" || *it == "-" || *it == "*" || *it == "/")
			{
				int b = stk.top();
				stk.pop();
				int a = stk.top();
				stk.pop();
				if (*it == "+") {
					stk.push(a + b);
				}
				else if (*it == "-") {

					stk.push(a - b);
				}
				else if (*it == "*") {

					stk.push(a * b);
				}
				else {

					stk.push(a / b);
				}
			}
			else {
				stk.push(stoi(*it, nullptr, 10));
			}
		}

		return stk.top();
	}
};
