package TreesAndGraphs;

public class MinimalHeight {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	public TreeNode sortedArrayToBST(int nums[]) {
		return sortedArrayToBST(nums, 0, nums.length-1);
	}
	
	public TreeNode sortedArrayToBST(int nums[], int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = sortedArrayToBST(nums,start, mid-1);
		node.right = sortedArrayToBST(nums,mid+1, end);
		return node;
	}
}
