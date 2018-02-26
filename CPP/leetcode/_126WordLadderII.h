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

//Solution is in Java

class Node;

typedef vector<string> Ladder;
typedef vector<string> StringSet;
typedef bool(*NodeCmper) (Node*, Node*);
typedef set<Node*, NodeCmper> NodeSet;

class Node
{
public:
	string word;
	vector<Node*> parents;

	Node(string w) : word(w) {}
	void addparent(Node* parent) { parents.push_back(parent); }

	// Yield all children of this node, and:
	//   1) If the child is found in $targetlayer, which means we found ladders that
	//      connect BEGIN-WORD and END-WORD, then we get all paths through this node
	//      to its ROOT node, and all paths through the target child node to its ROOT
	//      node, and combine the two group of paths to a group of ladders, and append
	//      these ladders to $ladders.
	//   2) Elif the $ladders is empty:
	//       2.1) If the child is found in $nextlayer, then get that child, and add
	//            this node to its parents.
	//       2.2) Else, add the child to nextlayer, and add this node to its parents.
	//   3) Else, do nothing.
	void yieldchildren(NodeSet& nextlayer, StringSet& wordlist, NodeSet& targetlayer,
		vector<Ladder>& ladders, bool forward)
	{
		string nextword = word;
		for (int i = 0, n = nextword.length(); i < n; i++) {
			char oldchar = nextword[i];
			for (nextword[i] = 'a'; nextword[i] <= 'z'; nextword[i]++) {
				if (count(wordlist.begin(), wordlist.end(), nextword)) {
					// now we found a valid child-word, let's yield a child.
					Node* child = new Node(nextword);
					yield1(child, nextlayer, targetlayer, ladders, forward);
				}
			}
			nextword[i] = oldchar;
		}
	}

	// yield one child, see comment of function `yieldchildren`
	void yield1(Node* child, NodeSet& nextlayer, NodeSet& targetlayer,
		vector<Ladder>& ladders, bool forward) {
		auto itr = targetlayer.find(child);
		if (itr != targetlayer.end()) {
			for (Ladder path1 : this->getpaths()) {
				for (Ladder path2 : (*itr)->getpaths()) {
					if (forward) {
						ladders.push_back(path1);
						ladders.back().insert(ladders.back().end(), path2.rbegin(), path2.rend());
					}
					else {
						ladders.push_back(path2);
						ladders.back().insert(ladders.back().end(), path1.rbegin(), path1.rend());
					}
				}
			}
		}
		else if (ladders.empty()) {
			auto itr = nextlayer.find(child);
			if (itr != nextlayer.end()) {
				(*itr)->addparent(this);
			}
			else {
				child->addparent(this);
				nextlayer.insert(child);
			}
		}
	}

	vector<Ladder> getpaths()
	{
		vector<Ladder> ladders;
		if (parents.empty()) {
			ladders.push_back(Ladder(1, word));
		}
		else {
			for (Node* parent : parents) {
				for (Ladder ladder : parent->getpaths()) {
					ladders.push_back(ladder);
					ladders.back().push_back(word);
				}
			}
		}
		return ladders;
	}
};

bool nodecmp(Node* pa, Node* pb)
{
	return pa->word < pb->word;
}

class Solution {
public:
	vector<Ladder> findLadders(string begin, string end, StringSet& wordlist) {
		if (find(wordlist.begin(), wordlist.end(), end) == wordlist.end()) {
			return {};
		}
		else {
			wordlist.erase(remove(wordlist.begin(), wordlist.end(), end), wordlist.end());
		}
		if (find(wordlist.begin(), wordlist.end(), begin) != wordlist.end()) {
			wordlist.erase(remove(wordlist.begin(), wordlist.end(), begin), wordlist.end());
		}
		vector<Ladder> ladders;
		Node headroot(begin), tailroot(end);
		NodeSet frontlayer(nodecmp), backlayer(nodecmp);
		NodeSet *ptr_layerA = &frontlayer, *ptr_layerB = &backlayer;
		bool forward = true;

		if (begin == end) {
			ladders.push_back(Ladder(1, begin));
			return ladders;
		}

		frontlayer.insert(&headroot);
		backlayer.insert(&tailroot);
		wordlist.push_back(end);
		while (!ptr_layerA->empty() && !ptr_layerB->empty() && ladders.empty()) {
			NodeSet nextlayer(nodecmp);
			if (ptr_layerA->size() > ptr_layerB->size()) {
				swap(ptr_layerA, ptr_layerB);
				forward = !forward;
			}
			for (Node* node : *ptr_layerA) {
				wordlist.erase(remove(wordlist.begin(), wordlist.end(), node->word), wordlist.end());
			}
			for (Node* node : *ptr_layerA) {
				node->yieldchildren(nextlayer, wordlist, *ptr_layerB, ladders, forward);
			}
			swap(*ptr_layerA, nextlayer);
		}

		return ladders;
	}
};

