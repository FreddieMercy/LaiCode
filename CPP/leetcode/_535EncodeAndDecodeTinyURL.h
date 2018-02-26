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
private:
	queue<string> q;
public:

	// Encodes a URL to a shortened URL.
	string encode(string longUrl) {
		string s = "";
		for (char c : longUrl) {
			s += c;
			if (s.length() == 2) {
				q.push(s);
				s = "";
			}
		}
		q.push(s);
		s = "";
		for (int i = 0; i < q.size();++i) {
			s += to_string(i);
		}
		return s;
	}

	// Decodes a shortened URL to its original URL.
	string decode(string shortUrl) {
		string s = "";
		while (!q.empty()) {
			s += q.front();
			q.pop();
		}
		return s;
	}
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));