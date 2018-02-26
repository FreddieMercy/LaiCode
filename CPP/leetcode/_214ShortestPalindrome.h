#include <sstream>
using namespace std;


class Solution {

private:

	int findMid(string s) {

		int i = 0;
		int j = s.size() - 1;
		int z = j;

		while (i != j && i<j)
		{
			if (s[i] == s[j])
			{
				i++;
			}
			else
			{
				i = 0;
				j = z;
				z--;
			}

			j--;
		}

		return z;

	}

public:
	string shortestPalindrome(string s) {

		if (s.size()<2)
		{
			return s;
		}

		string s1 = s.substr(findMid(s) + 1, s.size() - findMid(s) - 1);

		reverse(s1.begin(), s1.end());

		return s1 + s;
	}
};
