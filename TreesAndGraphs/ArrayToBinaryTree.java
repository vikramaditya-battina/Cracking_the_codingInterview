package TreesAndGraphs;

public class ArrayToBinaryTree {
	public static TreeNode<Integer> toTree(int nums[]){
		return toTree(nums, 0);
	}
	
	public static TreeNode<Integer> toTree(int nums[], int index){
		if(index >= nums.length) {
			return null;
		}
		 TreeNode<Integer> node = new TreeNode<Integer>(nums[index]);
		 node.left = toTree(nums,2*index+1);
		 node.right = toTree(nums, 2*index+2);
		 return node;
	}
}
