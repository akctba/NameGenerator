package ca.ciccc.ak.nameGenerator.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import ca.ciccc.ak.nameGenerator.tools.RandomNumber;

public class RscFile {
	
	private String resource;
	
	private String path;
	
	private Path filePath;
	
	//private File file;
	
	public RscFile(String fileName) {
		this.resource = fileName;
		try {
			loadResource(this.resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadResource (String resource) throws IOException {
        URL u = this.getClass().getResource(resource);
        loadResourceByUrl(u, resource);
    }
	
	private void loadResourceByUrl (URL u, String resource) throws IOException {
//        System.out.println("-> attempting input resource: "+resource);
        if (u != null) {
            path = u.getPath();
            path = path.replaceFirst("^/(.:/)", "$1");
            this.filePath = Paths.get(path);
//            this.file = new File(this.filePath);
//            System.out.println("    absolute resource path found :\n    " + path);
//            String s = new String(Files.readAllBytes(Paths.get(path)));
//            System.out.println("    file content: "+s);
        } else {
            System.out.println("    no resource found: " + resource);
        }
    }
	
	public int lines() {
		int lineCount = 0;
		// Way #1
//		if(filePath != null) {
//			try {
//				lineCount = (int) Files.lines(filePath).count();
//			} catch (IOException e) {
//				System.out.println(e.getMessage());
//				lineCount = 0;
//			}
//		}
		
		// way #2
		try (LineNumberReader reader = new LineNumberReader(new FileReader(this.path))) {
	        reader.skip(Integer.MAX_VALUE);
	        lineCount = reader.getLineNumber() + 1;
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineCount;
	}
	
	public String getRandomLine() {
		int line = RandomNumber.draw(this.lines());
		String value = getLine(line);
		return value;
	}

	private String getLine(int line) {
		try (LineNumberReader reader = new LineNumberReader(new FileReader(this.path))) {
			reader.skip(line);
			return reader.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
