package feature.base;

import java.util.Scanner;

public abstract class BaseView {
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
}
