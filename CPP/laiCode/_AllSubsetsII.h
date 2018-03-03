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
	void findAllPermutationButStartNotSame(string input, int index, vector<string> &v) {
		if (index >= input.length()) {
			return;
		}
		int cur = v.size() - 1;
		for (int i = index; i < input.length(); ++i) {

			v.push_back(v[cur] + input[i]);
			findAllPermutationButStartNotSame(input, i + 1, v);
			while (i < input.length() - 1 && input[i] == input[i + 1]) {
				i++;
			}
		}
	}
public:
	vector<string> solve(string input) {
		sort(input.begin(), input.end());
		vector<string> ans = { "" };
		findAllPermutationButStartNotSame(input, 0, ans);

		return ans;
	}
};
