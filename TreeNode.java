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
	
	JavaTree() {
		rootNode = new Node<T>();
	}
	public void insertNode(Node<T> topNode,Node<T> inputNode) {
		topNode.setNext(inputNode);
	}
	public void insertNode(Node<T> topNode,T inputData) {
		Node<T> tmp;
		tmp = new Node<T>();
		tmp.setData(inputData);
		topNode.setNext(tmp);
	}
	public void deleteNode(Node<T> topNode,Node<T> inputNode) {
		topNode.deleteNode(inputNode);
	}
	
}
