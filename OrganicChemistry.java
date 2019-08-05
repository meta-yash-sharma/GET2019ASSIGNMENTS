package organicChemistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OrganicChemistry {

	//map for molecules mass
	Map<Character, Integer> molecules = new HashMap<Character, Integer>();
	//stack for compound
	Stack<String> stack = new Stack<String>();

	public OrganicChemistry() {
		//put mass of molecules
		molecules.put('C', 12);
		molecules.put('O', 16);
		molecules.put('H', 1);
	}
	/**
	 * @param compound for mass calculation
	 * @return mass of compound
	 */
	public int calculateCompoundMass(String compound) {
		compound = compound.toUpperCase();
		int compoundmMass = 0;
		char ch;
		for (int i = 0; i < compound.length(); i++) {
			ch = compound.charAt(i);
			if (molecules.keySet().contains(ch)){
				//put mass of molecule in stack
				stack.push(molecules.get(ch).toString());
			}
			else if (Character.isDigit(ch)) {
				int value = 0;
				while (Character.isDigit(ch)) {
					value = value * 10 + Character.getNumericValue(ch);
					i++;
					if(i < compound.length()){
						//get next character of compound string
						ch = compound.charAt(i);
					}
					else{
						break;
					}
				}
				i--;
				//push mass of molecule
				stack.push((Integer.parseInt(stack.pop()) * value) + "");
			} 
			else if (ch == '('){
				stack.push(ch + "");
			}
			else if (ch == ')') {
				int sum = 0;
				String popped = stack.pop();
				while (!popped.equals("(")) {
					sum += Integer.parseInt(popped);
					popped = stack.pop();
				}
				stack.push(sum + "");
			}else{
				throw new AssertionError("invalid compound");
			}
		}
		while (!stack.isEmpty()) {
			compoundmMass += Integer.parseInt(stack.pop());
		}
		return compoundmMass;
	}
	public static void main(String[] args){
		OrganicChemistry m = new OrganicChemistry();
		
		int mass = m.calculateCompoundMass("C2H2O6(C6H2(H2O)2)");
		
		System.out.print(mass);
	}
}
