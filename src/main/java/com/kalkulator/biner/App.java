package com.kalkulator.biner;

import java.util.*;

import com.kalkulator.biner.operation.*;

public class App {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("=========");
		Binary binary = new Binary();
		System.out.println(
			"Binary to Decimal -> "+
			binary.convertToDecimal(new int[] {
				1, 0, 0, 1, 0, 1, 1, 0
			})
		);
		System.out.println(
			"Binary to Octal -> "+
			binary.convertToOctal(new byte[] {
				0, 1, 1, 0, 1
			})
		);
		System.out.println(
			"Binary to Hexa -> "+
			binary.convertToHexa(new byte[] {
				1, 0, 1, 0, 1, 1
			})
		);
		
		System.out.println("=========");
		Decimal dec = new Decimal();
		System.out.println(
			"Dec to Binary -> "+
			Arrays.toString(dec.convertToBinary(150))
		);
		System.out.println(
			"Dec to Octal -> "+
			dec.convertToOctal(12570)
		);
		System.out.println(
			"Dec to Hexa -> "+
			dec.convertToHexa(30)
		);
		
		System.out.println("=========");
		Hexadecimal hex = new Hexadecimal();
		System.out.println(
			"Hexa to Binary -> "+
			Arrays.toString(hex.convertToBinary("2B"))
		);
		System.out.println(
			"Hexa to Dec -> "+
			hex.convertToDecimal("22B22")
		);
		System.out.println(
			"Hexa to Octal ->"+
			hex.convertToOctal("2CBF1")
		);
	}
	
}