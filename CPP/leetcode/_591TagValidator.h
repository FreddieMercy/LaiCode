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
	bool isEndingTag(string head, string tail)
	{
		if (head.size() > 1 && tail.size() > 1)
		{
			if (head.size() == tail.size() - 1 && tail[1] == '/'&&head[0] == tail[0] && tail[0] == '<' && head[head.size() - 1] == tail[tail.size() - 1] && tail[tail.size() - 1] == '>')
			{
				if (head.substr(1, head.size() - 1 - 1) == tail.substr(2, tail.size() - 1 - 2))
				{
					return true;
				}
			}
		}

		return false;
	}
	bool isValidTagName(string code)
	{
		if (code.size() > 1 && ((code[1] != '/'&&code.size() <= 11) || (code[1] == '/'&&code.size() <= 9 + 2 + 1)))
		{
			if (code[0] == '<'&&code[code.size() - 1] == '>')
			{
				size_t start = 1;
				size_t end = code.size() - 1;

				if (code[1] == '/')
				{
					start++;
				}
				if (end == start)
				{
					return false;
				}
				string newCode = code.substr(start, end - start);
				for (char c : newCode)
				{
					if (c < 65 || c>90)
					{
						return false;
					}
				}

				return true;
			}
		}

		return false;
	}

public:
	bool isValid(string code) {

		stack<string> compiler;
		string Ccd = "<![CDATA[";
		string Cnd = "]]>";
		string tag = "";
		bool findingTag = false;
		bool findingCcd = false;

		for (char c : code)
		{
			if (c != '>')
			{
				tag += c;
			}
			else
			{
				break;
			}
		}

		tag += '>';

		if (tag.size() * 2 + 1 > code.size())
		{
			return false;
		}

		if (!isValidTagName(tag) || !isEndingTag(tag, code.substr(code.size() - tag.size() - 1, tag.size() + 1)))
		{
			return false;
		}

		string newCode = code.substr(tag.size(), code.size() - tag.size() * 2 - 1);

		tag = "";

		for (char c : newCode)
		{
			if (c == '<')
			{
				findingTag = true;
			}

			if (findingTag)
			{
				tag += c;
			}

			if (c == '>'&&tag.size() > 0)
			{
				if (isValidTagName(tag))
				{
					if (compiler.size() > 0 && isEndingTag(compiler.top(), tag))
					{
						compiler.pop();
					}
					else
					{
						compiler.push(tag);
					}

					findingTag = false;
					tag = "";
				}
				else
				{
					if (Ccd == tag.substr(0, Ccd.size()))
					{
						if (Cnd == tag.substr(tag.size() - Cnd.size(), Cnd.size()))
						{
							findingTag = false;
							tag = "";
						}
					}
					else
					{
						return false;
					}
				}
			}

		}

		return compiler.size() == 0 && !findingTag;
	}
};