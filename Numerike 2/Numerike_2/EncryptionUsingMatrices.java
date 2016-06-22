package Numerike_2;


import javax.swing.JOptionPane;

public class EncryptionUsingMatrices {
	
	public static final int ALPHABET = 26;
	private EncryptionAndDecryptio obj = new EncryptionAndDecryptio();
	
	public static void main(String[] args) {
		EncryptionUsingMatrices test = new EncryptionUsingMatrices();
		String message = JOptionPane.showInputDialog("Sheno tekstin qe deshironi ta enkriptoni:");
		System.out.println("Mesazhi i enkriptuar ne matric");
		int key = 12;
		int[][] matrix = test.encrypt(message, key);
		String decryptedText = test.decrypt(matrix, key);
        
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("Mesazhi i dekriptuar");
		System.out.println(decryptedText);
		
	}
	
	
	public int[][] encrypt(String plainText, int key) {		
		String cipherText = obj.encrypt(plainText, key);

		int n = (int) Math.ceil(Math.sqrt(cipherText.length()));
		int[][] matrix = new int[n][n];

		for (int i = 0; i < cipherText.length(); i++) {
			matrix[i / n][i % n] = cipherText.charAt(i);
		}
		return matrix;
	}
	
	public String decrypt(int[][] input, int shiftKey) {
		StringBuilder s = new StringBuilder();

		for (int[] row : input) {
			for (int element : row) {
				if (element == 0) 
					break;
				s.append((char) element);
			}
		}
		return obj.decrypt(s.toString(), shiftKey);
    }

	class EncryptionAndDecryptio {
		private static final int ALPHABET = 26;

		public String encrypt(String message, int shiftKey) {
			shiftKey = shiftKey % ALPHABET + ALPHABET;
			char[] resultChars = new char[message.length()];

			for (int i = 0; i < message.length(); i++) {
				char currentChar = message.charAt(i);
				char a = 'a';
				resultChars[i] = (char) ((currentChar - a + shiftKey) % ALPHABET + a);
			}
			return new String(resultChars);
		}

		public String decrypt(String message, int shiftKey) {
			return encrypt(message, ALPHABET - shiftKey);
		}
	}
}
