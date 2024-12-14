package com.leema.app.util;

import java.time.LocalDate;
import java.util.Scanner;

public class InputUtils {
	private static final Scanner scanner = new Scanner(System.in);

	public static int lerInt() {
		return Integer.parseInt(scanner.nextLine().trim());
	}

	public static Long lerLong() {
		Long o = scanner.nextLong();
		scanner.nextLine();
		return o;
	}

	public static Double lerDouble() {
		return Double.parseDouble(scanner.nextLine().trim());
	}

	public static String lerString() {
		return scanner.nextLine();
	}

	public static LocalDate lerData() {
		return LocalDate.parse(lerString());
	}

}
