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
	int search(vector<int> array, int target, int left, int right) {
		// write your solution here
		if (left >= right) {
			return -1;
		}

		int mid = (right - left) / 2 + left;

		if (array[mid] == target) {
			return mid;
		}
		/*
		if (array[left]<=target&&target<array[mid]) {
		return search(array, target, left, mid);
		}

		if (array[mid]<target&&target<= array[right-1]) {
		return search(array, target, mid + 1, right);
		}
		*/
		int tmp = search(array, target, left, mid);

		return (tmp != -1) ? tmp : search(array, target, mid + 1, right);
	}
public:
	int solve(vector<int> array, int target) {
		// write your solution here

		return search(array, target, 0, array.size());
	}
};
