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
	void shuffleButExcludeHeadAndTail(int head, int tail, vector<int> &array) {
		if (head >= tail) {
			return;
		}
		int mid = (tail - head) / 2 + head;
		reverse(array.begin() + head, array.begin() + mid + 1);
		reverse(array.begin() + mid + 1, array.begin() + tail + 1);
		reverse(array.begin() + head, array.begin() + tail + 1);
		shuffleButExcludeHeadAndTail(head + 1, tail - 1, array);
	}
public:
	vector<int> reorder(vector<int> array) {
		// write your solution here
		if (array.size() <= 2) {
			return array;
		}
		if (array.size() % 2 == 0) {
			shuffleButExcludeHeadAndTail(1, array.size() - 2, array);
		}
		else {
			shuffleButExcludeHeadAndTail(1, array.size() - 3, array);
		}
		return array;
	}
};


//class Solution {//real
//private:
//	void shuffleButExcludeHeadAndTail(int head, int tail, vector<int> &array) {
//		if (head>=tail) {
//			return;
//		}
//		int mid = (tail - head) / 2 + head;
//		reverse(array.begin()+head, array.begin()+mid+1);
//		reverse(array.begin() + mid+1, array.begin() +tail+1);
//		reverse(array.begin()+head, array.begin()+tail+1);
//		shuffleButExcludeHeadAndTail(head+1, tail-1, array);
//	}
//public:
//	vector<int> reorder(vector<int> array) {
//		// write your solution here
//		if (array.size() <= 2) {
//			return array;
//		}
//		if (array.size() % 2 == 0) {
//			shuffleButExcludeHeadAndTail(1, array.size() - 2, array);
//		}
//		else {
//			reverse(array.begin()+array.size() / 2 + 1, array.end());
//			reverse(array.begin() + array.size() / 2 + 1, array.end()-1);
//			shuffleButExcludeHeadAndTail(1, array.size() - 3, array);
//		}
//		return array;
//	}
//};
