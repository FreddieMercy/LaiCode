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
private:
	string multi(string &s, int n)
	{
		string s1 = "";

		for (size_t i = 0; i < n; ++i)
		{
			s1 += s;
		}

		return s1;
	}
	bool contains(string s1, string s2)
	{
		if (s2 == "" || s1 == "" || s1.length()<s2.length())
		{
			return false;
		}

		size_t j = 0;

		for (size_t i = 0; i < s1.length(); ++i)
		{
			if (s1[i] == s2[j])
			{
				j++;
			}

			if (j == s2.length())
			{
				return true;
			}
		}

		return false;
	}
	bool isMulti(string x, string y)
	{
		if (y.length() % x.length())
		{
			return false;
		}

		return multi(x, y.length() / x.length()) == y;
	}
	int getFront(map<char, priority_queue<uint64_t, vector<uint64_t>, less<uint64_t>>> m, string &s2)
	{
		string s = s2;
		reverse(s.begin(), s.end());
		int i = INT_MAX;

		for (char c : s)
		{
			while (!m[c].empty() && m[c].top()>i)
			{
				m[c].pop();
			}

			if (!m[c].empty() && m[c].top()<i)
			{
				i = m[c].top();
			}

			if (m[c].empty())
			{
				return 0;
			}
		}

		if (i != INT_MAX)
		{
			return i;
		}
		return 0;
	}
	string repeatCombo(string s2)
	{
		if (s2 == "")
		{
			return "";
		}

		string rep = "";
		uint64_t end = 1;
		rep = s2.substr(0, end);

		while (!(isMulti(rep, s2)) && end <= s2.length())
		{
			end++;
			rep = s2.substr(0, end);
		}

		if (rep == s2)
		{
			return "";
		}

		return rep;
	}
	tuple<uint64_t, bool, pair<uint64_t, uint64_t>> howMany(string s1, string s2)
	{
		map<char, priority_queue<uint64_t, vector<uint64_t>, less<uint64_t>>> m;
		bool half = false;
		pair<uint64_t, uint64_t> len;
		len.first = 0;
		len.second = 0;
		uint64_t start = 0;
		uint64_t end = 1;
		uint64_t M = 0;
		string x = s1;

		while (start + end <= x.length())
		{
			while (!contains(x.substr(start, end), s2) && start + end <= x.length())
			{
				if (!M)
				{
					m[x[end - 1]].push(end - 1);
				}

				end++;
			}

			if (!M)
			{
				m[x[end - 1]].push(end - 1);
			}

			if (contains(x.substr(start, end), s2))
			{
				M++;
				start += end;
				end = 1;
			}
		}

		string rep = repeatCombo(s2);

		if (rep == "")
		{
			half = contains(x.substr(start, end - 1) + x.substr(0, getFront(m, s2)), s2);
		}
		else
		{
			len.first = get<0>(howMany(x.substr(start, end - 1), rep)); //have
			len.second = s2.length() / rep.length(); //need
		}

		return tuple<uint64_t, bool, pair<uint64_t, uint64_t>>(M, half, len);
	}

public:
	int getMaxRepetitions(string s1, int n1, string s2, int n2) {

		if (s2 == "" || s1 == "" || n1 == 0 || n2 == 0)
		{
			return 0;
		}

		string x = s1;
		int x1 = n1 - 1;

		while (!contains(x, s2) && x1 > 0)
		{
			x += s1;
			x1--;
		}

		tuple<uint64_t, bool, pair<uint64_t, uint64_t>> t = howMany(x, s2);
		uint64_t M = get<0>(t);

		if (!M)
		{
			return 0;
		}

		uint64_t x2 = (uint64_t)(n1 / (n1 - x1));

		if (x2 == 1)
		{
			return (int)((M * x2) / n2);
		}

		if (!get<1>(t) && get<2>(t).second == 0)
		{
			if ((n1 - x1 >= 2) && (M == 1 && (((n1 - x1) * 2 - 1 - 1) / (n1 - x1 - 1)) == get<0>(howMany(multi(s1, (n1 - x1) * 2 - 1), s2))))
			{
				return (int)(((n1 - 1) / (n1 - x1 - 1)) / n2);
			}

			return (int)((M * x2) / n2);
		}

		if (get<1>(t))
		{
			return (int)(((M + 1)*x2 - 1) / n2);
		}

		return (int)((M * x2 + (uint64_t)(x2*get<2>(t).first / get<2>(t).second)) / n2);
	}
};