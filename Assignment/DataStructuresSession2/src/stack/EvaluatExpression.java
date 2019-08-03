package stack;

import java.util.HashMap;

public class EvaluatExpression {

	static HashMap<String, Integer> map = new HashMap<>();
	static {
		
		map.put("(", -8);
		map.put("!", 7);
		map.put("*", 6);
		map.put("/", 6);
		map.put("+", 5);
		map.put("-", 5);
		map.put(">", 4);
		map.put(">=", 4);
		map.put("<", 4);
		map.put("<=", 4);
		map.put("&&", 3);
		map.put("||", 2);
	}
	
	
	/**
	 * Convert Infix Expression into Postfix Expression.
	 * @param expression	An String variable, The Infix expression in a form of string.
	 * @return				Returns An String variable, The Postfix expression in a form of string.
	 */
	public String infixToPostfix(String expression) {

		String infixExpresionSplit[] = expression.split(" ");// Infix Expression split on the basis of space.
		String postfix = "";

		Stack s1 = new Stack();

		for (int index = 0; index < infixExpresionSplit.length; index++) {

			if ("(".equals(infixExpresionSplit[index])) {
				s1.push(infixExpresionSplit[index]);
			} else if (map.containsKey(infixExpresionSplit[index])) {

				while (map.get(s1.top().data) > map.get(infixExpresionSplit[index])) {
					postfix += s1.top().data + " ";
					s1.pop();
				}
				s1.push(infixExpresionSplit[index]);
			} else if (")".equals(infixExpresionSplit[index])) {
				while (!"(".equals(s1.top().data)) {
					postfix += s1.top().data + " ";
					s1.pop();
				}
				s1.pop();
			} else
				postfix += infixExpresionSplit[index] + " ";
		}
		while (!s1.empty()) {
			postfix += s1.top().data;
			s1.pop();
		}
		return postfix;
	}
	
	
	/**
	 * Evaluate the Data passed in the method
	 * @param operand1	An Integer variable, the first number which we have to evaluate.
	 * @param operand2	An Integer variable, the second number which we have to evaluate.
	 * @param operator	An String variable, Tell us the operation we have to perform on the two numbers.
	 * @return			Return An integer variable, The Answer after the evaluation of two number.
	 */
	int evaluate(int operand1, int operand2, String operator) {

		switch (operator) {
		case "+":
			return operand1 + operand2;

		case "-":
			return operand1 - operand2;

		case "*":
			return operand1 * operand2;

		case "/":
			return operand1 / operand2;

		case ">":
			return (operand1 > operand2 ) ? 1 : 0;

		case "<":
			return (operand1 < operand2 ) ? 1 : 0;

		case ">=":
			return (operand1 >= operand2 ) ? 1 : 0;

		case "<=":
			return (operand1 <= operand2 ) ? 1 : 0;
		}
		return 0;
	}
	
	
	/**
	 * Evaluate the Expression
	 * @param expression	An string variable, The Expression you want to Evaluate.
	 * @return				An string Variable, The Evaluate Value of Expression.
	 */
	public String evaluateExpression(String expression) {

		String postfix = infixToPostfix(expression);
		Stack operands = new Stack();
		int operand1, operand2;
		String splittedString[] = postfix.split(" ");
		for (int i = 0; i < splittedString.length; i++) {
			if (map.containsKey(splittedString[i])) {

				operand1 = Integer.parseInt(operands.top().data);
				operands.pop();
				operand2 = Integer.parseInt(operands.top().data);
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1,
						splittedString[i]))));
			} else {

				operands.push(splittedString[i]);
			}
		}
		return operands.top().data;
	}
	
	
	/**
	 * Evaluate the Expression
	 * @param expression	An string variable, The Expression you want to Evaluate.
	 * @return				An Boolean Variable, The Evaluate Value of Expression.
	 */
	public boolean evaluateForLogical(String expression) {

		String postfix = infixToPostfix(expression);
		Stack operands = new Stack();
		int operand1, operand2;
		String splittedString[] = postfix.split(" ");
		for (int i = 0; i < splittedString.length; i++) {
			if (map.containsKey(splittedString[i])) {

				operand1 = Integer.parseInt(operands.top().data);
				operands.pop();
				operand2 = Integer.parseInt(operands.top().data);
				operands.pop();
				operands.push(Integer.toString((evaluate(operand2, operand1,
						splittedString[i]))));
			} else {

				operands.push(splittedString[i]);
			}
		}
		return ("1".equals(operands.top().data)) ? true : false;
	}

}

