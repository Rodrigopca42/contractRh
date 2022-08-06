package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departmentName = tec.nextLine();
		
		System.out.println("Entre com os dados do trabalhador:");
		System.out.print("Nome: ");
		String workerName = tec.nextLine();
		
		System.out.print("Nível: ");
		String workerLevel = tec.nextLine();
		
		System.out.print("Salário base: ");
		double baseSalary = tec.nextDouble();
		
		Worker worker =new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("Quantos contratos para este trabalhador? ");
		int n = tec.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Insira os dados do contrato nº " + i + ":");
			System.out.print("Data (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(tec.next());
			
			System.out.print("Valor por hora: ");
			double valuePerHour = tec.nextDouble();
			
			System.out.print("Duração (horas): ");
			int hours = tec.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.println(" ");
		System.out.print("Insira o mês e o ano para calcular a renda (MM/AAAA): ");
		String monthAndYear = tec.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: "+ worker.getName());
		System.out.println("Departamento: "+ worker.getDepartment().getName());
		System.out.println("Renda para "+ monthAndYear + ": "+ String.format("R$%.2f", worker.income(year, month)));
		
		tec.close();
		
		
	}
}
