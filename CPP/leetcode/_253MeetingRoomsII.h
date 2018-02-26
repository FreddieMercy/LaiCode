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

// Definition for an interval.
 struct Interval {
     int start;
     int end;
     Interval() : start(0), end(0) {}
     Interval(int s, int e) : start(s), end(e) {}
 };

class Solution {
private:
	struct FrontSmallToBig {
		constexpr bool operator()(Interval const & a, Interval const & b) const noexcept
		{
			return a.start > b.start || (a.start == b.start&&a.end>b.end);
		}
	};
	struct BackBigToSmall {
		constexpr bool operator()(Interval const & a, Interval const & b) const noexcept
		{
			return a.end < b.end || (a.end == b.end&&a.start>b.start);
		}
	};
	struct BackSmallToBig {
		constexpr bool operator()(pair<int, priority_queue<Interval, vector<Interval>, BackBigToSmall>> const & a, pair<int,priority_queue<Interval, vector<Interval>, BackBigToSmall>> const & b) const noexcept
		{
			return a.first > b.first;
		}
	};
	priority_queue<Interval, vector<Interval>, FrontSmallToBig> sortAll;
	priority_queue<pair<int, priority_queue<Interval, vector<Interval>, BackBigToSmall>>, vector<pair<int, priority_queue<Interval, vector<Interval>, BackBigToSmall>>>, BackSmallToBig> groups;
public:
	int minMeetingRooms(vector<Interval>& intervals) {
		for (Interval i : intervals) {
			sortAll.push(i);
		}
		while (!sortAll.empty()) {
			priority_queue<Interval, vector<Interval>, BackBigToSmall> tmp;
			if (!groups.empty() && groups.top().first<=sortAll.top().start) {
				pair<int, priority_queue<Interval, vector<Interval>, BackBigToSmall>> t = groups.top();
				tmp = t.second;
				groups.pop();

			}
			tmp.push(sortAll.top());
			groups.push(pair<int, priority_queue<Interval, vector<Interval>, BackBigToSmall>>(tmp.top().end, tmp));
			sortAll.pop();
		}

		return groups.size();
	}
};