//class Solution {
//private:
//	vector<vector<string>> ans;
//	queue<stack<string>> m;
//	queue<vector<string>> n;
//	//map<string, string> tracker;
//	//map<string, int> number;
//	string end = "";
//	bool findOneDifFrom() {
//		bool push = false;
//		stack<string> q = m.front();
//		m.pop();
//		vector<string> v = n.front();
//		if (m.empty() || q.size() != m.front().size()) {
//			n.pop();
//		}
//		if (ans.empty() || q.size() + 1 <= ans[0].size()) {
//			for (int i = 0; i < q.top().length(); ++i) {
//				for (char c = 'a'; c <= 'z'; ++c) {
//					if (c != q.top()[i]) {
//						string tmp = q.top();
//						tmp[i] = c;
//						if (tmp == end) {
//							vector<string> i = Pop(q);
//							if (ans.empty() || i.size() <= ans[ans.size() - 1].size()) {
//								ans.push_back(i);
//								if (push) {
//									n.push(v);
//								}
//								return true;
//							}
//							else {
//								return false;
//							}
//						}
//						else if (find(v.begin(), v.end(), tmp) != v.end()) {
//							/*
//							if (tracker.find(tmp) != tracker.end()&&q.size()+1+number[tmp]<=ans[0].size()) {
//
//								vector<string> i = Pop(q, number[tmp]+1);
//								i = CombineExist(i, tmp);
//								if (ans.empty() || i.size() <= ans[ans.size() - 1].size()) {
//									ans.push_back(i);
//								}
//								continue;
//							}
//							*/
//							stack<string> q1 = q;
//							q1.push(tmp);
//							m.push(q1);
//
//							v.erase(remove(v.begin(), v.end(), tmp), v.end());
//							push = true;
//						}
//					}
//				}
//			}
//			if (push) {
//				n.push(v);
//			}
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	/*
//	vector<string> CombineExist(vector<string> dest, string src) {
//		dest.push_back(src);
//		string tmp = src;
//		while (tracker.find(tmp) != tracker.end())
//		{
//			tmp = tracker[tmp];
//			dest.push_back(tmp);
//		}
//		return dest;
//	}
//	*/
//	vector<string> Pop(stack<string> q, int addon=0) {
//		vector<string> sth = { end };
//		while (!q.empty())
//		{
//			string tmp = q.top();
//			q.pop();
//			sth.push_back(tmp);
//			/*
//			if (tracker.find(tmp) == tracker.end() && !q.empty()) {
//				tracker[tmp] = q.top();
//				number[tmp] = addon+q.size();
//			}
//			*/
//		}
//		return sth;
//	}
//public:
//	vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
//		
//		vector<string> words = wordList;
//		end = beginWord;
//		stack<string> s;
//		s.push(endWord);
//		m.push(s);
//		if (find(words.begin(), words.end(), beginWord) != words.end()) {
//			words.erase(remove(words.begin(), words.end(), beginWord), words.end());
//		}
//		if (find(words.begin(), words.end(), endWord) != words.end()) {
//			words.erase(remove(words.begin(), words.end(), endWord), words.end());
//		}
//		else
//		{
//			return ans;
//		}
//		n.push(words);
//		while (!m.empty()&& findOneDifFrom()) {
//		}
//		return ans;
//	}
//};