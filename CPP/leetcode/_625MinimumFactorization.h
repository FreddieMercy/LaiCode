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

	vector<int> toPrime(int n)
	{
		vector<int> v;

		while (n % 2 == 0)
		{
			v.push_back(2);
			n = n / 2;
		}

		while (n % 3 == 0)
		{
			v.push_back(3);
			n = n / 3;
		}

		for (int i = 5; i <= sqrt(n); i = i + 2)
		{
			while (n%i == 0)
			{
				if (i > 7)
				{
					v.clear();
					return v;
				}

				v.push_back(i);
				n = n / i;
			}
		}

		if (n > 2)
		{
			if (n > 7)
			{
				v.clear();
				return v;
			}

			v.push_back(n);
		}

		return v;
	}

	int getAnsV(vector<int> v)
	{
		string s = "";
		for (int n : v)
		{
			s += to_string(n);
		}

		try
		{
			return stoi(s, nullptr, 0);
		}
		catch (exception)
		{
			return 0;
		}
	}

	int getAnsQ(priority_queue<int, vector<int>, greater<int>> v)
	{
		string s = "";
		while (!v.empty())
		{
			int n = v.top();
			v.pop();
			s += to_string(n);
		}

		try
		{
			return stoi(s, nullptr, 0);
		}
		catch (exception)
		{
			return 0;
		}
	}
public:
	int smallestFactorization(int a) {
		if (a <= 0)
		{
			return 0;
		}

		if (a < 10)
		{
			return a;
		}

		vector<int> v = toPrime(a);

		if (v.size() < 2)
		{
			return 0;
		}

		size_t i = v.size() - 1;

		while (i != 0 && v[0] * v[i] >= 10)
		{
			--i;
		}

		if (i == 0)
		{
			return getAnsV(v);
		}


		priority_queue<int, vector<int>, greater<int>> q;

		for (size_t j = i + 1; j < v.size(); ++j)
		{
			q.push(v[j]);
		}

		int z = v[0];
		int num4or6 = 0;

		for (size_t j = 1; j <= i; ++j)
		{
			while (j <= i && z * v[j] < 10)
			{
				z *= v[j];
				++j;
			}

			if (z == 4 || z == 6)
			{
				num4or6 = z;
			}
			else
			{
				q.push(z);
			}

			if (j <= i)
			{
				z = v[j];
			}
			else
			{
				z = -1;
			}
		}

		if (z > 0)
		{
			q.push(z);
		}

		if (q.top() == 3)
		{
			int num3 = q.top();
			q.pop();

			if (num4or6 != 0)
			{
				vector<int> tmp = toPrime(num3*num4or6);

				int a = tmp[1] * tmp[2];
				int b = tmp[0] * a;
				if (b >= 10)
				{
					q.push(tmp[0]);
					q.push(a);
				}
				else
				{
					q.push(b);
				}
			}
			else
			{
				q.push(num3);
			}
		}
		else if (num4or6 != 0)
		{
			q.push(num4or6);
		}

		return getAnsQ(q);
	}
};