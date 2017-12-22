# Advanced 3 Recursion III

## Tree + Recursion 
Use recursion to return values in a bottom-up way in binary tree.

- What do you expect from your lchild / rchild ?

- What do you want to do in the current layer ?

- What do you want to report to your parent?


1. Determine whether a binary tree is a balanced binary tree.
	
	- What do you expect from your lchild / rchild ?
		lchild height/ rchild height
	- What do you want to do in the current layer ?
		1. if any of child return -1, means it is not balance for the child
		2. if Math.abs(lchild, rchild) > 1, means not balance for current layer.
	- What do you want to report to your parent?
		1. if not balanced, report -1(tell your parent you are not balance)
		2. if balanced, report maxHeight + yourself.

2. maxPathSum I, from one leaf node to another leaf node.
	
	- What do you expect from your lchild / rchild ?	
		lchild max path sum, rchild max path sum
	- What do you want to do in the current layer ?
		record your maxPathSum, from current node to left most, right most
	- What do you want to report to your parent.
		report the Math.max(lchild, rchild) + yourslef.
		
3. maxPathSum II, from any node to any node.

	- What do you expect from your lchild / rchild ?	
		lchild max path sum, rchild max path sum.
		1. if any child path sum < 0, discard it.
	- What do you want to do in the current layer ?
		update globalMax if root.value + left + right is bigger
	- What do you want to report to your parent.
		report the Math.max(lchild, rchild) + yourslef.

		
		
## Tree + Recursion (Path Problem in binary tree)

class 1 : 人-shape path, get value from bottom to root

class 2 : non-人-shape path, from root to bottom
(key point : carry a path prefix while traversing the tree.)

4. maxPathSum III, from leaf to root.

	- get prefix from parent
	
	- add the value of yourself to both of your children.
	
	- if it is a leaf, update globalMax and return
	
	
5. maxPathSum to target, node on the path from root to one leaf.

	

4. maxPathSum III, from any node to any node.
	
	
	
## Tree + Recursion (Tree Serialization Problem)



## Tree + Recursion (Tree De-serialization Problem)




