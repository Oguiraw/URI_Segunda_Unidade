package Camisetas;

import java.util.Scanner;

public class teste {

	public static void main(String[] args) {

		String n1 = "branco p Maria Jose";
		String n2 = "vermelho p Maria Jose";
		
		System.out.println(compararNome(n1, n2));
		
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
			} else if(nome1[x].toUpperCase().charAt(0) == nome2[x].toUpperCase().charAt(0)){
				if(Character.isUpperCase(nome1[x].charAt(0))){
					return false;
				}else if(Character.isUpperCase(nome2[x].charAt(0))){
					return true;
				}
				
			}
		}
		return false;
	}
	
	public static void trocaTamanho(String[] entrada){
		for(int x=0; x<entrada.length; x++){
			if(entrada[x].equalsIgnoreCase(" ")){
				if(entrada[x+1].equalsIgnoreCase("p")){
					entrada[x+1] = "A";
					return;
				}else if(entrada[x+1].equalsIgnoreCase("m")){
					entrada[x+1] = "B";
					return;
				}else{
					return;
				}
			}
		}
	}
}
