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
	struct Big {
		constexpr bool operator()(pair<uint32_t, uint32_t> const & a, pair<uint32_t, uint32_t> const & b) const noexcept
		{
			return a.first < b.first;
		}
	};
	struct Small {
		constexpr bool operator()(pair<uint32_t, uint32_t> const & a, pair<uint32_t, uint32_t> const & b) const noexcept
		{
			return a.second > b.second || (a.second > b.second&&a.first> b.first);
		}
	};

public:
	int scheduleCourse(vector<vector<int>>& courses) {

		if (courses.size() == 0)
		{
			return 0;
		}

		uint32_t total = 0, counter = 0;
		priority_queue<pair<uint32_t, uint32_t>, vector<pair<uint32_t, uint32_t>>, Small> _pools;
		priority_queue<pair<uint32_t, uint32_t>, vector<pair<uint32_t, uint32_t>>, Big> _using;

		for (size_t i = 0; i < courses.size(); ++i)
		{
			if (courses[i][1] >= courses[i][0])
			{
				_pools.push(pair<uint32_t, uint32_t>(courses[i][0], courses[i][1]));
			}
		}

		while (!_pools.empty())
		{
			if (total + _pools.top().first <= _pools.top().second)
			{
				total += _pools.top().first;
				_using.push(_pools.top());
				counter++;
			}
			else
			{
				if (!_using.empty() && _using.top().first > _pools.top().first)
				{
					total -= _using.top().first;
					pair<uint32_t, uint32_t> tmp = _using.top();
					_using.pop();
					total += _pools.top().first;
					_using.push(_pools.top());
				}
			}

			_pools.pop();
		}

		return counter;
	}
};

//class Solution {
//private:
//	struct Big {
//		constexpr bool operator()(pair<uint32_t, uint32_t> const & a, pair<uint32_t, uint32_t> const & b) const noexcept
//		{
//			return a.first < b.first;
//		}
//	};
//	struct Small {
//		constexpr bool operator()(pair<uint32_t, uint32_t> const & a, pair<uint32_t, uint32_t> const & b) const noexcept
//		{
//			return a.second > b.second || (a.second > b.second&&a.first> b.first);
//		}
//	};
//
//	struct SmallDate {
//		constexpr bool operator()(pair<uint32_t, uint32_t> const & a, pair<uint32_t, uint32_t> const & b) const noexcept
//		{
//			return a.first> b.first;
//		}
//	};
//public:
//	int scheduleCourse(vector<vector<int>>& courses) {
//
//		if (courses.size() == 0)
//		{
//			return 0;
//		}
//
//		uint32_t total = 0, counter = 0;
//		map<uint32_t, priority_queue<pair<uint32_t, uint32_t>, vector<pair<uint32_t, uint32_t>>, SmallDate>> m;
//		priority_queue<pair<uint32_t, uint32_t>, vector<pair<uint32_t, uint32_t>>, Small> _pools;
//		priority_queue<pair<uint32_t, uint32_t>, vector<pair<uint32_t, uint32_t>>, Big> _using;
//
//		for (size_t i = 0; i < courses.size(); ++i)
//		{
//			//if (courses[i][1] >= courses[i][0])
//			//{
//				_pools.push(pair<uint32_t, uint32_t>(courses[i][0], courses[i][1]));
//
//			//}
//		}
//
//		while (!_pools.empty())
//		{
//			if (total + _pools.top().first <= _pools.top().second)
//			{
//				total += _pools.top().first;
//				_using.push(_pools.top());
//				counter++;
//			}
//			else
//			{
//				if (!_using.empty() && _using.top().first > _pools.top().first)
//				{
//					total -= _using.top().first;
//					pair<uint32_t, uint32_t> tmp = _using.top();
//					_using.pop();
//					total += _pools.top().first;
//					_using.push(_pools.top());
//
//					if (m.find(tmp.second) != m.end())
//					{
//						while (!m[tmp.second].empty() && total + m[tmp.second].top().first <= _pools.top().second)
//						{
//							total += m[tmp.second].top().first;
//							_using.push(m[tmp.second].top());
//							counter++;
//						}
//					}
//				}
//				else
//				{
//					m[_pools.top().second].push(_pools.top());
//				}
//			}
//
//			_pools.pop();
//		}
//
//		return counter;
//	}
//};