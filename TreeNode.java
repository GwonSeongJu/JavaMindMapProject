import java.util.ArrayList;

class Node<T>{
	private T data;
	private ArrayList<Node<T>> next;
	
	public T getData() {
		return data;
	}
	
	public Node() {
		next = new ArrayList<Node<T>>();
	}
	public void setData(T data) {
		this.data = data;
	}
	public void setNext(Node<T> _next) {
		next.add(_next);
	}
	
	public Node<T> getNext(int index) {
		return next.get(index);
	}
}

class JavaTree<T>{
	Node<T> rootNode;
	
	public void insertNode(Node<T> topNode,Node<T> inputNode) {
		topNode.setNext(inputNode);
	}
	
}
