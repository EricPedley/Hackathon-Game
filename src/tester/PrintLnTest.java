package tester;

import java.io.FileWriter;
import java.io.IOException;

public class PrintLnTest {
	public static final String fileSep = System.getProperty("file.separator");
	public static void main(String[] args) throws IOException {
		FileWriter writer = null;
		try {
			writer = new FileWriter("text.txt");
			writer.write("No U");
		} finally {
			if(writer != null)
				writer.close();
		}
	}
}
