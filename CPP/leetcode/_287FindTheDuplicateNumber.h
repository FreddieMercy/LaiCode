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
	int findDuplicate(vector<int>& nums) {

		vector<int> uniq = nums;
		sort(uniq.begin(), uniq.end());

		int cur = 0;

		for (int n : uniq)
		{
			if (n != cur)
			{
				cur = n;
			}
			else
			{
				return n;
			}
		}
	}
};