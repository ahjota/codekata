package net.ahjota.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedListCircularIterator<T> implements Iterator<T> {

	private CircularLinkedListNode<T> prevNode;
	private CircularLinkedListNode<T> itNode;
	
	public CircularLinkedListCircularIterator(CircularLinkedList<T> list) {
		itNode = list.getHead();
	}
	
	@Override
	public boolean hasNext() {
		if (itNode == null) {
			return false;
		} else if (itNode.getNext() == null) {
			return false;
		}
		
		return true;
	}

	@Override
	public T next() {
		if (this.hasNext()) {
			prevNode = itNode;
			itNode = itNode.getNext();
			return itNode.getValue();
		} else {
			throw new NoSuchElementException();
		}
	}

	@Override
	public void remove() {
		if (itNode.getNext().equals(itNode)) {
			itNode = null;
		} else {
			prevNode.setNext(itNode.getNext());
			itNode = itNode.getNext();
		}
	}
	
}