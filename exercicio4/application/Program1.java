package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rooms;

public class Program1 {

	public static void mostrarMenu() {
		System.out.println("\n\n\tMENU");
		System.out.println("[ 1 ] Reservar um quarto");
		System.out.println("[ 2 ] Liberar quarto");
		System.out.println("[ 3 ] Mostrar dados dos quartos");
		System.out.println("[ 4 ] sair do programa");
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner console = new Scanner(System.in);
		Rooms[] vect = new Rooms[10];
		for (int i = 0; i < 10; i++) {
			vect[i] = new Rooms();
			vect[i].setIdStudent("VAZIO");
			vect[i].setRenter("VAZIO");
			vect[i].setVacancies(4);
		}

		byte opcao;
		do {
			mostrarMenu();
			System.out.print("Digite uma opcão: ");
			opcao = console.nextByte();

			System.out.println();
			switch (opcao) {
			case 1:
				System.out.print("Digite seu nome: ");
				console.nextLine();
				String name = console.nextLine();
				System.out.print("Olá estudante, qual quarto deseja alugar? (Quartos 0 a 9): ");
				int room = console.nextInt();
				System.out.print("Digite sua matricula: ");
				console.nextLine();
				String matricula = console.nextLine();
				System.out.print("Quantas vagas você precisa? ");
				int vagas = console.nextInt();
				while (vect[room].getVacancies() < vagas) {
					if (vagas > 4) {
						System.out.println("Só temos quartos para até 4 pessoas!");
						System.out.print("Quantas vagas você precisa? ");
						vagas = console.nextInt();
					} else if (vect[room].getVacancies() < 4) {
						System.out.println("Infelizmente este quarto esta ocupado.");
						System.out.print("Escolha outro: ");
						room = console.nextInt();
					}
				}
				vect[room].setIdStudent(matricula);
				vect[room].setVacancies(vect[room].getVacancies() - vagas);
				vect[room].setRenter(name);

				System.out.println("Quarto reservado com sucesso!");
				break;
			case 2:
				System.out.print("Qual quarto deseja liberar: ");
				room = console.nextInt();
				System.out.print("Digite sua matricula: ");
				console.nextLine();
				matricula = console.nextLine();
				while (!matricula.equals(vect[room].getIdStudent())) {
					System.out.println("Este quarto não corresponde a matricula digitada!");
					System.out.print("Qual quarto deseja liberar: ");
					room = console.nextInt();
					System.out.print("Digite sua matricula: ");
					console.nextLine();
					matricula = console.nextLine();
				}

				System.out.println("Quarto liberado com sucesso!");
				vect[room].setIdStudent("VAZIO");
				vect[room].setVacancies(4);
				vect[room].setRenter("VAZIO");
				break;
			case 3:
				for (int i = 0; i < 10; i++) {
					System.out.printf("\tROOM %d%n", i);
					System.out.println(vect[i].toString());
				}
				break;
			case 4:
				System.out.println("Programa fechado!");
				break;
			default:
				System.out.println("Opção inválida!");
				mostrarMenu();
			}

		} while (opcao != 4);

		console.close();
	}

}
