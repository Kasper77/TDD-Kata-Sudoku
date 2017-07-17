package domain;

public class Numeric {

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
	
	public static int toInteger(String[] line, int k) {
		return Integer.parseInt(line[k]);
	}
}
