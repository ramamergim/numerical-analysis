package Numerike_2;

public class NewtonMethodForEquations {
	/**
	 * @param A - Matrix
	 * @info - This method is used only for matrixes with rank 3
	 */
	public static double[][] inverseOfMatrix(double[][] A) {
		double[][] res = new double[3][3];
		double detA = A[0][0] * A[1][1] * A[2][2] + A[0][2] * A[1][0] * A[2][1] + A[2][0] * A[1][2] * A[0][1]
				- A[2][0] * A[1][1] * A[0][2] - A[2][2] * A[1][0] * A[0][1] - A[0][0] * A[2][1] * A[1][2];

		res[0][0] = 1 / detA * (A[1][1] * A[2][2] - A[2][1] * A[1][2]);
		res[0][1] = 1 / detA * (A[0][2] * A[2][1] - A[2][2] * A[0][1]);
		res[0][2] = 1 / detA * (A[0][1] * A[1][2] - A[1][1] * A[0][2]);
		res[1][0] = 1 / detA * (A[1][2] * A[2][0] - A[2][2] * A[1][0]);
		res[1][1] = 1 / detA * (A[0][0] * A[2][2] - A[2][0] * A[0][2]);
		res[1][2] = 1 / detA * (A[0][2] * A[1][0] - A[1][2] * A[0][0]);
		res[2][0] = 1 / detA * (A[1][0] * A[2][1] - A[2][0] * A[1][1]);
		res[2][1] = 1 / detA * (A[0][1] * A[2][0] - A[2][1] * A[0][0]);
		res[2][2] = 1 / detA * (A[0][0] * A[1][1] - A[1][0] * A[0][1]);

		return res;
	}

	public static double[][] function(double x1, double x2, double x3) {
		double[][] res = new double[3][3];
		res[0][0] = 3.0 * x1 - Math.cos(x2 * x3) - 1.0 / 2;
		res[1][0] = x1 * x1 - 81.0 * Math.pow(x2 + 0.1, 2) + Math.sin(x3) + 1.06;
		res[2][0] = Math.exp(-x1 * x2) + 20.0 * x3 + (10 * Math.PI - 3) / 3.0;
		return res;
	}

	public static double[][] derivativeOfFunction(double x1, double x2, double x3) {
		double[][] res = new double[3][3];
		res[0][0] = 3;
		res[0][1] = x3 * Math.sin(x2 * x3);
		res[0][2] = x2 * Math.sin(x2 * x3);
		res[1][0] = 2 * x1;
		res[1][1] = -162 * (x2 + 0.1);
		res[1][2] = Math.cos(x3);
		res[2][0] = -1 * x2 * Math.exp(-1 * x1 * x2);
		res[2][1] = -1 * x1 * Math.exp(-1 * x1 * x2);
		res[2][2] = 20;
		return res;
	}

	public static double[][] newtonEquations(int N, double[][] x, double TOL) {
		double[][] y = new double[x.length][x.length];
		int k = 0;
		while (k < N) {
			double[][] inversedJ = inverseOfMatrix(derivativeOfFunction(x[0][0], x[1][0], x[2][0]));
			y = Vektoret.multiplyMatrixes(inversedJ, function(x[0][0], x[1][0], x[2][0]));
			x = Vektoret.sumOrSubMatrixes(x, y, "-");
			double[] y1 = { y[0][0], y[1][0], y[2][0] };
			if (Vektoret.l2Norm(y1) < TOL) {
				return x;
			}
			k++;
		}
		return x;
	}

	public static void main(String[] args) {
		double[][] A = { { 0.2, 0.1, 0 }, { 0.1, 0.1, 0 }, { -0.1, 0.2, 0 } };
		double[][] x = newtonEquations(5, A, 0.000000000000000001);
		System.out.println("Zgjidhjet jane:");
		System.out.println("x1: " + x[0][0] + "\nx2: " + x[1][0] + "\nx3: " + x[2][0]);
		System.out.println("\nPeraferimi: ");
		System.out.println("E1: " + (3.0 * x[0][0] - Math.cos(x[1][0] * x[2][0]) - 1.0 / 2) + " = 0"); 
		System.out.println("E2: "
				+ (x[0][0] * x[0][0] - 81.0 * Math.pow(x[1][0] + 0.1, 2) + Math.sin(x[2][0]) + 1.06) + " = 0");
		System.out.println("E3: "
				+ (Math.exp(-x[0][0] * x[1][0]) + 20.0 * x[2][0] + (10 * Math.PI - 3) / 3.0) + " = 0"); 
	}
}
