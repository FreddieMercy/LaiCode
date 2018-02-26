#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>

using namespace std;

class Solution {//https://leetcode.com/problems/total-hamming-distance/#/solutions
public:
	int totalHammingDistance(vector<int>& nums) {
		int size = nums.size();
		if (size < 2) return 0;
		int ans = 0;
		int *zeroOne = new int[2];
		while (true)
		{
			int zeroCount = 0;
			zeroOne[0] = 0;
			zeroOne[1] = 0;
			for (int i = 0; i < nums.size(); i++)
			{
				if (nums[i] == 0) zeroCount++;
				zeroOne[nums[i] % 2]++;
				nums[i] = nums[i] >> 1;
			}
			ans += zeroOne[0] * zeroOne[1];
			if (zeroCount == nums.size()) return ans;
		}
	}
};

/*
class Solution {

public:

	int totalHammingDistance(vector<int>& nums) {

		int total = 0;

		for (int i = 0; i < nums.size(); i++)
		{
			for (int j = i + 1; j < nums.size(); j++)
			{

				total += (bitset<32>(nums[i]) ^ bitset<32>(nums[j])).count();
			}

		}

		return total;
	}
};
*/
/*

class Solution {

private:

	int useXOR(int i, int j)
	{
		int total = 0;

		int bigger, lesser;

		if (i > j)
		{
			bigger = i;
			lesser = j;
		}
		else
		{
			bigger = j;
			lesser = i;
		}

		while (bigger > 0 | lesser > 0)
		{
			if (bigger == 0 && lesser != 0)
			{
				total++;
				lesser -= pow(2, floor(log2(lesser)));
			}

			else if (bigger != 0 && lesser == 0)
			{
				total++;
				bigger -= pow(2, floor(log2(bigger)));
			}
			else
			{
				if (floor(log2(bigger)) != floor(log2(lesser)))
				{
					total++;

					if (floor(log2(bigger)) > floor(log2(lesser)))
					{
						bigger -= pow(2, floor(log2(bigger)));
					}

					else
					{
						lesser -= pow(2, floor(log2(lesser)));
					}
				}
				else
				{
					bigger -= pow(2, floor(log2(bigger)));
					lesser -= pow(2, floor(log2(lesser)));
				}
			}
		}

		return total;
	}

public:

	int totalHammingDistance(vector<int>& nums) {

		int total = 0;

		for (int i = 0; i < nums.size(); i++)
		{
			for (int j = i + 1; j < nums.size(); j++)
			{
				total += useXOR(nums[i], nums[j]);
			}
		}

		return total;
	}
};

*/