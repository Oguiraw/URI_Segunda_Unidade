package ParesImpares;

import java.util.LinkedList;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args){

		Scanner ler = new Scanner(System.in);
		int quantidade = ler.nextInt();
		ler.nextLine();
		LinkedList<Integer> numeroImpares = new LinkedList<Integer>();
		LinkedList<Integer> numeroPares = new LinkedList<Integer>();

		for (int x = 0; x < quantidade; x++) {
			int entrada = ler.nextInt();
			ler.nextLine();
			if ((entrada % 2) == 0) {
				numeroPares.add(entrada);
			} else {
				numeroImpares.add(entrada);
			}
		} // fim do for
		numeroPares.sort(null);
		numeroImpares.sort(null);

		for (int i : numeroPares) {
			System.out.println(i);
		}

		for (int i = numeroImpares.size() - 1; i >= 0; i--) {
			System.out.println(numeroImpares.get(i));
		}
		ler.close();
	}
}