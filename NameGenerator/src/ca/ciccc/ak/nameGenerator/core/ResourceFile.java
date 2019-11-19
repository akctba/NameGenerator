package ca.ciccc.ak.nameGenerator.core;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import ca.ciccc.ak.nameGenerator.tools.RandomNumber;

public class ResourceFile {

	private String resource;

	private String path;

	public String getPath() {
		return path;
	}

	List<String> lines;

	public ResourceFile(String fileName) {
		this.resource = fileName;
		try {
			loadResource(this.resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadResource(String resource) throws IOException {
		URL u = this.getClass().getResource(resource);
		loadResourceByUrl(u, resource);
	}

	private void loadResourceByUrl(URL u, String resource) throws IOException {
		if (u != null) {
			path = u.getPath();
			path = path.replaceFirst("^/(.:/)", "$1");
			lines = Files.readAllLines(Paths.get(path));
		} else {
			System.out.println("    no resource found: " + resource);
		}
	}

	public int lines() {
		return lines.size();
	}

	public String getRandomLine() {
		int line = RandomNumber.draw(this.lines());
		String value = getLine(line);
		return value;
	}

	public String getLine(int lineNumber) {
		String line = null;

		if (lines != null && lines.size() > lineNumber) {
			line = lines.get(lineNumber + 1);
		}

		return line;
	}

}
