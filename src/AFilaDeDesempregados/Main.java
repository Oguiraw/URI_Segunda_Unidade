package AFilaDeDesempregados;

import java.util.Scanner;

public class Main {
	public static String resultado = "";
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		String entradaNext = ler.nextLine();
		String[] entrada;
		

		while (!(entradaNext.equals("0 0 0"))) {
			entrada = entradaNext.split(" ");
			int quantDesempregados = Integer.parseInt(entrada[0]);
			int pulosA = Integer.parseInt(entrada[1]);
			int pulosB = Integer.parseInt(entrada[2]);
			int[] lista = new int[quantDesempregados];
			for (int i = 0; i < quantDesempregados; i++) {
				lista[i] = i;
			}
			resultado = "";

			escolherDesempregado(lista, pulosA, pulosB);
			resultado = resultado.substring(0, resultado.length()-1);
			System.out.println(resultado);
			entradaNext = ler.nextLine();
			
		}

	}

	public static void escolherDesempregado(int[] lista, int pulosA, int pulosB) {
		int puloSelecionadoA = 0;
		int PuloselecionadoB = lista.length - 1;

		while (quantPessoas(lista) != 0) {
			int contPulos = 0;
			int cont = puloSelecionadoA;

			while (contPulos != pulosA) {
				if (lista[cont] >= 0) {
					contPulos++;
				}

				if (contPulos == pulosA) {
					puloSelecionadoA = lista[cont];
					break;
				}

				if (cont == (lista.length - 1)) {
					cont = 0;
				} else {
					cont++;
				}
			}

			contPulos = 0;
			cont = PuloselecionadoB;
			while (contPulos != pulosB) {
				if (lista[cont] >= 0) {
					contPulos++;
				}

				if (contPulos == pulosB) {
					PuloselecionadoB = lista[cont];
					break;
				}

				if (cont == 0) {
					cont = lista.length - 1;
				} else {
					cont--;
				}
			}

			if (puloSelecionadoA == PuloselecionadoB) {
				lista[puloSelecionadoA] = -1;
				resultado += (preparaString(puloSelecionadoA +1)) + ",";
			} else {
				lista[puloSelecionadoA] = -1;
				lista[PuloselecionadoB] = -1;
				resultado += (preparaString(puloSelecionadoA +1)) + (preparaString(PuloselecionadoB +1)) + ",";
			}
		}

	}

	public static int quantPessoas(int[] lista) {
		for (int i : lista) {
			if (i != -1) {
				return 1;
			}
		}
		return 0;
	}
	
	public static String preparaString(int entrada){
		String s = entrada + "";
		if(s.length() == 1){
			return "  " + s;
		}else if(s.length() == 2){
			return " " + s;
		}else{
			return s;
		}
	}
}
