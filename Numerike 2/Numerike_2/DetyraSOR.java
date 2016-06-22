package Numerike_2;

/*
 * @author: Mergim Rama
 */

public class DetyraSOR {
	
	public static void main(String[] args) {
		DetyraSOR obj = new DetyraSOR();
		double[][] A = { { 4, 3, 0 },
						 { 3, 4, -1 }, 
						 { 0, -1, 4 } };
		double[] B = { 24, 30, -24 };
		double[] X = { 1, 1, 1 };
		
		double[] resultati = obj.metodaSOR(A, B, X, 1.25, 7, 0.00000000001);
		System.out.println("Zgjidhja ~ ");
		for (int j = 0; j < resultati.length; j++) {
			System.out.print(resultati[j] + " ");
		}
	}
	
	public double[] metodaSOR(double[][] a, double[] b, double[] x0, double w, int N, double TOL) {
		
		double sum = 0;
		int k = 1;
		double[] x = new double[a.length];
		
		while (k <= N) {
			for (int i = 0; i < a.length; i++) {
				sum = 0;
				for (int j = 0; j < a.length; j++) {
					if (j != i) {
						sum = sum + a[i][j] * x0[j];
					}
				}
				x[i] = (1 - w) * x0[i] + (w * (b[i] - sum)) / a[i][i];
				if (lInfinitDistanca(x, x0) < TOL) {
					return x;
				}
				x0[i] = x[i];
			}
			k++;
		}
		return x;
	}

	public double lInfinitDistanca(double[] v1, double[] v2) {
		double maximum = Math.abs(v1[0] - v2[0]);
		for (int i = 1; i < v1.length; i++) {
			if (maximum < Math.abs(v1[i] - v2[i])) {
				maximum = Math.abs(v1[i] - v2[i]);
			}
		}
		return maximum;
	}


}
