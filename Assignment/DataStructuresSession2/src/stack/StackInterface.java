package stack;

import stack.Stack.Node;

public interface StackInterface {
	
	/**
	 * Add the Data in Stack.
	 * @param data	Add an String type Variable in Stack by performing push operation.
	 */
	public void push(String data);
	
	/**
	 * Take out the Last Element added in the Stack and than remove the Element from Stack.
	 * @return	An Node type variable, Added the Last in Stack.
	 */
	public Node pop();
	
	/**
	 * Return the Top most Element added in the Stack.
	 * @return	An Node type variable, Added at the Top of Stack.
	 */
	public Node top();

}
