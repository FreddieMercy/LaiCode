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

using namespace std;

class Solution {
public:
	string licenseKeyFormatting(string J, int K) {
		string S = J;

		S.erase(remove(S.begin(), S.end(), '-'), S.end());

		int first = S.length() % K;
		int rest = S.length() - first;
		int i = 0;
		string T = "";

		if (first != 0)
		{
			while (first > 0)
			{
				T += S[i];
				i++;
				first--;
			}

			T += "-";
		}

		while (rest > 0)
		{
			for (size_t j = 0; j < K; ++j)
			{
				T += S[i];
				i++;
				rest--;
			}

			T += "-";
		}

		if (T.length() > 1 && T[T.length() - 1] == '-')
		{
			T = T.substr(0, T.length() - 1);
		}

		for (string::size_type index = 0; index < T.length(); ++index)
		{
			T[index] = toupper(T[index]);
		}

		return T;
	}
};