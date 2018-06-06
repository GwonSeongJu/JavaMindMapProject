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
	
	public void deleteNext(int index) {
		next.remove(index);
	}
	
	public void deleteNode(Node<T> node){
		next.remove(node);
	}
	
	public int getNextNumber(){
		return next.size();
	}
}

class JavaTree<T>{
	Node<T> rootNode;
	
	public void insertNode(Node<T> topNode,Node<T> inputNode) {
		topNode.setNext(inputNode);
	}
	public void deleteNode(Node<T> topNode,Node<T> inputNode) {
		topNode.deleteNode(inputNode);
	}
	
}
