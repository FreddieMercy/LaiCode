#ifndef QUEUE_H
#define QUEUE_H

#include "Freddie_DoubleLinkList.h"

template <class T>
class Queue
{
protected:
	LinkListNode<T> *_head;
	LinkListNode<T> *_tail;
	int _size;
public:
	Queue()
	{
		_tail = nullptr;
		_head = nullptr;
		_size = 0;
	}

	
	virtual void push(T data)
	{
		LinkListNode<T> *temp = new LinkListNode<T>(data);
		if (_tail == nullptr)
		{
			_tail = temp;
			_head = _tail;
		}

		else
		{
			_tail->sNext(temp);
			_tail = _tail->gNext();
		}
		_size++;
	}
	int size()
	{
		return _size;
	}
	void pop()
	{
		if (_head != nullptr)
		{
			LinkListNode<T> *temp = _head;
			_head = _head->gNext();
			delete temp;

		}
	}

	T getData()
	{
		return _head->Data();
	}

};


#endif