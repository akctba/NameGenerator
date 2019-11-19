package ca.ciccc.ak.nameGenerator.view.console;

import java.util.Date;
import java.util.Scanner;

import ca.ciccc.ak.nameGenerator.core.ResourceFile;
import ca.ciccc.ak.nameGenerator.interfaces.View;

public class ConsoleApplication implements View {

	private Scanner scanner;
	private Integer num;
	private String path;

	public static final int SAVE_LIMIT = 100;

	public ConsoleApplication() {
		// default contructor
	}

	public ConsoleApplication(String[] args) {
		if (args.length > 0) {
			try {
				num = Integer.decode(args[0]);
			} catch (NumberFormatException e) {
				num = null;
			}
		}

		if (args.length > 1) {
			path = args[1];
		}
	}

	@Override
	public void start() {
		scanner = new Scanner(System.in);
		
			if (num == null) {
				addOutput("Number of names: ");
				num = scanner.nextInt();
			}
			if (path == null) {
				addOutput("Path to save the list: ");
				path = scanner.next();
			}
			// TODO UtilFile.validateFile(path);

			Date ini = new Date();

			// load the files
			ResourceFile names = new ResourceFile("names.txt");
			ResourceFile lastNames = new ResourceFile("lastnames.txt");

			// por partes
			for (int i = 1; i <= num; ++i) {
				// TODO find random names
				
				StringBuilder sb = new StringBuilder();
				sb.append(names.getRandomLine());
				sb.append(" ");
				sb.append(lastNames.getRandomLine());

				String newName = sb.toString();
				
				System.out.println(newName);
				
				//TODO salvar o newName

				if (i % SAVE_LIMIT == 0) {
					// TODO salvar no arquivo
				}
			}

			Date end = new Date();
			long dif = end.getTime() - ini.getTime();
			// UtilFile.saveOnFile(path, dif + " milliseconds");
			addOutput(dif + " milliseconds");


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
