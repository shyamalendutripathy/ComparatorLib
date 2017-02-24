package trees;

public class Queue {
	
	QueueNode headNode;
	QueueNode tailNode;
	public void insert(int elem){
		QueueNode node=new QueueNode(elem);
		
		if(headNode==null || tailNode ==null){
			headNode=tailNode=node;
		}
		headNode.next=node;;
		headNode=headNode.next;
	}
	
	public void remove(){
		tailNode=tailNode.next;
	}
	
	public void print(){
		while(tailNode!=null){
			System.out.println(tailNode.elem);
			tailNode=tailNode.next;
		}
	}
	
	public static void main(String[] args) {
		Queue queue=new Queue();
		for (int i = 0; i < 10; i++) {
			queue.insert(i);
		}
		
		queue.remove();
		queue.remove();
		
		queue.print();
	}
}

class QueueNode{
	int elem;
	QueueNode next;;
	
	public QueueNode(int elem){
		this.elem=elem;
	}
}
