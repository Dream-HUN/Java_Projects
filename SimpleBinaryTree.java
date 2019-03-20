package Package;

public class SimpleBinaryTree {
	
	private class Elem{
		public int data;
		public Elem right;
		public Elem left;
		public Elem(int a) { data = a; right = null; left = null; }
	}
	
	private class BinaryTree{
		private Elem e;
		
		public void AddData(int x) {
			if(e != null) {
				AddData(x, e);
			} else {
				e = new Elem(x);
			}
		}
		
		public void AddData(int x, Elem root) {
			if(root.data > x) { 
				if(root.left == null) root.left = new Elem(x); else AddData(x, root.left); 
				} else { 
					if(root.right == null) root.right = new Elem(x); else AddData(x, root.right); 
					}
		}
		
		public void InOrder() {
			if(e != null) InOrder(e);
		}
		
		public void InOrder(Elem root) {
			if(root.left != null) InOrder(root.left);
			System.out.printf("%d ",root.data);
			if(root.right != null) InOrder(root.right);
		}
	}
	
	
	public SimpleBinaryTree() {
		
		BinaryTree t = new BinaryTree();
		t.AddData(5);
		t.AddData(2);
		t.AddData(1);
		t.AddData(9);
		t.AddData(4);
		t.AddData(8);
		t.AddData(6);
		t.AddData(7);
		t.AddData(10);
		t.InOrder();
	}
	
	public static void main(String[] t) {
		SimpleBinaryTree p = new SimpleBinaryTree();
	}
}

