package eidi2.sose25.weber.felix.sheet06.ex01;

public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	private int size = 0;

	@Override
	public boolean add(T value) {
		if (this.root == null) {
			this.root = new Node<>(value);
			this.size++;
			return true;
		}

		return addRecursive(this.root, value);
	}

	private boolean addRecursive(Node<T> node, T value) {
		int cmp = value.compareTo(node.value);

		if (cmp == 0) {
			return false; // Wert existiert
		} else if (cmp < 0) {
			if (node.left == null) {
				node.left = new Node<>(value);
				size++;
				return true;
			}
			return addRecursive(node.left, value);
		} else {
			if (node.right == null) {
				node.right = new Node<>(value);
				size++;
				return true;
			}
			return addRecursive(node.right, value);
		}
	}

	@Override
	public boolean addIt(T value) {
		if (root == null) {
			root = new Node<>(value);
			size++;
			return true;
		}

		Node<T> current = root;

		while (true) {
			int cmp = value.compareTo(current.value);

			if (cmp == 0) {
				return false; // Duplikat
			} else if (cmp < 0) {
				if (current.left == null) {
					current.left = new Node<>(value);
					size++;
					return true;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new Node<>(value);
					size++;
					return true;
				}
				current = current.right;
			}
		}
	}

	@Override
	public String preorder() {
		StringBuilder sb = new StringBuilder();
		preorderHelper(root, sb);
		return formatOutput(sb);
	}

	private void preorderHelper(Node<T> node, StringBuilder sb) {
		if (node == null) return;
		sb.append(node.value).append(",");
		preorderHelper(node.left, sb);
		preorderHelper(node.right, sb);
	}

	@Override
	public String inorder() {
		StringBuilder sb = new StringBuilder();
		inorderHelper(root, sb);
		return formatOutput(sb);
	}

	private void inorderHelper(Node<T> node, StringBuilder sb) {
		if (node == null) return;
		inorderHelper(node.left, sb);
		sb.append(node.value).append(",");
		inorderHelper(node.right, sb);
	}

	@Override
	public String postorder() {
		StringBuilder sb = new StringBuilder();
		postorderHelper(root, sb);
		return formatOutput(sb);
	}

	private void postorderHelper(Node<T> node, StringBuilder sb) {
		if (node == null) return;
		postorderHelper(node.left, sb);
		postorderHelper(node.right, sb);
		sb.append(node.value).append(",");
	}

	private String formatOutput(StringBuilder stringBuilder) {
		if (stringBuilder.isEmpty()) return "[]";
		stringBuilder.setLength(stringBuilder.length() - 1); // letztes Komma entfernen
		return "[" + stringBuilder + "]";
	}

	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Wir haben mehrere Fälle, die wir betrachten müssen
	 * Fall 1: Knoten hat kein Kind -> löschen, Referenz auf null setzen
	 * Fall 2: Knoten hat ein Kind -> Ersetze Knoten durch sein Kind
	 * Fall 3: Knoten hat zwei Kinder -> finde kleinstes Element im rechten Teilbaum, entferne und ersetze den Mutterknoten mit diesem Wert
	 **/
	@Override
	public boolean remove(T val) {
		if (root == null) return false;
		int oldSize = size;
		root = removeRecursive(root, val);
		return size < oldSize;
	}

	private Node<T> removeRecursive(Node<T> node, T val) {
		if (node == null) return null;

		int cmp = val.compareTo(node.value);

		if (cmp < 0) {
			node.left = removeRecursive(node.left, val);
		} else if (cmp > 0) {
			node.right = removeRecursive(node.right, val);
		} else {
			// Knoten gefunden
			size--;

			// Fall 1: kein Kind
			if (node.left == null && node.right == null) {
				return null;
			}

			// Fall 2: ein Kind
			if (node.left == null) return node.right;
			if (node.right == null) return node.left;

			// Fall 3: zwei Kinder
			Node<T> successor = findMin(node.right);
			node.value = successor.value;
			node.right = removeRecursive(node.right, successor.value);
		}

		return node;
	}

	private Node<T> findMin(Node<T> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
}
