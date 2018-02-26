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
	map<int, vector<int>> z;
	bool hasCircle(pair<int, int> n)
	{
		if (z.find(n.second) == z.end())
		{
			return false;
		}

		if (find(z[n.second].begin(), z[n.second].end(), n.first) != z[n.second].end())
		{
			return true;
		}

		for (int s : z[n.second])
		{
			if (hasCircle(pair<int, int>(n.first, s)))
			{
				return true;
			}
		}

		return false;
	}
public:
	bool canFinish(int numCourses, vector<pair<int, int>>& prerequisites) {
		vector<int> m;

		for (pair<int, int> n : prerequisites)
		{
			if (find(m.begin(), m.end(), n.first) == m.end())
			{
				m.push_back(n.first);
				z[n.first] = vector<int>();
			}

			z[n.first].push_back(n.second);

			if (find(m.begin(), m.end(), n.second) == m.end())
			{
				m.push_back(n.second);
			}

			if (hasCircle(n))
			{
				return false;
			}

		}

		if (numCourses >= m.size())
		{
			return true;
		}

		return false;
	}
};
