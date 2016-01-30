package Pie;

import java.util.Scanner;

public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		//New PIE!
		Pies magPie = new Pies();
		//Get console lines
		System.out.println(magPie.greetUser());
		in = new Scanner(System.in);
		String userStatement = in.nextLine();
		
		//while not saying otherwise, Run
		while (!userStatement.toLowerCase().equals("bye") && !userStatement.toLowerCase().equals("gtfo")){
			
			//Respond to Prior Response
			System.out.println(magPie.botRespond(userStatement));
			//get Current user Response
			userStatement = in.nextLine();
		}
	}

}
