package Camisetas;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);
		int quantCamisas  = Integer.parseInt(ler.nextLine());
		while (quantCamisas != 0) {
			Camisa[] camisas = new Camisa[quantCamisas];
			for (int x = 0; x < quantCamisas; x++) {
				String nomeComprador = ler.nextLine();
				String[] dadosCamisa = ler.nextLine().split(" ");
				camisas[x] = (new Camisa(dadosCamisa[0], dadosCamisa[1], nomeComprador));
			}
			//////#############################
			quantCamisas = Integer.parseInt(ler.nextLine());
		}//fim do while
		ler.close();
	}
	
	public static void mostrarResultado(Camisa[] camisas){
		
		
		boolean teste = true;
		while(teste){
			teste = false;
			for(int x=0; x<camisas.length-1; x++){
				if((camisas[x].getCor().equalsIgnoreCase("branco")) && (camisas[x+1].getCor().equalsIgnoreCase("branco"))){
					if(camisas[x].){
						
					}
				}
			}
		}
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
	}// fim da class Camisa;

}
