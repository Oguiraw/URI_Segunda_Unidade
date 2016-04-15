package Camisetas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		int quantCamisas = Integer.parseInt(ler.nextLine());

		while (quantCamisas != 0) {
			
			ArrayList<Camisa> camisas = new ArrayList<Camisa>();
			
			for (int x = 0; x < quantCamisas; x++) {
				String nomeComprador = ler.nextLine();
				String[] dadosCamisa = ler.nextLine().split(" ");
				Camisa c = new Camisa (dadosCamisa[0], dadosCamisa[1], nomeComprador);
				c.trocarTamanho();
				camisas.add(c);
			}
			
			Collections.sort(camisas);
			mostrarResultado(camisas);
			quantCamisas = Integer.parseInt(ler.nextLine());
			if (quantCamisas != 0) {
				System.out.println("");
			}
		} // fim do while
		ler.close();

	}

	public static void mostrarResultado(ArrayList<Camisa> camisas) {

		for (Camisa c : camisas) {
			c.retornarTamanhoOriginal();
			System.out.println(c.toString());
		}
	}

	public static void trocaPosicoes(Camisa[] camisas, int x) {
		Camisa aux = camisas[x];
		camisas[x] = camisas[x + 1];
		camisas[x + 1] = aux;
	}

	public static class Camisa implements Comparable<Camisa> {
		private String cor;
		private String tamanho;
		private String nomeComprador;

		public Camisa(String cor, String tamanho, String nomeComprador) {
			this.cor = cor;
			this.tamanho = tamanho;
			this.nomeComprador = nomeComprador;
		}
		

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
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
		
		public void trocarTamanho(){
			if(this.tamanho.equalsIgnoreCase("p")){
				if(Character.isUpperCase(this.tamanho.charAt(0))){
					this.setTamanho("a");
				}else{
					this.setTamanho("A");
				}
			}else if(this.tamanho.equalsIgnoreCase("m")){
				if(Character.isUpperCase(this.tamanho.charAt(0))){
					this.setTamanho("b");
				}else{
					this.setTamanho("B");
				}
			}else if(this.tamanho.equalsIgnoreCase("g")){
				if(Character.isUpperCase(this.tamanho.charAt(0))){
					this.setTamanho("c");
				}else{
					this.setTamanho("C");
				}
			}
		}

		public void retornarTamanhoOriginal(){
			if(this.tamanho.equalsIgnoreCase("a")){
				if(Character.isUpperCase(this.tamanho.charAt(0))){
					this.setTamanho("p");
				}else{
					this.setTamanho("P");
				}
			}else if(this.tamanho.equalsIgnoreCase("b")){
				if(Character.isUpperCase(this.tamanho.charAt(0))){
					this.setTamanho("m");
				}else{
					this.setTamanho("M");
				}
			}else if(this.tamanho.equalsIgnoreCase("c")){
				if(Character.isUpperCase(this.tamanho.charAt(0))){
					this.setTamanho("g");
				}else{
					this.setTamanho("G");
				}
			}
		}
		@Override
		public int compareTo(Camisa camisa) {
			return this.toString().compareTo(camisa.toString());
		}
	}// fim da class Camisa;
}
