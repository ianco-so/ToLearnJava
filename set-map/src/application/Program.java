package application;

import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		String path = "C:\\Users\\ianco\\eclipse-workspace\\set-map\\src\\in.txt";
		//Scanner sc = new Scanner(System.in);
		Map<String, Integer> votes = new HashMap<>();
		//System.out.println("Enter file full path: ");
		//path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line[] = br.readLine().split(",");
			while (line != null) {
				if (!votes.containsKey(line[0]))	votes.put(line[0], Integer.parseInt(line[1]));
				else	votes.put(line[0], votes.get(line[0])+Integer.parseInt(line[1]));
				if(br.ready())	line = br.readLine().split(",");
				else	line = null;
			}
			for (String key : votes.keySet())	System.out.println(key+", "+votes.get(key));
			br.close();
		} catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		//sc.close();
	}
}