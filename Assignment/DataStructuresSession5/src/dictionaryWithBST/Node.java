package dictionaryWithBST;;


public class Node {

	private int key;
	private String value;
	public Node left;
	public Node right;

	
	/**
	 * Constructor to Initialize node values.
	 * @param key
	 * @param value
	 */
	public Node(int key, String value) {
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	
	/**
	 * Getter for key value
	 * @return the key
	 */
	public int getKey() {
		return this.key;
	}
	
	
	/**
	 * Getter for value
	 * 
	 * @return the value.
	 */
	public String getValue() {
		return this.value;
	}
	

	/**
	 * Setter for key value
	 * @param key 
	 */
	public void setKey(int key) {
		this.key = key;
	}
	

	/**
	 * Setter for value
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

}