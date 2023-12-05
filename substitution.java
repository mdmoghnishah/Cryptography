package cns;
import java.util.*;
public class substitution {

	public static void main(String[] args) {
		String key,pt,ct="",dt="";
		String cas="",pas;
		Scanner s = new Scanner(System.in);
		//plain alphabet set
		pas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.println("Enter the key text(without whitespaces):"); //reading the input in uppercase
		key=s.next().toUpperCase();//taking the key
		
		cas=cas+key;
		
		//creating the cipher alphabet set
		for(int i=0;i<26;i++){
			int flag=1;
			for(int j=0;j<key.length();j++){
				if(pas.charAt(i)==key.charAt(j)){
					flag=0;
					break;
				}
			}
			if(flag==1){
				cas=cas+pas.charAt(i);
			}
			
		}
		
		System.out.println("Plain alphabet set:"+pas);
		System.out.println("Cipher alphabet set:"+cas);
	
		System.out.println("Enter plain text for encryption(without whitespaces):");
		pt=s.next().toUpperCase();//taking the plain text
		
		//encryption start
		for(int i=0;i<pt.length();i++){
			ct=ct+cas.charAt(pas.indexOf(pt.charAt(i)));
			}
		//encryption end
		System.out.println("Plain text:"+pt);
		System.out.println("Cipher text:"+ct);
		
		//decryption of the encrypted text
		for(int i=0;i<ct.length();i++){
			dt=dt+pas.charAt(cas.indexOf(ct.charAt(i)));
			}
		//decryption end
		System.out.println("Decrypted text:"+dt);
	}

}