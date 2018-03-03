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
private:
	vector<string> findAllCurrentPermutation(string input, int index) {
		vector<string> ans;
		set<char> used;
		if (input.length() - 1 == index) {
			return { string(1, input[index]) };
		}
		for (int i = index; i < input.length(); ++i) {

			if (used.insert(input[i]).second) {
				swap(input[index], input[i]);
				for (string s : findAllCurrentPermutation(input, index + 1)) {
					ans.push_back(input[index] + s);
				}
				swap(input[index], input[i]);
			}
		}

		return ans;
	}
public:
	vector<string> solve(string input) {
		if (input.length() == 0) {
			return { "" };
		}
		sort(input.begin(), input.end());
		return findAllCurrentPermutation(input, 0);
	}
};