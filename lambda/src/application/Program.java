package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Employee;

public class Program {
	public static void main(String[] args) {
		String path = "C:\\Users\\ianco\\eclipse-workspace\\lambda\\src\\in.txt";
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<Employee>();
		Locale.setDefault(Locale.US);
		
		//System.out.println("Enter full file path: ");
		//path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeFields[];
			while (br.ready()) {
				employeeFields = br.readLine().split(",");
				list.add(new Employee(employeeFields[0],employeeFields[1],Double.parseDouble(employeeFields[2])));
			}
			br.close();
		} catch (IOException e) {
			System.out.println("ERROR: "+e.getMessage());
		}
		System.out.println("Enter salary: ");
		Double salary = sc.nextDouble();
		System.out.println("Email of people whose salary is more than "+String.format("%.2f", salary)+":");
		list.stream()
			.filter(e -> e.getSalary() > salary)
			.map(e -> e.getEmail())
			.sorted()
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		Double sum =list.stream()
			.filter(e -> e.getName().charAt(0) == 'M')
			.map(e -> e.getSalary())
			.reduce(0.0, (x,y) -> x+y);
		System.out.println("Sum of salary of people whose name starts with 'M': "+String.format("%.2f", sum));
		sc.close();
	}
}