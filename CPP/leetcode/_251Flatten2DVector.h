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

class Vector2D {
private:
	vector<vector<int>> v;
public:
	Vector2D(vector<vector<int>>& vec2d) {
		v = vec2d;
		vector<int> tmp;
		v.erase(remove(v.begin(), v.end(), tmp), v.end());
	}

	int next() {
		int i = v[0][0];
		v[0].erase(v[0].begin());
		if (v[0].empty()) {
			v.erase(v.begin());
		}
		return i;
	}

	bool hasNext() {
		return !v.empty();
	}
};

/**
* Your Vector2D object will be instantiated and called as such:
* Vector2D i(vec2d);
* while (i.hasNext()) cout << i.next();
*/

/**
* Your Vector2D object will be instantiated and called as such:
* Vector2D i(vec2d);
* while (i.hasNext()) cout << i.next();
*/