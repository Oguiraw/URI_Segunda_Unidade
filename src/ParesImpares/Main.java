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
		
		quickSort(impares, 0, impares.length -1);
		quickSort(pares, 0, pares.length -1);

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


	private static void quickSort(int [] vetor, int inicio, int fim){
		if(inicio < fim){
			int posicaoPivo = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivo - 1);
			quickSort(vetor, posicaoPivo + 1, fim);
		}
	}
	
	private static int separar(int[] vetor, int inicio, int fim){
		int pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		
		while(i <= f){
			if(vetor[i] <= pivo){
				i++;
			}else if(pivo < vetor[f]){
				f--;
			}else{
				int troca = vetor[i];
				vetor[i] = vetor[f];
				vetor[f] = troca;
				i++;
				f--;
			}
		}vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	}
}
