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
	int totalOccurrence(vector<int> array, int target) {
		// write your solution here
		int left = 0;
		int right = array.size();
		int index=-1;
		while (left < right)
		{
			index = (right - left) / 2 + left;
			if (array[index] == target) {
				break;
			}
			
			if (array[index] > target) {
				right = index;
			}
			else {
				left = index+1;
			}
		}

		int count = 0;
		int tmp = index;
		while (index >= 0 && array[index] == target) {
			count++;
			index--;
		}
		index = tmp+1;
		while (index < array.size()&&array[index] == target) {
			count++;
			index++;
		}
		return count;
	}
};
