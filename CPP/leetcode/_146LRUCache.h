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

using namespace std;

class LRUCache {
private:
	int _cap;
	map<int, int> m;
	deque<int> heap;

public:
	LRUCache(int capacity) {
		_cap = capacity;
	}

	int get(int key) {
		if (m.find(key) == m.end())
		{
			return -1;
		}

		for (std::deque<int>::iterator it = heap.begin(); it != heap.end(); ++it)
		{
			if (*it == key)
			{
				heap.erase(it);
				heap.push_back(key);
				break;
			}
		}

		return m[key];
	}

	void put(int key, int value) {

		if (_cap <= 0)
		{
			return;
		}

		if (get(key) == -1)
		{
			if (_cap <= m.size())
			{
				m.erase(heap.front());
				heap.erase(heap.begin());
			}

			heap.push_back(key);
		}

		m[key] = value;
	}
};