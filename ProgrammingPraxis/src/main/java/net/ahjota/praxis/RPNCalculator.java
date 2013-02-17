package net.ahjota.praxis;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Calculates reverse Polish notation expressions.
 * 
 * @see <a
 *      href="http://programmingpraxis.com/2009/02/19/rpn-calculator/">Programming
 *      Praxis Exercise 1</a>
 * 
 * @author AJ
 */
public class RPNCalculator {

	static Stack<Double> calculatorStack = new Stack<Double>();

	public static void main(String[] args) {
		Scanner consoleScanner = new Scanner(System.in);

		System.out.println("Enter RPN expressions below with spaces.");
		System.out.println("Non-numeric characters are ignored.");
		System.out.println("Type 'Q' on a newline and hit enter to exit the calculator.");

		calculatorStack = new Stack<Double>();

		String expression = null;
		boolean keepAlive = true;
		while (keepAlive) {
			expression = consoleScanner.nextLine();

			if (expression.equalsIgnoreCase("q")) {
				keepAlive = false;
				continue;
			}

			String[] parameters = expression.split(" ");
			for (String parameter : parameters) {
				if (parameter.matches("^[+-/*]{1}$")) {
					// if its an operand, pop two and calculate
					Double op1, op2;
					try {
						op2 = calculatorStack.pop();
						op1 = calculatorStack.pop();

						if (parameter.equals("+")) {
							calculatorStack.push(op1 + op2);
						} else if (parameter.equals("-")) {
							calculatorStack.push(op1 - op2);
						} else if (parameter.equals("*")) {
							calculatorStack.push(op1 * op2);
						} else if (parameter.equals("/")) {
							calculatorStack.push(op1 / op2);
						}
					} catch (EmptyStackException e) {
						System.out
								.println("ERR: Not enough operands to evaluate operator '"
										+ parameter + "'");
						keepAlive = false;
					}
				} else if (parameter.matches("-?[0-9]+(\\.[0-9]*)?|\\.[0-9]+")) {
					// if its a value, push onto stack
					calculatorStack.push(Double.valueOf(parameter));
				} else if (!parameter.trim().isEmpty()) {
					// if its a non-numeric or a non-operator
					System.out.println("WARN: " + parameter
							+ " is neither a decimal value nor an operator");
				}
			}

			if (!calculatorStack.empty()) {
				System.out.println(calculatorStack.peek());
			}
		}

		consoleScanner.close();

		System.out.println("--");

		if (1 == calculatorStack.size()) {
			Double result = calculatorStack.pop();
			System.out.println("Result: " + result);
		}

		System.out.println("Stack: " + calculatorStack.toString());

		return;
	}

}
