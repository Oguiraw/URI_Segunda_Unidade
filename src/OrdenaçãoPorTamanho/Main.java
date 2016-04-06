package OrdenaçãoPorTamanho;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		int quantidade = ler.nextInt();
		ler.nextLine();
		for (int i = 0; i < quantidade; i++) {
			String resultado = "";
			String[] arrayPalavras = ler.nextLine().split(" ");
			boolean teste = true;
			while (teste) {
				teste = false;
				for (int x = 0; x < arrayPalavras.length - 1; x++) {
					if (arrayPalavras[x].length() < arrayPalavras[x + 1].length()) {
						String aux = arrayPalavras[x];
						arrayPalavras[x] = arrayPalavras[x + 1];
						arrayPalavras[x + 1] = aux;
						teste = true;
					}
				}
			}
			for (String s : arrayPalavras) {
				resultado += s + " ";
			}
			resultado = resultado.trim();
			System.out.println(resultado);
		}
		ler.close();
	}
}
