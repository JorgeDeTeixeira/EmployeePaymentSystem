package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);

		List<Employee> list = new ArrayList<>();

		System.out.print("Enter the number of employess:");
		int n = leitor.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Employee #" + i + " data:");
			System.out.print("Outsourced (y/n)?");
			char ch = leitor.next().charAt(0);
			System.out.print("Name: ");
			leitor.nextLine();
			String name = leitor.nextLine();
			System.out.print("Hours:");
			int hour = leitor.nextInt();
			System.out.print("Value per hour:");
			double valuePerHour = leitor.nextDouble();
			if (ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = leitor.nextDouble();
				list.add(new OutsourcedEmployee(name, hour, valuePerHour, additionalCharge));
			} else {
				list.add(new Employee(name, hour, valuePerHour));
			}
		}

		System.out.println();
		System.out.println("Payments:");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}

		leitor.close();

	}

}
