package trees;

public class BinaryTree {
	public Node root;
	Node tempNode=null;
	
	public void insert(int elem){
		root = insertRec(root,elem);
	}
	
	public Node insertRec(Node root,int elem){
 		if(root==null){
			root=new Node(elem);
			root.leftNode=null;
			root.rightNode=null;
			return root;
		}
		
		if(root.elem<elem){
			root.rightNode=insertRec(root.rightNode,elem);
		}
		else{
			root.leftNode=insertRec(root.leftNode,elem);
		}
		return root;
	}
	
	public void findMin(Node node){
		if(node==null){
			System.out.println(tempNode.elem);
			
			return;
		}
		
		tempNode=node;
		findMin(node.leftNode);
		
	}
	
	public int calculateHeight(Node root){
		if(root ==null){
			return 0;
		}
		
		return 1+ Math.max(calculateHeight(root.leftNode), calculateHeight(root.rightNode));
	}
	
	public void levelOrder(Node root){
		int level=calculateHeight(root);
		for (int i = 1; i <= level; i++) {
			recurseLevelOrder(root, i);
			System.out.println(); 
			
		}
	}
	
	public void recurseLevelOrder(Node root,int level){
		if(root == null){
			return;
		}
		if(level==1){
			System.out.print(root.elem+"\t");
			return;
		}
		
		recurseLevelOrder(root.leftNode, level-1);
		recurseLevelOrder(root.rightNode, level-1);
		
	}
	
	public void inorderTraverse(Node root){
		if(root==null){
			return;
		}
		inorderTraverse(root.leftNode);
		System.out.print(root.elem+"\t");
		inorderTraverse(root.rightNode);
	}
	
	public Node delete(Node root,int elem){
		if(root ==null){
			return null;
		}
		else if(elem<root.elem){
			root.leftNode=delete(root.leftNode, elem);
		}
		else if(elem>root.elem){
			root.rightNode=delete(root.rightNode, elem);
		}
		
		else{
			if(root.leftNode==null && root.rightNode==null){
				return null;
			}
			else if(root.leftNode==null){
				return root.rightNode;
			}
			else if(root.rightNode==null){
				return root.leftNode;
			}
			else{
				findMin(root.rightNode);
				root.elem=tempNode.elem;
				delete(root.rightNode, root.elem);
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		int arr[]={50,76,21,4,32,64,15,52,14,100,83,2,3,70,87,80};
		for (int i = 0; i < arr.length; i++) {
			bt.insert( arr[i]);
		}
		
		bt.levelOrder(bt.root);
		
	}
	
}

class Node{
//	Sample Nodes
	int elem;
	Node leftNode;
	Node rightNode;
	
	
	public Node(int elem){
		this.elem=elem;
				
	}
}
