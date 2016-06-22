package Numerike_2;

import javax.swing.JOptionPane;

/*
 * @author Mergim Rama
 */

public class PageRank {
	private static int nrIMatricesN = new Integer(JOptionPane.showInputDialog("Tregoni nr e matrices katrore: "))
			.intValue();
	private static int[][] matricaKatrore = new int[nrIMatricesN][nrIMatricesN];
	private static double[][] rez = new double[nrIMatricesN][nrIMatricesN];

	public static int rreshti(int x) {
		int shuma = 0;
		for (int i = 0; i < nrIMatricesN; i++) {
			shuma = shuma + matricaKatrore[x][i];
		}
		return shuma;
	}

	public static void main(String[] args) {
		int nrFaqeve = new Integer(JOptionPane.showInputDialog("Sa faqe do ti vizitoni: ")).intValue();

		for (int i = 0; i < nrFaqeve; i++) {
			int faqja1 = new Integer(JOptionPane.showInputDialog("Lidhni faqen : ", "Shtypni nr e faqes")).intValue();
			int faqja2 = new Integer(JOptionPane.showInputDialog("Me faqen:", "Shtypni nr e faqes")).intValue();
			matricaKatrore[faqja1][faqja2]++;
		}

		System.out.println("Matrica: ");

		for (int i = 0; i < nrIMatricesN; i++) {
			for (int j = 0; j < nrIMatricesN; j++) {
				int l = rreshti(i);
				if (l == 0) {
					l = 1;
				}
				rez[i][j] = matricaKatrore[i][j] * (90.0 / l) + 2;
				System.out.print(rez[i][j] + "      ");
				if (j == nrIMatricesN - 1) {
					System.out.println();
				}
			}
		}

	}
}