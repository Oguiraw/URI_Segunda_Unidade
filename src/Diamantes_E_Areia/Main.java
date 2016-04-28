package Diamantes_E_Areia;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		int quantidade = Integer.parseInt(ler.nextLine());
		for (int y = 0; y < quantidade; y++) {

			String entrada = ler.nextLine();
			int a = 0;
			int b = 0;
			for (int x = 0; x < entrada.length(); x++) {
				if (entrada.charAt(x) == '<') {
					a++;
				} else if (entrada.charAt(x) == '>') {
					if (a > b) {
						b++;
					}
				}
			}

			if (a > b) {
				System.out.println(b);
			} else {
				System.out.println(a);
			}

		}
		ler.close();

	}

}
