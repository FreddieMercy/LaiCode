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


// Definition for undirected graph.
struct UndirectedGraphNode {
	int label;
	vector<UndirectedGraphNode *> neighbors;
	UndirectedGraphNode(int x) : label(x) {};
};

class Solution {
private:
	map<UndirectedGraphNode *, UndirectedGraphNode *>m;
public:
	UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
		if (node == NULL)
		{
			return NULL;
		}

		if (m.find(node) == m.end())
		{
			m[node] = new UndirectedGraphNode(node->label);
			for (UndirectedGraphNode *x : node->neighbors)
			{
				m[node]->neighbors.push_back(cloneGraph(x));
			}
		}

		return m[node];
	}
};