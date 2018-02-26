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
	int maxRotateFunction(vector<int>& A) {
		int total = 0;
		for (int i : A) {
			total += i;
		}
		int result = 0;
		for (int i = 1; i < A.size();++i) {
			result += i*A[i];
		}
		int tmp = result;
		for (int i = 1; i < A.size();++i) {
			tmp = tmp + total - A[(int)A.size() - (int)i] * (int)A.size();
			result = max(result, tmp);
		}
		return result;
	}
};