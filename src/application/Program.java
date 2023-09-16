package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		// Configura a localização para os valores de entrada/saída estarem no formato
		// US (ponto como separador decimal).
		Locale.setDefault(Locale.US);

		// Cria um objeto Scanner para receber entrada do usuário.
		Scanner sc = new Scanner(System.in);

		// Cria uma lista para armazenar os objetos Employee.
		List<Employee> list = new ArrayList<Employee>();

		// Pede ao usuário que informe quantos funcionários serão registrados.
		System.out.print("How many employees will be registred? ");
		int n = sc.nextInt();

		// Loop para registrar os funcionários.
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			System.out.print("Name: ");
			sc.nextLine(); // Limpa o buffer do scanner antes de ler o nome do funcionário.
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			Employee emp = new Employee(id, name, salary); // Cria um objeto Employee com os dados fornecidos.
			list.add(emp); // Adiciona o funcionário à lista.
		}

		System.out.println();
		// Pede ao usuário que insira o ID do funcionário para aumentar o salário.
		System.out.print("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();

		// Procura o funcionário com o ID fornecido na lista.
		Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

		System.out.println();
		if (emp == null) {
			// Se o ID do funcionário não for encontrado, exibe uma mensagem de erro.
			System.out.println("That id does not exist!");
		} else {
			// Se o funcionário for encontrado, solicita a porcentagem de aumento salarial.
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			// Aumenta o salário do funcionário.
			emp.increaseSalary(percentage);
		}
		System.out.println();

		// Exibe os dados atualizados de todos os funcionários.
		for (Employee emp1 : list) {
			System.out.println(emp1);
		}
		// Fecha o scanner.
		sc.close();
	}

}
