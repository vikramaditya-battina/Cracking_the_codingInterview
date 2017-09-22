package TreesAndGraphs;

public class TreeNode<T> {
	T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	public TreeNode(T t) {
		this.data = t;
		this.left = null;
		this.right = null;
	}
}
