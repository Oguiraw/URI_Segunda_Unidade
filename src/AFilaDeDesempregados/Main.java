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
		int selecionadoPulosA = 0;
		int selecionadoPulosB = lista.length - 1;
		while (quantPessoas(lista) != 0) {

			int contPulos = 0;

			if (selecionadoPulosA == lista.length - 1)
				selecionadoPulosA = 0;
			for (int i = selecionadoPulosA; i < lista.length; i++) {
				if (lista[i] != 0) {
					contPulos++;
					if (contPulos == pulosA) {
						selecionadoPulosA = i;
						break;
					}
					if (i == lista.length - 1) {
						i = 0;
					}
				}
			}

			contPulos = 0;
			if (selecionadoPulosB == 0)
				selecionadoPulosB = lista.length - 1;
			for (int i = selecionadoPulosB; i >= 0; i--) {
				if (lista[i] != 0) {
					contPulos++;
					if (contPulos == pulosB) {
						selecionadoPulosB = i;
						break;
					}
					if (i == 0) {
						i = lista.length - 1;
					}
				}
			}

			if (selecionadoPulosA == selecionadoPulosB) {
				lista[selecionadoPulosA] = 0;
				System.out.println(selecionadoPulosA + 1);
			} else {
				lista[selecionadoPulosA] = 0;
				System.out.println(selecionadoPulosA + 1);
				lista[selecionadoPulosB] = 0;
				System.out.println(selecionadoPulosB - 1);
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
