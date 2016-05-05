package AFilaDeDesempregados;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		String[] entrada = ler.nextLine().split(" ");
		int quantDesempregados = Integer.parseInt(entrada[0]);
		int pulosA = Integer.parseInt(entrada[1]);
		int pulosB = Integer.parseInt(entrada[2]);

		int[] lista = new int[quantDesempregados];
		for (int i = 0; i < quantDesempregados; i++) {
			lista[i] = i + 1;
		}

		escolherDesempregado(lista, pulosA, pulosB);

	}

	public static void escolherDesempregado(int[] lista, int pulosA, int pulosB) {
		int puloSelecionadoA = 0;
		int PuloselecionadoB = lista.length - 1;

		while (quantPessoas(lista) != 0) {
			int contPulos = 0;
			int cont = puloSelecionadoA;

			while (contPulos != pulosA) {
				if (lista[cont] != 0) {
					contPulos++;
				}

				if (contPulos == pulosA) {
					puloSelecionadoA = lista[cont];
					break;					
				}

				if (cont == (lista.length - 1)) {
					cont = 0;
				}else{
					cont ++;
				}
			}
			
			contPulos = 0;
			cont = PuloselecionadoB;
			while (contPulos != pulosB) {
				if (lista[cont] != 0) {
					contPulos++;
				}

				if (contPulos == pulosB) {
					PuloselecionadoB = lista[cont];
					break;
				}

				if (cont == 0) {
					cont = lista.length -1;
				}else{
					cont --;
				}
			}


			if (puloSelecionadoA == PuloselecionadoB) {
				lista[puloSelecionadoA] = 0;
				System.out.println(puloSelecionadoA + 1);
			} else {
				lista[puloSelecionadoA] = 0;
				System.out.println(puloSelecionadoA + 1);
				lista[PuloselecionadoB] = 0;
				System.out.println(PuloselecionadoB - 1);
			}
		}

	}

	public static int quantPessoas(int[] lista) {
		for (int i : lista) {
			if (i != 0) {
				return 1;
			}
		}
		return 0;
	}
}
