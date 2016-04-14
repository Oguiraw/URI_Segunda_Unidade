package Camisetas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int quantCamisas = Integer.parseInt(ler.nextLine());

		while (quantCamisas != 0) {
			int contBrancas = 0;
			int contVermelhas = 0;

			Camisa[] camisas = new Camisa[quantCamisas];
			for (int x = 0; x < quantCamisas; x++) {
				String nomeComprador = ler.nextLine();
				String[] dadosCamisa = ler.nextLine().split(" ");
				camisas[x] = (new Camisa(dadosCamisa[0], dadosCamisa[1], nomeComprador));
				if (dadosCamisa[0].equalsIgnoreCase("branco")) {
					contBrancas++;
				} else if (dadosCamisa[0].equalsIgnoreCase("vermelho")) {
					contVermelhas++;
				}
			}

			Camisa[] camisasBrancas = new Camisa[contBrancas];
			Camisa[] camisasVermelhas = new Camisa[contVermelhas];
			separaCamisasPorCor(camisas, camisasBrancas, camisasVermelhas);
			mostrarResultado(camisasBrancas);
			mostrarResultado(camisasVermelhas);
			quantCamisas = Integer.parseInt(ler.nextLine());
			if (quantCamisas != 0) {
				System.out.println("");
			}
		} // fim do while
		ler.close();

	}

	public static void mostrarResultado(Camisa[] camisas) {

		boolean teste = true;
		while (teste) {
			teste = false;
			for (int x = 0; x < camisas.length - 1; x++) {
				if (compararNome(camisas[x].toString(), camisas[x + 1].toString())) {
					trocaPosicoes(camisas, x);
					teste = true;
				}
			}
		}
		for (Camisa c : camisas) {
			System.out.println(c.toString());
		}
	}

	public static boolean compararNome(String nomeA, String nomeB) {
		String[] nome1 = nomeA.split("");
		String[] nome2 = nomeB.split("");
		trocaTamanho(nome1);
		trocaTamanho(nome2);

		int tamanho;

		if (nome1.length > nome2.length) {
			tamanho = nome2.length;
		} else {
			tamanho = nome1.length;
		}

		for (int x = 0; x < tamanho; x++) {
			if (nome1[x].charAt(0) > nome2[x].charAt(0)) {
				return true;
			} else if (nome1[x].charAt(0) < nome2[x].charAt(0)) {
				return false;
			} else if (nome1[x].toUpperCase().charAt(0) == nome2[x].toUpperCase().charAt(0)) {
				if (Character.isUpperCase(nome1[x].charAt(0))) {
					return false;
				} else if (Character.isUpperCase(nome2[x].charAt(0))) {
					return true;
				}

			}
		}
		return false;
	}

	public static void trocaTamanho(String[] entrada) {
		for (int x = 0; x < entrada.length; x++) {
			if (entrada[x].equalsIgnoreCase(" ")) {
				if (entrada[x + 1].equalsIgnoreCase("p")) {
					entrada[x + 1] = "A";
					return;
				} else if (entrada[x + 1].equalsIgnoreCase("m")) {
					entrada[x + 1] = "B";
					return;
				} else {
					return;
				}
			}
		}
	}

	public static void separaCamisasPorCor(Camisa[] camisas, Camisa[] camisasBrancas, Camisa[] camisasVermelhas) {
		int contBrancas = 0;
		int contVermelhas = 0;

		for (Camisa c : camisas) {
			if (c.getCor().equalsIgnoreCase("branco")) {
				camisasBrancas[contBrancas] = c;
				contBrancas++;
			} else {
				camisasVermelhas[contVermelhas] = c;
				contVermelhas++;
			}
		}
	}// fim separa Camisas Por Cor

	public static void trocaPosicoes(Camisa[] camisas, int x) {
		Camisa aux = camisas[x];
		camisas[x] = camisas[x + 1];
		camisas[x + 1] = aux;
	}

	public static class Camisa {
		private String cor;
		private String tamanho;
		private String nomeComprador;

		public Camisa(String cor, String tamanho, String nomeComprador) {
			this.cor = cor;
			this.tamanho = tamanho;
			this.nomeComprador = nomeComprador;
		}

		public String getCor() {
			return cor;
		}

		public String getTamanho() {
			return tamanho;
		}

		public String getNomeComprador() {
			return nomeComprador;
		}

		@Override
		public String toString() {
			return (cor + " " + tamanho + " " + nomeComprador);
		}
	}// fim da class Camisa;
}
