package convert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
	public static void main(String[] args) {
		String data ="";
		String pathIn = "C:\\Users\\ianco\\eclipse-workspace\\convert\\src\\in.txt";
		String pathOut = "C:\\Users\\ianco\\eclipse-workspace\\convert\\src\\out.txt";
		System.out.println(" ");
		try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
			String s = br.readLine();
			while (s != null) {
				data = data+" "+s;
				s = br.readLine();
			}
			br.close();
		}catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		String test[] = data.replace(',', '.').split(" ");
		String sj = String.join(", ", test);
		try (FileWriter fw = new FileWriter(pathOut)) {
			fw.write(sj);
			fw.close();
		}catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}