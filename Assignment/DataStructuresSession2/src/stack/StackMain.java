package stack;

public class StackMain {

	public static void main(String[] args) {
		
		Stack a = new Stack();
		
		String expression = "( 1 + 2 * 3 )";
		System.out.println(expression);
		EvaluatExpression evaluatExpression = new EvaluatExpression();
		String postfix = evaluatExpression.infixToPostfix(expression);
		System.out.println("Expression postfix : "+postfix);
		System.out.println("Result is : "+evaluatExpression.evaluateForLogical(expression));
	}

}
