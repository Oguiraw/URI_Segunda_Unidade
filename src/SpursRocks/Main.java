package SpursRocks;

import java.util.Scanner;

public class Main {

	public static Scanner  ler = new Scanner(System.in);
	public static Scanner  ler2 = new Scanner(System.in);

	public static void main(String[] args) {
		
		int quantTimes = ler.nextInt();
		int quantEntradas = (quantTimes*(quantTimes-1))/2; 
		Time[] times = new Time[quantTimes];
		iniciasArrayTimes(times);
		
		for(int x=0; x<quantEntradas; x++){
			String[] entrada = ler2.nextLine().split(" ");
			int posicao0 = Integer.parseInt(entrada[0]) , posicao1 = Integer.parseInt(entrada[1]),
					posicao2 = Integer.parseInt(entrada[2]) , posicao3 = Integer.parseInt(entrada[3]);
			
			if(posicao1 > posicao3){
				times[posicao0 -1].addPontuacao(2);
				times[posicao2 -1].addPontuacao(1);
			}else if(posicao1 < posicao3){
				times[posicao2 -1].addPontuacao(2);
				times[posicao0 -1].addPontuacao(1);
			}
			times[posicao0 -1].addPontosMarcados(posicao1); 
			times[posicao2 -1].addPontosMarcados(posicao3);
			times[posicao0 -1].addPontosRecebidos(posicao3); 
			times[posicao2 -1].addPontosRecebidos(posicao1);
		}
		

		
		
	}//Fim do main
	
	public static void iniciasArrayTimes(Time[] times){
		for(int i=0; i<times.length ; i++){
			times[i] = new Time(i + 1);
		}
	}
	
	public static void resultado(Time[] times){
		
		//String resultado = "";
		for(int x=0; x<times.length; x++){
			for(int i=0; i<times.length; i++){
				
			}
		}
	}
	
	public static void ordenanDecrescente(Time[] times){
		boolean teste = true;
		while(teste){
			teste = false;
			for(int x=0; x<times.length -1; x++){
				if(times[x].pontuacao > times[x+1].pontuacao){
					Time aux = times[x];
					times[x] = times[x+1];
					times[x+1] = aux;
					teste = true;
				}
			}
		}
	}//Fim do Ordenar em ordem Decrescente

	
	public static class Time implements Comparable<Time>{
		private int numeroDoTime;
		private int pontuacao;
		private int pontosMarcados;
		private int pontosRecebidos;
		
		public Time(int n){
			this.numeroDoTime = n;
			this.pontosMarcados = 0;
			this.pontosRecebidos = 0;
			this.pontuacao = 0;
		}
		
		public int getPontuacao(){
			return this.pontuacao;
		}
		
		public void addPontuacao(int pontuacao){
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

		@Override
		public int compareTo(Time t) {
			if(this.pontuacao < t.getPontuacao()){
				return 1;
			}else if(this.pontuacao > t.getPontuacao()){
				return -1;
			}
			return 0;
		}
	}//Fim da class Time


	
}
