package com.kalkulator.biner.operation;

import java.util.*;


/**
 * Class yang berisi fungsi untuk konversi dari bilangan bulat/desimal ke biner,oktal,hexadesimal.
 */
public class Decimal {
	
	/**
	 *		Cek jika data negatif atau kurang dari 1 maka kembalikan kosong/null.
	 * Deklarasi Stack sebagai hasil dari modulo/sisa pembagian, variabel index
	 * untuk pemindahan data, menggunakan struktur data stack karena pengambilan
	 * data dari paling akhir, karena dalam konversi biner data yang diambil pertama
	 * adalah data terakhir.
	 *		Lakukan perulangan, masukan hasil modulo ke stack lalu nilai utama bagi
	 * 2, kondisi jika nilai utama 1/0 maka berhenti. Kondisi nilai 1/0 dideklarasi
	 * sebelum nilai utama dibagi karena mencegah jika nilai belum menyentuh nilai akhir.
	 * 
	 * 4 | 2 = 0 -> 4 dibagi 2 hasilnya 1, maka akan langsung berhenti dan belum sampai 1 bagi 2.
	 * 1 | 2 = 1
	 */
	public byte[] convertToBinary(int val) {
		if(val < 1) {
			return null;
		}
		Stack<Integer> tempResult = new Stack<>();
		int index = 0;
		while(true) {
			tempResult.push(val % 2);
			if(val == 1 || val == 0) break;
			val /= 2;
		}
		byte[] finalResult = new byte[tempResult.size()];
		while(!tempResult.empty()) {
			int tempInt = tempResult.pop();
			finalResult[index++] = (byte)tempInt;
		}
		return finalResult;
	}
	
	/**
	 *		Cek jika nilai kurang dari 1 maka kembalian -1. Strukur data Set untuk hasil setiap operasi.
	 * Menggunakan perulangan untuk operasi, hasil operasi nilai utama modulo 8 dimasukan ke Stack.
	 * Jika nilai utama 0 atau 1 terakhir/1 final maka berhenti. Setiap perulangan jikai utama dibagi 8.
	 *		Variabel finalResult sebagai hasil akhir. Perulangan sampai Stack kosong, var finalResult dikali
	 * 10 agar nilai selanjutnya dapat ditambahkan.
	 * - n = 5, next = 5 -> ekpetasi = 55
	 * - Jika hanya ditambah dan tidak dikali = 5 + 5 = 10
	 * - Jika dikali terlebih dahulu = 5 × 10 = 50, 50 + 5 = 55
	 * Kemudian variabel finalResult ditambah dengan nilai Stack.
	 */
	public int convertToOctal(int val) {
		if(val < 1) return -1;
		Stack<Integer> tempResult = new Stack<>();
		while(true) {
			tempResult.push(val % 8);
			if(val == 1 || val == 0) break;
			val /= 8;
		}
		int finalResult = 0;
		while(!tempResult.empty()) {
			finalResult *= 10;
			finalResult += tempResult.pop();
		}
		return finalResult;
	}
	
	/**
	 *		Cek jika data/nilai kurang dari 1 maka kembalian null/kosong. StringBuilder sebagai wadah
	 * untuk menampung hasil dari setiap operasi. Menggunakan struktur data hash map untuk kondisi
	 * hasil operasi bernilai 10 sampai 15 maka akan diganti A-F. Perulangan hingga data habis atau
	 * sisa 1 yang terakhir. Variabel moduloResult sebagai hasil operasi modulu. Cek jika nilai
	 * moduloResult terdapat/sama dengan key/kunci dari Hhash map maka ambil nilai hash map dari
	 * kunci saat ini lalu tambahkan ke StringBuilder, jika tidak tambahkan langsung ke StringBuilder.
	 * Lalu cek jika nilai utama bernikai 0 atau 1 yang terakhir/1 final maka berhenti. Setiap perulangan
	 * nilai utama dibagi 16.
	 */
	public String convertToHexa(int val) {
		if(val < 1) return null;
		StringBuilder sb = new StringBuilder();
		Map alias = new HashMap<Integer, Character>();
		alias.put(10, 'A');
		alias.put(11, 'B');
		alias.put(12, 'C');
		alias.put(13, 'D');
		alias.put(14, 'E');
		alias.put(15, 'F');
		while(true) {
			int moduloResult = val % 16;
			if(alias.containsKey(moduloResult)) {
				sb.append(alias.get(moduloResult));
			} else {
				sb.append(moduloResult);
			}
			if(val == 1 || val == 0) break;
			val /= 16;
		}
		return sb.toString();
	}
	
}