package cmd;

import java.util.Scanner;

public class VCPMainDriver {
	
	
	public static void main(String[] arg) {

		VirtualCommandPrompt v = new VirtualCommandPrompt();
		System.out.print(v.getRoot().getName() + ">" + "\t");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		while (input != "exit") {
			String result = v.vcp(input);
			System.out.print(result + ">\t");
			input = sc.nextLine();
		}
	}

}
