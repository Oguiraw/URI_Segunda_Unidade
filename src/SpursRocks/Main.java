package SpursRocks;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		int quantTimes = ler.nextInt();
		ler.nextLine();
		int cont = 0;
		String resultados = "";

		while (quantTimes != 0) {
			cont++;
			int quantEntradas = (quantTimes * (quantTimes - 1)) / 2;
			Time[] times = new Time[quantTimes];
			iniciasArrayTimes(times);

			for (int x = 0; x < quantEntradas; x++) {
				String[] entrada = ler.nextLine().split(" ");
				int posicao0 = Integer.parseInt(entrada[0]), posicao1 = Integer.parseInt(entrada[1]),
						posicao2 = Integer.parseInt(entrada[2]), posicao3 = Integer.parseInt(entrada[3]);

				if (posicao1 > posicao3) {
					times[posicao0 - 1].addPontuacao(2);
					times[posicao2 - 1].addPontuacao(1);
				} else {
					times[posicao2 - 1].addPontuacao(2);
					times[posicao0 - 1].addPontuacao(1);
				}
				times[posicao0 - 1].addPontosMarcados(posicao1);
				times[posicao2 - 1].addPontosMarcados(posicao3);
				times[posicao0 - 1].addPontosRecebidos(posicao3);
				times[posicao2 - 1].addPontosRecebidos(posicao1);
			}

			ordenanDecrescente(times);
			resultados += ("Instancia " + cont) + ("\n" + resultado(times)) + "\n\n";
			quantTimes = ler.nextInt();
			ler.nextLine();
		}
		ler.close();
		resultados = resultados.trim();
		System.out.println(resultados);

	}// Fim do main

	public static void iniciasArrayTimes(Time[] times) {
		for (int i = 0; i < times.length; i++) {
			times[i] = new Time(i + 1);
		}
	}

	public static void ordenanDecrescente(Time[] times) {
		boolean teste = true;
		while (teste) {
			teste = false;
			for (int x = 0; x < times.length - 1; x++) {
				if (times[x].pontuacao < times[x + 1].pontuacao) {
					Time aux = times[x];
					times[x] = times[x + 1];
					times[x + 1] = aux;
					teste = true;
				} else if (times[x].pontuacao == times[x + 1].pontuacao) {
					if ((times[x].pontosMarcados / (times[x].pontosRecebidos + 0.0)) < (times[x + 1].pontosMarcados
							/ (times[x + 1].pontosRecebidos + 0.0))) {
						Time aux = times[x];
						times[x] = times[x + 1];
						times[x + 1] = aux;
						teste = true;
					} else if ((times[x].pontosMarcados
							/ (times[x].pontosRecebidos + 0.0)) == (times[x + 1].pontosMarcados
									/ times[x + 1].pontosRecebidos + 0.0)) {

						if (times[x].pontosMarcados < times[x + 1].pontosMarcados) {
							Time aux = times[x];
							times[x] = times[x + 1];
							times[x + 1] = aux;
							teste = true;
						} else if (times[x].pontuacao == times[x + 1].pontuacao) {
							if (times[x].numeroDoTime > times[x + 1].numeroDoTime) {
								Time aux = times[x];
								times[x] = times[x + 1];
								times[x + 1] = aux;
								teste = true;

							}
						}
					}
				}
			}
		}
	}

	public static String resultado(Time[] times) {
		String resultado = "";
		for (Time t : times) {
			resultado += t.numeroDoTime + " ";
		}
		resultado = resultado.trim();
		return resultado; 
	}// Fim do resultado

	public static class Time {
		private int numeroDoTime;
		private int pontuacao;
		private int pontosMarcados;
		private int pontosRecebidos;

		public Time(int n) {
			this.numeroDoTime = n;
			this.pontosMarcados = 0;
			this.pontosRecebidos = 1;
			this.pontuacao = 0;
		}

		public int getPontuacao() {
			return this.pontuacao;
		}

		public void addPontuacao(int pontuacao) {
			this.pontuacao += pontuacao;
		}

		public int getNumeroDoTime() {
			return numeroDoTime;
		}

		public int getPontosMarcados() {
			return pontosMarcados;
		}

		public void addPontosMarcados(int pontosMarcados) {
			this.pontosMarcados += pontosMarcados;
		}

		public int getPontosRecebidos() {
			return pontosRecebidos;
		}

		public void addPontosRecebidos(int pontosRecebidos) {
			this.pontosRecebidos += pontosRecebidos;
		}
	}// Fim da class Time
}