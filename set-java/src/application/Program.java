package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		Set<Integer> students = new HashSet<Integer>();
		String path = "C:\\Users\\ianco\\eclipse-workspace\\set-java\\in.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			Integer nStudents = 0;
			while(nStudents != -1) {
				nStudents = Integer.parseInt(br.readLine());
				for(int j = 0; j < nStudents; j++)
					students.add(Integer.parseInt(br.readLine()));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		System.out.println("Total students: "+students.size());
	}
}