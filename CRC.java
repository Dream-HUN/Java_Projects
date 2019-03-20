package Package;

import java.util.Scanner;

public class CRC {
	
	public static String toBin(String a) {
		String b = "";
		String s;
		for(int i = 0; i < a.length(); i++) {
			s = Integer.toBinaryString((int)a.charAt(i));
				for(int u = 0; s.length() < 8; u++) {
					s = "0" + s;
				}
			b += s;
		}
		
		return b;
	}
	
	public static String crctest(String a,String gen) {
		String s = "";
		String h = "";
		String tol = "";
		int i;
		int o = 0;
		int u;
		int fuz = 0;
		for( i = 0; i < gen.length()-1; i++ ) {
			a += "0";
		}
		
		while(s.length() == 0) {
			if(a.charAt(o) == '1') {
				for( u = 0; u < gen.length(); u++ ) {
					s += a.charAt(o + u);
				}
				System.out.printf("%s \n",s);
				fuz--;
			}else {
				tol += " ";
				o++;
				fuz++;
			}
		}
		
		fuz += gen.length(); 

		System.out.printf("%s\n",a);
		System.out.print(tol + gen);
		for( u = fuz; u < a.length()-1; u++ )System.out.print("|");
		System.out.println();
		i = 0;
		while( i < a.length()-(gen.length()) && fuz != a.length()-1 ){
			for( u = 0; u < gen.length(); u++ ) {
				if(s.charAt(u) == gen.charAt(u)) {
					h += '0'; 
				}else {
					h += '1';
				}
			}
			while( h.charAt(0) == '0' && fuz != a.length()-1 ) {
				s = "";
				fuz++;
				for( u = 1; u < gen.length(); u++ ) {
					s += h.charAt(u);
				}
				s += a.charAt(fuz);
				h = s;
				//if(i != 0)
					tol += " ";
			}
			s = h;
			h = "";
			i++;
				System.out.printf("%s%s",tol,s);
				for( u = fuz; u < a.length()-1; u++ )System.out.print("|");
				
			if(s.charAt(0) == '1') {
				System.out.printf("\n%s%s",tol,gen);
				for( u = fuz; u < a.length()-1; u++ )System.out.print("|");
				System.out.println();
			}
		}
		
		if(s.length() == gen.length() && s.charAt(0) == '1') {
			for( u = 0; u < gen.length(); u++ ) {
				if(s.charAt(u) == gen.charAt(u)) {
					h += '0'; 
				}else {
					h += '1';
				}
			}
			tol += "";
			s = h;
		}else { 
			System.out.println();
			System.out.printf("%s%s\n",tol,s);
		}
		return s;
	} 
	
	public static void main(String[] t) {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		String gen;
		String mess;
		String crc = ""; 
		
		System.out.printf("Give me a text:");
		mess = s.nextLine();

		System.out.printf("Give me a generator:");
		gen = s.nextLine();
		
		System.out.printf("\ncrc: %s ", crctest(toBin(mess),gen));
	}
}
