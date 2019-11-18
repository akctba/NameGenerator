package ca.ciccc.ak.nameGenerator.view.console;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ca.ciccc.ak.nameGenerator.interfaces.View;

public class ConsoleApplication implements View {
	
	private Scanner scanner;
	private String option = "";
	private Integer num;
	private String path;
	
	public static final int SAVE_LIMIT = 100;
	
	public ConsoleApplication() {
		// default contructor
	}

	public ConsoleApplication(String[] args) {
		if (args.length > 0) {
			option = args[0];
		}
		if (args.length > 1) {
			try {
				num = Integer.decode(args[1]);
			} catch (NumberFormatException e) {
				num = null;
			}
		}
		
		if (args.length > 2) {
			path = args[2];
		}
	}

	@Override
	public void start() {
		scanner = new Scanner(System.in);
		
		while (!"g".equalsIgnoreCase(option)) {
			System.out.println("# OPTIONS:");
			System.out.println("# G - Generate a list of prime numbers");
			System.out.println("# Q - Quit the program");

			option = scanner.nextLine().toLowerCase();
			
			if ("q".equals(option)) {
				scanner.close();
				return;
			}
		}
		
		switch (option) {
		case "g":
			if(num == null) {
				addOutput("Number limit: ");
				num = scanner.nextInt();
			}
			if(path == null) {
				addOutput("Path to save the list: ");
				path = scanner.next();
			}
			//TODO UtilFile.validateFile(path);
			
			Date ini = new Date();

			// por partes
			for(int i = 1 ; i <= num; ++i) {
				
				
				
				if(i%SAVE_LIMIT == 0) {
					//TODO salvar no arquivo
				}
			}
			
			Date end = new Date();
			long dif = end.getTime() - ini.getTime();
			//UtilFile.saveOnFile(path, dif + " milliseconds");
			addOutput(dif + " milliseconds");

			break;
		default:
			scanner.close();
			throw new IllegalArgumentException("Unexpected value: " + option);
		}

		scanner.close();
		
		
		

	}

	@Override
	public void setTaskProgress(long progress) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatusText(String statusText) {
		System.out.println("## " + statusText);

	}

	@Override
	public void addOutput(String text) {
		System.out.println(">> " + text);
	}

}
