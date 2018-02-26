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

using namespace std;

class Solution {
public:
	double findMedianSortedArrays(vector<int>& numsx, vector<int>& numsy) {

		vector<int> nums1 = numsx;
		vector<int> nums2 = numsy;

		if (numsx.size() == 0 && numsy.size() == 0)
		{
			return 0;
		}
		else if (numsx.size() == 0)
		{
			nums1.push_back(nums2[nums2.size() - 1]);
		}
		else if (numsy.size() == 0)
		{
			nums2.push_back(nums1[nums1.size() - 1]);
		}


		nums1.push_back(nums1[nums1.size() - 1]);
		nums2.push_back(nums2[nums2.size() - 1]);

		int i = 0, j = 0;
		int total = numsx.size() + numsy.size();
		int mid = total / 2 + 1;
		stack<int> s;

		while (mid > 0)
		{
			if (nums1[i] >= nums2[j])
			{
				if (j < nums2.size() - 1)
				{
					s.push(nums2[j]);
					j++;
				}

				else if (i < nums1.size() - 1)
				{
					s.push(nums1[i]);
					i++;
				}
			}
			else
			{
				if (i < nums1.size() - 1)
				{
					s.push(nums1[i]);
					i++;
				}
				else if (j < nums2.size() - 1)
				{
					s.push(nums2[j]);
					j++;
				}
			}
			mid--;
		}

		if (total % 2 == 0)
		{
			int cur = s.top();
			s.pop();
			int next = s.top();
			return (double)(cur + next) / 2;
		}

		return s.top();

	}
};