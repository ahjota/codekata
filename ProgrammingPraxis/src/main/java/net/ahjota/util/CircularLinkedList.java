package net.ahjota.util;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> {

	private CircularLinkedListNode<T> headNode = null;
	private int size = 0;
	
	public CircularLinkedList() {
	}
	
	protected CircularLinkedListNode<T> getHead() {
		return this.headNode;
	}
	
	public void addNode(T obj) {		
		if (obj == null) {
			throw new NullPointerException("Cannot add a null value to the list");
		}
		
		// create new node
		CircularLinkedListNode<T> newNode = new CircularLinkedListNode<T>(obj);
		
		if (headNode == null) {
			// got an empty list
			headNode = newNode;
		} else {
			// non-empty list
			CircularLinkedListNode<T> tailNode = headNode;
			while (tailNode.getNext() != headNode) {
				tailNode = tailNode.getNext();
			}
			
			// add new node as tail
			tailNode.setNext(newNode);
		}
		
		newNode.setNext(headNode);
		
		++size;
	}
	
	public CircularLinkedListNode<T> removeNode(T obj) {
		System.out.println("Removing " + obj);
		if (obj == null) {
			return null;
		}
		
		CircularLinkedListNode<T> removedNode = null;
		if (headNode != null) {
			// non-empty list
			CircularLinkedListNode<T> thisNode = headNode, nextNode = headNode.getNext();
			
			do {
				if (obj.equals(nextNode.getValue())) {
					removedNode = nextNode;
					--size;
					
					if (size == 0) {
						headNode = null;
					} else {
						thisNode.setNext(removedNode.getNext());
						removedNode.setNext(null);
					}
					
					break;
				}
				
				thisNode = nextNode;
				nextNode = nextNode.getNext();
			} while (nextNode.getNext() != headNode);
		}
		
		return removedNode;
	}
	
	public final int size() {
		return this.size;
	}
	
	public CircularLinkedListCircularIterator<T> iterator() {
		return new CircularLinkedListCircularIterator<T>(this);
	}
	
	public final String toString() {
		CircularLinkedListNode<T> nextNode = headNode;
		
		if (nextNode == null) {
			return "";
	}
	
	StringBuilder result = new StringBuilder();
	do {
		result.append(nextNode.getValue());
		if (nextNode.getNext() != headNode) {
			result.append(",");
		}
		nextNode = nextNode.getNext();
	} while (nextNode != headNode);
		
		return result.toString();
	}
	
	public T[] toObjectArray(Class<T> c) {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(c, size);
		
		CircularLinkedListNode<T> nextNode = headNode;
		for (int i=0; i<size; ++i) {
			result[i] = nextNode.getValue();
			nextNode = nextNode.getNext();
		}
		
		return (T[])result;
	}
}
	
class CircularLinkedListNode<T> {
	
	private T value;
	private CircularLinkedListNode<T> next;
	
	protected CircularLinkedListNode(T value) {
		this.value = value;
	}
	
	public CircularLinkedListNode<T> getNext() {
		return this.next;
	}
	
	public void setNext(CircularLinkedListNode<T> next) {
		this.next = next;
	}
	
	public T getValue() {
		return this.value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
}