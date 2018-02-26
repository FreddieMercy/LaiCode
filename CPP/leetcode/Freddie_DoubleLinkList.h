#ifndef FREDDIE_DOUBLELINKLIST_H
#define FREDDIE_DOUBLELINKLIST_H

#include <iostream>

using namespace std;

template <class T>
class LinkListNode
{
private:
	LinkListNode<T> *_next = nullptr;
	T _data;

public:
	void sData(T data)
	{
		_data = data;
		return;
	}

	T Data()
	{
		return _data;
	}

	void sNext(LinkListNode<T> *p)
	{
		_next = p;
		return;
	}


	LinkListNode<T> *gNext()
	{
		return _next;
	}

	LinkListNode()
	{
		_next = nullptr;
	}

	LinkListNode<T>(T data)
	{
		_data = data;
	}

};

#endif