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

using namespace std;

class Solution {
public:
	int maxArea(vector<int>& height) {
		int water = 0;
		int i = 0, j = height.size() - 1;
		while (i < j) {
			int h = min(height[i], height[j]);
			water = max(water, (j - i) * h);
			while (height[i] <= h && i < j) i++;
			while (height[j] <= h && i < j) j--;
		}
		return water;
	}
};