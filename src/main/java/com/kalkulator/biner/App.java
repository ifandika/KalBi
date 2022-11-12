package com.kalkulator.biner;

import com.kalkulator.biner.operation.*;

public class App {
	
	public static void main( String[] args ) {
		
		Decimal d = new Decimal();
		byte[] res = d.convertToBinary(20);
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