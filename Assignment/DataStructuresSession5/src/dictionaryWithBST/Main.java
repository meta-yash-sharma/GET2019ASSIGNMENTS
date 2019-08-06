package dictionaryWithBST;

public class Main {
	public static void main(String args[]) {

		String filePath = "pairs.json";

		BST bst = new BST(filePath);

		Node obj3 = new Node(3, "Ram");
		Node obj4 = new Node(4, "Komal");

		// Adding nodes to the BST.
		bst.add(obj3, bst.root);
		bst.add(obj4, bst.root);

		System.out.println();
		System.out.println("Word deleted from dictinary with key : 45 ");
		Node objdel1 = bst.delete(45, bst.root);
		System.out.println("Sorted List After Deletion according to Key is:");
		bst.sortedList(bst.root);		
		for (int i = 0; i < bst.sortedListValues.size(); i++) {
			System.out.println(bst.sortedListValues.get(i).getKey()+"\t"+bst.sortedListValues.get(i).getValue());
		}
		
		System.out.println();

		System.out.println("Searching value in tree With The Key : 2");
		String objsearch = bst.getValue(2, bst.root);
		if (objsearch == null)
			System.out.println("Given key is not found.. Wrong input key!!.. So null value returned!!..");
		else
			System.out.println(objsearch);
		System.out.println();
		
		// Clear before Every call or the new Range will be added with the previous data.
		bst.sortedListRangeValues.clear();
		bst.sortedListRange(bst.root, 1, 4);
		System.out.println("Sorted list of the Dictionary according to Keys in the specified range (1,4) is:");
		for (int i = 0; i < bst.sortedListRangeValues.size(); i++) {
			System.out.println(bst.sortedListRangeValues.get(i).getKey()
					+"\t"+ bst.sortedListRangeValues.get(i).getValue());
		}
		
		System.out.println();
		bst.sortedListRangeValues.clear();
		bst.sortedListRange(bst.root, 8, 34);
		System.out.println("Sorted list of the Dictionary according to Keys in the specified range (8,34) is:");
		for (int i = 0; i < bst.sortedListRangeValues.size(); i++) {
			System.out.println(bst.sortedListRangeValues.get(i).getKey()
					+"\t"+ bst.sortedListRangeValues.get(i).getValue());
		}
	}
}
