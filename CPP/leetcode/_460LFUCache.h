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

class LFUCache {
private:
	int _cap;
	map<int, int> m;
	map<int, vector<int>> freq;
	map<int, int> freqTracker;
	map<int, int> rece;

	int round = 0;

	void addOne(int it)
	{
		if (freqTracker.find(it) != freqTracker.end() && freq.find(freqTracker[it])!=freq.end())
		{
			freq[freqTracker[it]].erase(remove(freq[freqTracker[it]].begin(), freq[freqTracker[it]].end(), it), freq[freqTracker[it]].end());
		}
		freqTracker[it]++;
		freq[freqTracker[it]].push_back(it);
		rece[it] = round;
	}

	void erase(int it)
	{
		freq[freqTracker[it]].erase(remove(freq[freqTracker[it]].begin(), freq[freqTracker[it]].end(), it), freq[freqTracker[it]].end());
		freqTracker.erase(it);
		rece.erase(it);
		m.erase(it);
	}

public:
	LFUCache(int capacity) {
		_cap = capacity;
	}

	int get(int key) {
		if (m.find(key) == m.end())
		{
			return -1;
		}

		round++;
		addOne(key);

		return m[key];
	}

	void put(int key, int value) {

		if (_cap <= 0)
		{
			return;
		}

		round++;

		if (get(key) == -1)
		{
			if (_cap <= m.size())
			{

				int min = 0;

				while (freq[min].size() == 0 && min <= round)
				{
					freq.erase(min);
					min++;
				}

				vector<int> v = freq[min];

				if (v.size() > 0)
				{
					int it = INT_MAX;
					int t = INT_MIN;
					for (int x : v)
					{
						if (rece[x] < it)
						{
							it = rece[x];
							t = x;
						}
					}
					erase(t);
				}
			}
		}

		addOne(key);

		m[key] = value;
	}
};