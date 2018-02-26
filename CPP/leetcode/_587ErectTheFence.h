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

// Definition for a point.

struct Point {
	int x;
	int y;
	Point() : x(0), y(0) {}
	Point(int a, int b) : x(a), y(b) {}
};


class Solution {
private:
	struct CompareByFirst {
		constexpr bool operator()(const Point &x, const Point &y)
		{
			return x.x < y.x || (!(y.x < x.x) && x.y < y.y);
		}
	};

	priority_queue<Point, vector<Point>, CompareByFirst> _queue;

	double Slop(Point x, Point y)
	{
		if (x.x == y.x)
		{
			return 0;
		}
		return (double)(y.y - x.y) / (double)(y.x - x.x);
	}

public:
	vector<Point> outerTrees(vector<Point>& points) {
		for (Point x : points)
		{
			_queue.push(x);
		}

		vector<Point> total;

		while (!_queue.empty())
		{
			total.push_back(_queue.top());
			_queue.pop();
		}

		vector<Point> U, L;

		for (Point x : total)
		{
			while (L.size() > 1 &&
				(
				(
					x.x != L[L.size() - 1].x && L[L.size() - 2].x != L[L.size() - 1].x && Slop(L[L.size() - 2], L[L.size() - 1]) < Slop(L[L.size() - 1], x) ||
					x.x == L[L.size() - 1].x && Slop(L[L.size() - 2], L[L.size() - 1]) < Slop(L[L.size() - 2], x)
					)

					)
				)
			{

				L.pop_back();
			}
			L.push_back(x);

		}

		for (int i = total.size() - 1; i >= 0; --i)
		{
			while (U.size() > 1 &&
				(
				(
					total[i].x != U[U.size() - 1].x && U[U.size() - 2].x != U[U.size() - 1].x && Slop(U[U.size() - 2], U[U.size() - 1]) < Slop(U[U.size() - 1], total[i]) ||
					total[i].x == U[U.size() - 1].x && Slop(U[U.size() - 2], U[U.size() - 1]) < Slop(U[U.size() - 2], total[i])
					)
					)
				)
			{
				U.pop_back();
			}

			U.push_back(total[i]);
		}

		for (Point x : L)
		{
			_queue.push(x);
		}

		for (Point x : U)
		{
			_queue.push(x);
		}

		total.clear();

		while (!_queue.empty())
		{
			if (total.size() == 0 || total[total.size() - 1].x != _queue.top().x || total[total.size() - 1].y != _queue.top().y)
			{
				total.push_back(_queue.top());
			}
			_queue.pop();
		}

		return total;
	}
};