package ca.ciccc.ak.nameGenerator.view.console;

import java.util.Scanner;

import ca.ciccc.ak.nameGenerator.interfaces.View;

public class ConsoleApplication implements View {
	
	private Scanner scanner;
	private String option = "";
	private Integer num;
	private String path;
	
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
		// TODO Auto-generated method stub

	}

	@Override
	public void setTaskProgress(long progress) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStatusText(String statusText) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addOutput(String text) {
		// TODO Auto-generated method stub

	}

}
