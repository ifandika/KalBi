package com.kalkulator.biner;

import com.kalkulator.biner.operation.*;

public class App {
	
	public static void main( String[] args ) throws Exception {
		
		Binary b = new Binary();
		
		System.out.println("b1: "+b.convertToDecimal(new int[] {
				1, 0, 0, 1, 0, 1, 1, 0
			}
		));
		
		System.out.println("b2: "+b.convertToOctal(new byte[] {
				0, 1, 1, 0, 1
			}
		));
		
		System.out.println("b3: "+b.convertToHexa(new byte[] {
				1, 0, 1, 1, 0, 0
			}
		));
		
		Decimal d = new Decimal();
		byte[] res = d.convertToBinary(150);
		int res2 = d.convertToOctal(12570);
		String hexa = d.convertToHexa(30);
		System.out.println("Hexa: "+hexa);
		System.out.println("octal: "+res2);
		System.out.println();
		for(var v : res) {
			System.out.print(v+" ");
		}
		System.out.println();
		
	}
	
}