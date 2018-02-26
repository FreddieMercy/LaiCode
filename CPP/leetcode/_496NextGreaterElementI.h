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

using namespace std;

class Solution {
public:
	vector<int> nextGreaterElement(vector<int>& findNums, vector<int>& nums) {

		map<int, int> m;
		vector<int> retVal;

		for (int n : nums)
		{
			if (m.find(n) == m.end())
			{
				//not found

				m[n] = -1;
			}


			for (map<int, int>::iterator i = m.begin(); i != m.end(); ++i)
			{
				//found

				if (i->first < n && i->second == -1)
				{
					m[i->first] = n;
				}

			}
		}

		for (int n : findNums)
		{
			retVal.push_back(m[n]);
		}

		return retVal;
	}
};