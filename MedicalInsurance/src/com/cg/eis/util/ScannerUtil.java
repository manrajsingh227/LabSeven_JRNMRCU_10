package com.cg.eis.util;

import java.util.Scanner;

public class ScannerUtil {
	private static Scanner scanner=null;

	public static Scanner getScanner() {

		if (null == scanner)
			return new Scanner(System.in);
		else
			return scanner;
	}
}
