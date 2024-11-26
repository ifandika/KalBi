package com.kalkulator.biner.operation;

import java.util.*;

/**
 * Kelas berisi fungsi untuk konversi dari Hexadesimal ke Desimal,Biner,Oktal.
 */
public class Hexadecimal {
	private Decimal dec = new Decimal();
	private Map alias = new HashMap<Character, Integer>()
	{
		{
		put('0', 0); put('1', 1); put('2', 2); put('3', 3); put('4', 4); put('5', 5);
		put('6', 6); put('7', 7); put('8', 8); put('9', 9); put('A', 10); put('B', 11);
		put('C', 12); put('D', 13); put('E', 14); put('F', 15);
		}
	};
	
	public Hexadecimal() {}
	
	/**
	 * Konversikan ke bilangan desimal dengan fungsi {convertToNumber}. hasil nilai {decResult}.
	 * Kembalian dengan konversi dari int ke biner dengan fungsi class Binary.
	 */
	public byte[] convertToBinary(String value) throws Exception {
		int[] decArrResult = convertToNumberArr(value);
		int decResult = decimalCalculate(decArrResult);
		byte[] finalResult = dec.convertToBinary(decResult);
		return finalResult;
	}
	
	/**
	 * Fungsi untuk menghitung perpangkatan. Jiia pangkat adalah 0 maka kembalian adalah 1.
	 */
	private int rankCalculate(int rank) throws Exception {
		if(rank == 0) return 1;
		if(rank < 0) throw new RuntimeException("Value is negatif");
		int pangkat = 16;
		for(int i = 1; i < rank; i++) {
			pangkat *= 16;
		}
		return pangkat;
	}
	
	/**
	 * Jika kosong maka kembalian kosong. tempValue} sebagi hasil desimal dari operasi nilai yang
	 * dimasukan. {order} untuk urutan nilai, {orderResult} untuk perpangkatan dalam rumus konversi.
	 * Perulangan dari nilai terakhir, {valTemp} untuk wadah setiap nilai bilangan atu A-F.
	 * Hitung {orderResult} untuk setiap urutan nilai, cek jika {valTemp} terdapt di {alias}
	 * {tempNumber} untuk wadah nilai, jika {valTemp} bilangan 1-9 maka ubah dari char ke int.
	 * jika tidak (A-F) ambil nilai dari {alias}. Jika {order} bukan 0 maka {tempNumber} dikali {orderResult},
	 * jika tidak maka {order} = 0, langsung masukan karena nilai pangkat 0 = 1. Setiap perulangan
	 * {order} ditambah 1. 
	 */
	private int[] convertToNumberArr(String value) throws Exception {
		if(value == null) return null;
		int[] tempValue = new int[value.length()];
		int order = 0, orderResult = 0;
		for(int i = value.length()-1; i >= 0; i--) {
			char valTemp = value.charAt(i);
			orderResult = rankCalculate(order);
			if(alias.containsKey(valTemp)) {
				int tempNumber = 0;
				// Jika bukan A-F
				if((int)alias.get(valTemp) < 10) {
					tempNumber = Integer.valueOf(Character.toString(valTemp));
				}
				else {
					tempNumber = (int)alias.get(valTemp);
				}
				if(order != 0) {
					tempValue[i] = tempNumber * orderResult;
				}
				else {
					tempValue[i] = tempNumber;
				}
			}
			order++;
		}
		return tempValue;
	}
	
	/**
	 * Menjumlahkan beberapa nilai desimal. Jika kosong maka kembalian -1.
	 */
	public int decimalCalculate(int[] value) {
		if(value == null) return -1;
		Integer temp = 0;
		for(int i = 0; i < value.length; i++) {
			temp += value[i];
		}
		return temp.intValue();
	}
	
	/**
	 * 
	 *
	private boolean valueIsValid(String value) throws Exception {
		
		for(int i = 0; i < value.length(); i++) {
			if(!alias.containsKey(value.charAt(i))) return false;
			if(value.charAt(i).equals)
		}
	}
	*/
	
	/**
	 * Lempar parameter ke fungsi {convertToNumber}.
	 */
	public int convertToDecimal(String value) throws Exception {
		if(value == null) return -1;
		int decResult = decimalCalculate(convertToNumberArr(value));
		return decResult;
	}
	
	/**
	 * Jika parameter kosong, kembalian -1. Konversikan ke nilai desimal. 
	 */
	public int convertToOctal(String value) throws Exception {
		if(value == null) return -1;
		int decResult = convertToDecimal(value);
		int octalResult = dec.convertToOctal(decResult);
		return octalResult;
	}
	
}