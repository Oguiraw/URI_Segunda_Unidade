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
		int selecionadoPulosB = lista.length-1;
		while (quantPessoas(lista) != 0) {
			int contPulos = 0;
			while (contPulos != pulosA) {
				for (int i = selecionadoPulosA; i < lista.length; i++) {
					if (lista[i] != 0) {
						contPulos++;
						if (contPulos == pulosA) {
							selecionadoPulosA = i + 1;
							break;
						}
						if(selecionadoPulosA == lista.length-1){
							selecionadoPulosA = 0; 
						}
					}
				}
			}
			contPulos = 0;
			while (contPulos != pulosB) {
				for (int i = selecionadoPulosB; i >= 0; i--) {
					if (lista[i] != 0) {
						contPulos++;
						if (contPulos == pulosB) {
							selecionadoPulosB = i+1;
							break;
						}
						if(selecionadoPulosB == lista.length-1){
							selecionadoPulosB = 0;
						}
					}
				}
			}

			if (selecionadoPulosA == selecionadoPulosB) {
				removerDesempregado(lista, selecionadoPulosA);
				System.out.println(selecionadoPulosA);
			} else {
				removerDesempregado(lista, selecionadoPulosA, selecionadoPulosB);
				System.out.println(selecionadoPulosA);
				System.out.println(selecionadoPulosB);
			}
		}

	}
	
	public static int quantPessoas(int[] lista){
		int quant = 0;
		for(int i : lista){
			if(i != 0){
				quant += 1;
			}
		}
		return quant;
	}

	public static void removerDesempregado(int[] lista, int desempregado) {
		for (int x = 0; x < lista.length; x++) {
			if (lista[x] == desempregado) {
				lista[x] = 0;
				return;
			}
		}
	}

	public static void removerDesempregado(int[] lista, int desempregado1,
			int desempregado2) {
		int teste = 0;
		for (int x = 0; x < lista.length; x++) {
			if (lista[x] == desempregado1) {
				lista[x] = 0;
				teste++;
			}
			if (lista[x] == desempregado2) {
				lista[x] = 0;
				teste++;
			}

			if (teste == 2) {
				return;
			}
		}
	}
}
