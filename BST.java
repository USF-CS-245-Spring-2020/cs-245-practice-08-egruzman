import java.util.*;
import java.io.*;

public class BST <T extends Comparable<T>>
{
	private BSTNode<T> root;

	public BST()
	{
		root = null;
	}

	public BST(T item)
	{
		root = new BSTNode<T>(item);
	}

	public boolean find(T item)
	{
		return find(root, item);
	}

	private boolean find(BSTNode<T> node, T item)
	{
    	if (node == null)
    		return false;
    	
    	if (item.compareTo(node.data) == 0)
    		return true;
    	else if (item.compareTo(node.data) < 0)
    		return find(node.left, item);
    	else
    		return find(node.right, item);
	}

	public void insert(T item)
	{
		root = insert(root, item);
	}

	private BSTNode<T> insert(BSTNode<T> node, T item)
	{
		if (node == null)
			return new BSTNode<T>(item);

		if (item.compareTo(node.data) == 0)
			return node;
		else if (item.compareTo(node.data) < 0)
			node.left = insert(node.left, item);
    	else
    		node.right = insert(node.right, item);

    	return node;
	}	

	public void print()
	{
		print(root);
	}

	private void print(BSTNode<T> node)
	{
		if (node != null)
		{
			print(node.left);
			System.out.println(node.data);
			print(node.right);
		}
	}

	public void delete(T item)
	{
		root = delete(root, item);
	}

	private BSTNode<T> delete(BSTNode<T> node, T item)
	{
		if (node == null)
			throw new RuntimeException("Element not found.");
		else if (item.compareTo(node.data) < 0)
    		node.left = delete(node.left, item);
    	else if ((item.compareTo(node.data) > 0))
    		node.right = delete(node.right, item);
    	else
      	{
        	if (node.left == null)
         		return node.right;
         	else if (node.right == null)
         		return node.left;
         	else
            	node.left =  delete(node.left, node.data);
      	}

      return node;
   	}

	private class BSTNode<T extends Comparable<T>>
	{
		private T data;
		private BSTNode<T> left;
		private BSTNode<T> right;

		public BSTNode(T item)
		{
			this.data = item;
			this.left = null;
			this.right = null;
		}
	}
}