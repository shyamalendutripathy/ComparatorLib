package trees;

public class BTInorderPre {

	Node root;
	private char[] inorderArr={'D','B','E','A','F','C'};
	private char[] preOrderArr={'A','B','D','E','C','F'};

	private void constructTree(){
		constructRecTree(root,0,inorderArr.length);

	}

	private void constructRecTree(Node root,int first,int last){
		if(first>last){
			return;
		}
		Node node=new Node(preOrderArr[first]);
		int index=searchArr(preOrderArr[first]);
		if(root==null){
			root=node;
		}
		else{
			if(index<=last){
				root.leftNode=node;
			}
			else{
				root.rightNode=node;
			}
		}
		constructRecTree(root, first+1, index);
		constructRecTree(root, index+1, last);


		for (int i = 1; i < preOrderArr.length; i++) {

			int cntIndex=searchArr(preOrderArr[i]);
			if(cntIndex<index){
				root.leftNode=node;
			}
			else{
				root.rightNode=node;
			}


		}
	}
	
	
	private void inOrderTraversal(Node root){
		if(root==null){
			return;
		}
		
		inOrderTraversal(root.leftNode);
		System.out.println(root.elem);
		inOrderTraversal(root.rightNode);
	}
	
	public static void main(String[] args) {
		BTInorderPre obj=new BTInorderPre();
		obj.constructTree();
		obj.inOrderTraversal(obj.root);
		
	}

	private int searchArr(char elem){
		for (int i = 0; i < inorderArr.length; i++) {
			if(preOrderArr[i]==elem){
				return i;
			}
		}
		return -1;
	}

}
