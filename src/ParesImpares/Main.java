package ParesImpares;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int quantidade = ler.nextInt();
		ler.nextLine();

		int[] numeros = new int[quantidade];
		int contImpares = 0;
		int contPares = 0;

		for (int x = 0; x < quantidade; x++) {
			int entrada = ler.nextInt();
			ler.nextLine();
			numeros[x] = entrada;
			if ((entrada % 2) == 0) {
				contPares++;
			} else {
				contImpares++;
			}
		} // fim do for

		int[] impares = new int[contImpares];
		int[] pares = new int[contPares];

		sepadarNumeros(numeros, impares, contImpares, pares, contPares);
		InsertionSort(impares);
		InsertionSort(pares);

		for (int i : pares) {
			System.out.println(i);
		}

		for (int i = impares.length - 1; i >= 0; i--) {
			System.out.println(impares[i]);
		}
		ler.close();
	}

	public static void sepadarNumeros(int[] numeros, int[] impares, int contImpares, int[] pares, int contPares) {
		int contP = contPares;
		int contI = contImpares;
		for (int x = 0; x < numeros.length; x++) {
			if ((numeros[x] % 2) == 0) {
				contP--;
				pares[contP] = numeros[x];
			} else {
				contI--;
				impares[contI] = numeros[x];
			}
		}
	}

	public static void InsertionSort(int[] vetor) {
		int i, j, eleito;
		for (i = 1; i < vetor.length; i++) {
			eleito = vetor[i];
			j = i;
			while ((j > 0) && (vetor[j - 1] > eleito)) {
				vetor[j] = vetor[j - 1];
				j = j - 1;
			}
			vetor[j] = eleito;
		}
	}
}
