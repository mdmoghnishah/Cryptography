package cns;
import java.util.*;
public class hillcipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the key:");
		String key = sc.nextLine().toUpperCase();
		double sq = Math.sqrt(key.length());
		if(sq!=(long)sq){
			System.out.println("Cannot form a square matrix...");
			return;
		}
		int len = (int)sq;
		int [][] keyMatrix = new int[len][len];
		int k = 0;
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				keyMatrix[i][j] = ((int)key.charAt(k))-65;
				k++;
			}
		}
		//for inverse matrix
		int detmod26 = (keyMatrix[0][0]*keyMatrix[1][1]-keyMatrix[0][1]*keyMatrix[1][0])%26;
		int factor;
		int [][] reverseMatrix = new int [2][2];
		for(factor=1;factor<26;factor++){
			if((detmod26 * factor)%26 == 1){
				break;
			}
		}
		reverseMatrix[0][0] = keyMatrix[1][1]*factor%26;
		reverseMatrix[0][1] = (26-keyMatrix[0][1])*factor%26;
		reverseMatrix[1][0] = (26-keyMatrix[1][0])*factor%26;
		reverseMatrix[1][1] = keyMatrix[0][0]*factor%26;
		
		//Encryption
		System.out.println("Enter the string to encrypt:");
		String phrase = sc.nextLine().toUpperCase();
		if(phrase.length()%2 == 1){
			phrase+="Q";
		}
		ArrayList <Integer> phraseToNum = new ArrayList<>();
		ArrayList <Integer> phraseEncoded = new ArrayList<>();
		
		for(int i=0;i<phrase.length();i++){
			phraseToNum.add(phrase.charAt(i)-65);
		}
		for(int i=0;i<phraseToNum.size();i+=2){
			int x = (keyMatrix[0][0]*phraseToNum.get(i)+keyMatrix[0][1]*phraseToNum.get(i+1))%26;
			int y = (keyMatrix[1][0]*phraseToNum.get(i)+keyMatrix[1][1]*phraseToNum.get(i+1))%26;
			phraseEncoded.add(x);
			phraseEncoded.add(y);
		}
		System.out.println("Encrypted message: ");
		for(int i=0;i<phraseEncoded.size();i+=2){
			System.out.print(Character.toChars(phraseEncoded.get(i)+65));
			System.out.print(Character.toChars(phraseEncoded.get(i+1)+65));
			if(i+2<phraseEncoded.size()){
				System.out.print("-");
			}
		}
		System.out.println();

		//Decryption
		
		System.out.println("Enter the string to decrypt:");
		String dphrase = sc.nextLine().toUpperCase();
		if(dphrase.length()%2 == 1){
			dphrase+="Q";
		}
		ArrayList <Integer> dphraseToNum = new ArrayList<>();
		ArrayList <Integer> dphraseDecoded = new ArrayList<>();
		
		for(int i=0;i<dphrase.length();i++){
			dphraseToNum.add(dphrase.charAt(i)-65);
		}
		for(int i=0;i<dphraseToNum.size();i+=2){
			int x = (reverseMatrix[0][0]*dphraseToNum.get(i)+reverseMatrix[0][1]*dphraseToNum.get(i+1))%26;
			int y = (reverseMatrix[1][0]*dphraseToNum.get(i)+reverseMatrix[1][1]*dphraseToNum.get(i+1))%26;
			dphraseDecoded.add(x);
			dphraseDecoded.add(y);
		}
		System.out.println("Decoded message: ");
		for(int i=0;i<dphraseDecoded.size();i+=2){
			System.out.print(Character.toChars(dphraseDecoded.get(i)+65));
			System.out.print(Character.toChars(dphraseDecoded.get(i+1)+65));
			if(i+2<dphraseDecoded.size()){
				System.out.print("-");
			}
		}
		System.out.println();
		
			
		
	}

}