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

class TwoSum {
private:
	map<int, int> sum;
public:
	/** Initialize your data structure here. */
	TwoSum() {

	}

	/** Add the number to an internal data structure.. */
	void add(int number) {
		sum[number]++;
	}

	/** Find if there exists any pair of numbers which sum is equal to the value. */
	bool find(int value) {
		for (map<int, int>::iterator it = sum.begin(); it != sum.end();++it) {
			if ((value - it->first != it->first || it->second >= 2) && sum.find(value - it->first) != sum.end()) {
				return true;
			}
		}
		return false;
	}
};

/**
* Your TwoSum object will be instantiated and called as such:
* TwoSum obj = new TwoSum();
* obj.add(number);
* bool param_2 = obj.find(value);
*/