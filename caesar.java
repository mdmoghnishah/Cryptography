package cns;
import java.util.*;
public class caesar {

	public static void main(String[] args) {
		int key;
		String pt,ct="",dt="";
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the key between 0 to 25:");
		key = s.nextInt();
		if(key>25)
		{
			key = key%26;
		}
		
		System.out.println("Enter the plain text:");
		pt=s.next().toUpperCase();
		
		for(int i=0;i<pt.length();i++){		
		 int a =pt.charAt(i)-65;
		 int c=( a+key)%26;
		 c=c+65;
		 ct=ct+(char)c;
		 }
 System.out.println("Plain text:"+pt);
System.out.println("Encrypted cipher text:"+ct);


for(int i=0;i<ct.length();i++){		
	 int a =ct.charAt(i)-65;
	 int c=(a-key)%26;
	 c=Math.floorMod(c, 26);
	 
	 c=c+65;
	 dt=dt+(char)c;
	 }
System.out.println("Decrypted  text:"+dt);
}
}
