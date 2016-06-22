package Numerike_2;

import javax.swing.JOptionPane;

/*
 * @Author: Mergim Rama
 */

public class Vektoret {
	
	public static void main(String[] args) {
		
		int choose = new Integer(JOptionPane.showInputDialog("Shtyp:\n" + "1 - Mbledhje te vektoreve"
				+ "\n2 - Zbritje te vektoreve" + "\n3 - Mbledhje te matricave\n4 - Zbritje te matricave"
				+ "\n5 - L2 norma\n6 - L infinit norma\n7 - Distanca e dy L2 vektoreve"
				+ "\n8 - Distanca e dy L infinit vektoreve\n9 - Norma infinit matricore\n10 - Frobenius norma\n"
				+ "11 - Shumezim i matricave"
				+ "\n0 - Mbyll")).intValue();
		
		if (choose == 1) 
			System.out.println("Mbledhja e dy vektorëve: " + sumOrSubVectors(fillVector(1), fillVector(2), "+"));
		else if (choose == 2)
			System.out.println("Zbritja e dy vektorëve: " + sumOrSubVectors(fillVector(1), fillVector(2), "-"));
		else if (choose == 3) {
			sumOrSubMatrixes(fillMatrix(1), fillMatrix(2), "+");
		} else if (choose == 4)
			sumOrSubMatrixes(fillMatrix(1), fillMatrix(2), "-");
		else if (choose == 5)
			System.out.println("L2 norma: " + l2Norm(fillVector(1)));
		else if (choose == 6)
			System.out.println("L infinit norma: " + lInfinitNorm(fillVector(1)));
		else if (choose == 7)
			System.out.println("Distanca e 2 L2 vektoreve: " + distanceBetweenTwoL2Vectors(fillVector(1), fillVector(2)));
		else if (choose == 8)
			System.out.println("Distanca e 2 L infinit vektoreve: " + distanceBetweenTwoLInfinitVectors(fillVector(1), fillVector(2)));
		else if (choose == 9)
			System.out.println("Norma infinit matricore: " + infinitMatrixNorm(fillMatrix(1)));
		else if (choose == 10)
			System.out.println("Frobenius Norma: " + frobeniusNorm(fillMatrix(1)));
		else if (choose == 11) {
			
		}
		
		
		else 
			System.exit(0);
	}

	public static double[] fillVector(int num) {
		int a = new Integer(JOptionPane.showInputDialog("Jep gjatësinë e vektorit " + num)).intValue();
		double[] vector = new double[a];
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Integer(JOptionPane.showInputDialog("Vektori " + num + ": Jep vlerën e " + numri(i+1)));
		}
		
		return vector;
	}
	
	public static double[][] fillMatrix(int num) {
		int i = new Integer(JOptionPane.showInputDialog("Jep numrin e rreshtave te matrices " + num)).intValue();
		int j = new Integer(JOptionPane.showInputDialog("Jep numrin e shtyllave te matrices " + num)).intValue();
		double[][] matrix = new double[i][j];
		for (int a = 0; a < i; a++) {
			for (int b = 0; b < j; b++) {
				matrix[a][b] = new Integer(JOptionPane.showInputDialog("Matrica " + num + ": Jep vlerën e A[" + a + "][" + b + "]"));
			}
		}
		return matrix;
	}
	
	public static double sumOrSubVectors(double[] vector1, double[] vector2, String sign) {
		double result = 0;
		if (vector1.length == vector2.length) {
			for(int i = 0; i < vector1.length; i++) {
				if (sign.equals("+"))
					result += vector1[i] + vector2[i];
				else if (sign.equals("-"))
					result += vector1[i] - vector2[i];
			}
		} else {
			System.out.println("Vektorët nuk kanë gjatësinë e njëjtë!");
		}
		return result;
	}
	
	public static double[][] sumOrSubMatrixes(double[][] matrix1, double[][] matrix2, String sign) {
		double[][] result = new double[matrix1.length][matrix2.length];
		if ((matrix1.length == matrix2.length) && (matrix1[0].length == matrix2[0].length)) {
			for (int i = 0; i < matrix1.length; i++) {
				for (int j = 0; j < matrix1[0].length; j++) {
					if (sign.equals("+")) {
						result[i][j] += matrix1[i][j] + matrix2[i][j];
						System.out.print(result[i][j] + " ");
					} else if (sign.equals("-")) {
						result[i][j] += matrix1[i][j] - matrix2[i][j];
						System.out.print(result[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("Matricat nuk kanë gjatësinë e njëjtë!");
		}
		return result;
	}
	
	public static double[][] multiplyMatrixes(double[][] A, double[][] B) {
		double[][] res = new double[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < A[0].length; k++) {
					res[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return res;
	}

	
	public static double l2Norm(double[] vector) {
		double result = 0;
		for (int i = 0; i < vector.length; i++) {
			result += vector[i] * vector[i];
		}
		return Math.sqrt(result);
	}
	
	public static double lInfinitNorm(double[] vector) {
		double max = Math.abs(vector[0]);
		
		for (int i = 0; i < vector.length; i++) {
			if (Math.abs(vector[i]) > max) {
				max = Math.abs(vector[i]);
			}
		}
		return max;
	}
	
	public static double distanceBetweenTwoL2Vectors(double[] vector1, double[] vector2) {
		double result = 0.0;
		for (int i = 0; i < vector1.length; i++) {
			result += Math.pow(vector1[i] - vector2[i], 2);
		}
		return Math.sqrt(result);
	}
	
	public static double distanceBetweenTwoLInfinitVectors(double[] vector1, double[] vector2) {
		double result = Math.abs(vector1[0] - vector2[0]);
		for (int i = 0; i < vector1.length; i++) {
			if (Math.abs(vector1[i] - vector2[i]) > Math.abs(result)) {
				result = Math.abs(vector1[i] - vector2[i]);
			}
		}
		return result;
	}
	
	private static double maxValue(double[] vector) {
		double max = Math.abs(vector[0]);
		for (int i = 0; i < vector.length; i++) {
			if (Math.abs(vector[i]) > max) {
				max = Math.abs(vector[i]);
			}
		}
		return max;
	}
	
	public static double infinitMatrixNorm(double[][] matrix) {
		double[] result = new double[matrix.length];
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				result[i] += Math.abs(matrix[i][j]);
			}
		}
		return maxValue(result);
	}
	
	public static double frobeniusNorm(double[][] matrix) {
		double result = 0.0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				result += Math.pow(Math.abs(matrix[i][j]), 2);
			}
		}
		return Math.sqrt(result);
	}
	
	private static String numri(int a) {
		String res = "";
		switch (a) {
		case 1:
			res = "parë";
			break;
		case 2:
			res = "dytë";
			break;
		case 3:
			res = "tretë";
			break;
		case 4: 
			res = "katërt";
			break;
		case 5: 
			res = "pestë";
			break;

		default:
			res = "" + a;
			break;
		}
		return res;
	}
}
