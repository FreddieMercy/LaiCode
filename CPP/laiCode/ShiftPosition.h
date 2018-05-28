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
	int shiftPosition(vector<int> array, int left, int right) {
		// write your solution here
		if (left + 1 == right) {
			return (array[left]< array[right])?left:right;
		}
		int mid = (right - left) / 2 + left;

		if (array[left] > array[mid]) {
			return shiftPosition(array, left, mid);
		}

		if (array[mid]>array[right]) {
			return shiftPosition(array, mid, right);
		}

		return left;
	}

public:
	int shiftPosition(vector<int> array){
		// write your solution here
		if (array.size() == 0) {
			return -1;
		}
		return shiftPosition(array, 0, array.size() - 1);
	}
};