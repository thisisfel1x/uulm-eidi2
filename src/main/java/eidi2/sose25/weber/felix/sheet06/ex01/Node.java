package eidi2.sose25.weber.felix.sheet06.ex01;

public class Node<T extends Comparable<T>> {

	T value;
	Node<T> left, right;

	public Node(T value) {
		this.value = value;
	}
}