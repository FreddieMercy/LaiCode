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
	vector<int> twoSum(vector<int>& numbers, int target) {
		int index1 = 0, index2 = numbers.size()-1;

		while (numbers[index1]+numbers[index2]!=target) {
			if (numbers[index1] + numbers[index2] > target) {
				index2--;
			}
			else{
				index1++;
			}
		}

		return {index1+1, index2+1};
	}
};