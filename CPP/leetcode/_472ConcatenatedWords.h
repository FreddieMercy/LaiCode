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

	struct Tire
	{
		Tire():End(false){}
		bool End;
		map<char, Tire *> Next;
	};	
	Tire *root = new Tire();
	void add(string s) {
		if (s == "") {
			return;
		}
		Tire *tmp = root;
		for (int i = 0; i < s.size(); ++i) {
			if (tmp->Next.find(s[i]) == tmp->Next.end()) {
				tmp->Next[s[i]] = new Tire();
			}
			tmp = tmp->Next[s[i]];
		}
		tmp->End = true;
	}
	int search(string s) {
		if (s == "") {
			return 0;
		}
		Tire *tmp = root;
		bool return1 = false;
		for (int i = 0; i < s.size(); ++i) {
			if (tmp->Next.find(s[i])==tmp->Next.end()) {
				return 0;
			}
			tmp = tmp->Next[s[i]];
			if (tmp->End && s.length() > i) {
				if (s.length()-1 == i) {
					return1 = true;
				}
				int j = search(s.substr(i+1, s.length() - i-1));
				if (j > 0) {
					return 1 + j;
				}
			}
		}
		return (return1) ? 1 : 0;
	}
public:
	vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {

		vector<string> ans;
		Tire t;
		for (int i = 0; i < words.size();++i) {
			add(words[i]);
		}
		for (int i = 0; i < words.size();++i) {
			if (search(words[i])>1) {
				ans.push_back(words[i]);
			}
		}
		return ans;
	}

};
//class Solution {
//public:
//	vector<string> findAllConcatenatedWordsInADict(vector<string>& words) {
//
//		vector<string> ans;
//
//		for (int i = 0; i < words.size(); ++i) {
//			if ( helper(words, words[i]) > 1) {
//				ans.push_back(words[i]);
//			}
//		}
//
//		return ans;
//	}
//private:
//	int helper(vector<string> &v, string s) {
//		
//		bool return1 = false;
//		for (int i = 0; i < v.size(); ++i) {
//			if (v[i]!=""&&s.length()>=v[i].size() && v[i]==s.substr(0, v[i].size())) {
//				if (s.length() == v[i].size()) {
//					return1 = true;
//				}
//				int j = helper(v, s.substr(v[i].size(), s.length()-v[i].size()));
//				if (j>0) {
//					return 1 + j;
//				}
//			}
//		}
//
//		return (return1)?1:0;
//	}
//};