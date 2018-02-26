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

class MedianFinder {//https://leetcode.com/problems/find-median-from-data-stream/#/solutions
	priority_queue<long> small, large;
public:

	void addNum(int num) {
		small.push(num);
		large.push(-small.top());
		small.pop();
		if (small.size() < large.size()) {
			small.push(-large.top());
			large.pop();
		}
	}

	double findMedian() {
		return small.size() > large.size()
			? small.top()
			: (small.top() - large.top()) / 2.0;
	}
};

/*
class MedianFinder {
private:
	vector<int> heap;
public:
	
	MedianFinder() {

	}

	void addNum(int num) {
		heap.push_back(num);
	}

	double findMedian() {

		sort(heap.begin(), heap.end());

		if (heap.size() % 2 == 0)
		{
			return (double)(heap[heap.size() / 2] + heap[heap.size() / 2 - 1]) / 2;
		}

		return heap[heap.size() / 2];
	}
};
*/