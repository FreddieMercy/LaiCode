#include <iostream>
#include <functional>
#include <vector>
#include <queue>
#include <fstream>
#include <string>
#include <bitset>
#include <sstream>

using namespace std;

class Solution {
public:
	int arrangeCoins(int n) {
		int retVal = 0;

		while ((1+retVal)*((double)retVal/2) <= n)
		{
			retVal+=2;
		}

		retVal--;

		if ((1 + retVal)*((double)retVal / 2) <= n)
		{
			return retVal;
		}

		return --retVal;
	}
};

/*
class Solution {
public:
	int arrangeCoins(int n) {
		int retVal = 0;
		int tmp = 1;
		int exist = 0;

		while (tmp + exist <= n)
		{
			for (int i = 0; i < tmp; i++)
			{
				cout << "¤ ";
				exist++;
			}

			cout << "\n";

			tmp++;
			retVal++;
		}

		for (int i = 0; i < n - exist; i++)
		{
			cout << "¤ ";
		}

		cout << "\n";

		return retVal;
	}
};

*/