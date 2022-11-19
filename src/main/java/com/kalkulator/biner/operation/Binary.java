package com.kalkulator.biner.operation;

import java.util.*;

/**
 *		Class yang berisi fungsi-fungsi untuk konversi dari bilangan biner ke
 * bilangan desimal, oktal, hexadesimal.
 */
public class Binary {
	
	public Binary() {}
	
	/**
	 * Jika nilai kosong maka kembalian -1.
	 *		Stack sebagai tempat menyimpan hasil operasi karena berprinsip LIFO, {order} untuk
	 * urutan nilai ke-, {temp} sebagai wadah sementara hasil setiap operasi, {rankResult}
	 * hasil dari setiap operasi perpangkatan dari 0 -> ..... Perulangan dari batas panjang 
	 * jumlah nilai. Cek jika nilai bukan 0 maka hitung perpangkatan, jika {order} adalah 
	 * 0/pertama maka masukan nilai 1 ke {Stack}, jika bukan pindahkan nilai hasil perpangkatan
	 * ke {temp}, langsung dipindahkan tidak perlu dikali, karena hasilnya sama | nilai_biner = 1, 
	 * hasil-perpangkatan = 5 -> 1 × 5 = 5 |, masukan nilai {temp} ke {Stack}, setiap perulangan
	 * {order} ditambah 1.
	 *		Proses kedua menghitung hasil, {finalResult} sebagai wadah pertambahan setiap nilai.
	 * Perulangan hingga stack kosong, {finalResult} ditambah nilai dari stack.
	 * 
	 * Rumus: nilai_biner × (2 × urutan_nilai_keberapa)
	 * Contoh: 
	 *			n = 101
	 *				= 1 × 2² , 0 × 2¹ , 1 × 2 pangkat 0
	 *				= 4 		 , 0			, 1
	 *				= 4 + 0 + 1
	 *				= 5
	 */
	public int convertToDecimal(int[] val) throws Exception {
		if(val == null) return -1;
		Stack<Integer> tempNumDec = new Stack<>();
		int order = 0, temp, rankResult = 0;
		for(int i = val.length-1; i >= 0; i--) {
			if(val[i] != 0) {
				rankResult = rankCalculate(order);
				if(order == 0) {
					tempNumDec.push(1);
				} else {
					temp = rankResult;
					tempNumDec.push(temp);
				}
			}
			order++;
		}
		int finalResult = 0;
		while(!tempNumDec.empty()) {
			finalResult += tempNumDec.pop();
		}
		return finalResult;
	}
	
	/**
	 * Fungsi bantuan menghitung perpangkatan.
	 * | 2 pangkat 3
	 * | = 2 × 2 × 2
	 * | = 8
	 *		Jika nilai kosong maka kembalian nilai itu sendiri. {pangkat2} sebagai pangkat bernilai 2.
	 * Perulangan hingga 1 < {rank}, setiap perulangan nilai {pangkat2} dikali dengan 2. Lalu 
	 * kembalian hasil dari {pangkat2} itu sendiri.
	 */
	private int rankCalculate(int rank) throws Exception {
		if(rank == 0) return rank;
		int pangkat2 = 2;
		for(int i = 1; i < rank; i++) {
			pangkat2 *= 2;
		}
		return pangkat2;
	}
	
	private byte[] balikNilai(byte[] value) {
		if(value == null) return null;
		byte[] balik = new byte[value.length];
		int indexBalik = 0;
		for(int i = value.length-1; i >= 0; i--) {
			balik[indexBalik++] = value[i];
		}
		return balik;
	}
	
	// ×××××
	private int[] calculateEachBinaryDigit() {
		
	}
	
	/**
	 * 
	 */
	public int convertToOctal(byte[] val) throws Exception {
		if(val == null) return 0;
		int[] tempResult = new int[val.length];
		int order = 0, rankResult = 0, indexTempResult = 0, temp = 0, group = 0;
		for(int i = val.length-1; i >= 0; i--) {
			if(val[i] == 0) {
				tempResult[indexTempResult++] = 0;
			} else {
				rankResult = rankCalculate(order);
				if(order == 0) {
					tempResult[indexTempResult++] = 1;
				} else {
					// Langsung dimasukan tanpa perlu dikali, karena sama saja hasilnya 1 × n
					temp = rankResult;
					tempResult[indexTempResult++] = temp;
				}
			}
			if(order == 2) {
				order = 0;
			} else {
				order++;
			}
		}
		return octalMergeProcess(tempResult);
	}
	
	/**
	 *		Fungsi untuk menghitung hasil setiap operasi dari nilai biner, lalu proses setiap 3 digit
	 * nilai digabungkan.
	 * - b = 1, 0, 1, 1, 0 
	 * - groub2 = [ 1, 0 ] | groub1 = [ 1, 1, 0 ]
	 * - groub1 = 6 | groub2 = 2
	 * - 2 + 6 = 8 | X
	 * - 2 dan 6 = 26 | √
	 */
	private int octalMergeProcess(int[] value) throws Exception {
		int finalResult = 0;
		for(int i = value.length-1; i >= 0; i--) {
			if(i % 3 == 0 && i != 0) {
				finalResult *= 10;
			}
			finalResult += value[i];
		}
		return finalResult;
	}
	
	/**
	 * 
	 */
	public String convertToHexa(byte[] val) {
		if(val == null) return null;
		int[] tempResult = new int[val.length];
		int order = 0, rankResult = 0, indexTempResult = 0, temp = 0, group = 0;
		for(int i = val.length-1; i >= 0; i--) {
			if(val[i] == 0) {
				tempResult[indexTempResult++] = 0;
			} else {
				rankResult = rankCalculate(order);
				if(order == 0) {
					tempResult[indexTempResult++] = 1;
				} else {
					// Langsung dimasukan tanpa perlu dikali, karena sama saja hasilnya 1 × n
					temp = rankResult;
					tempResult[indexTempResult++] = temp;
				}
			}
			if(order == 3) {
				order = 0;
			} else {
				order++;
			}
		}
		return Arrays.toString(tempResult);
	}
	
}