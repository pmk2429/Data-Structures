package input_output.standardio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public final class StdIn {

	// no need to instantiate this class.
	private StdIn() {
	}

	private static Scanner scanner;

	// assume Unicode UTF-8 encoding
	private static final String CHARSET_NAME = "UTF-8";

	// assuming language = English
	private static final Locale LOCALE = Locale.US;

	// the default token separator; we maintain the invariant that this value is
	// held by scanner's delimiter between calls
	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

	// makes whitespace chars significant
	private static final Pattern EMPTY_PATTERN = Pattern.compile("");

	// entire input
	private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

	public static boolean isEmpty() {
		return !scanner.hasNext();
	}

	public static boolean hasNextLine() {
		return scanner.hasNextLine();
	}

	public static boolean hasNextChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		boolean result = scanner.hasNext();
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return result;
	}

	public static String readLine() {
		String line;
		try {
			line = scanner.nextLine();
		} catch (Exception e) {
			line = null;
		}
		return line;
	}

	public static char readChar() {
		scanner.useDelimiter(EMPTY_PATTERN);
		String ch = scanner.next();
		assert (ch.length() == 1) : "Internal (Std)In.readChar() error!" + " Please check API";
		scanner.useDelimiter(WHITESPACE_PATTERN);
		return ch.charAt(0);
	}

	/**
	 * Reads and returns the remainder of the input, as a String.
	 * 
	 * @return the remainder of the input, as a string
	 */
	public static String readAll() {
		if (!scanner.hasNextLine()) {
			return "";
		}
		String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
		scanner.useDelimiter(WHITESPACE_PATTERN); // but let's do it anyway
		return result;
	}

	public static String readString() {
		return scanner.next();
	}

	/**
	 * 
	 * <h1>readInt()</h1>Reads the next token from standard input, parses it as
	 * an integer, and returns the integer.
	 * <p>
	 * </p>
	 * 
	 * @return the next integer on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as an <tt>int</tt>
	 */
	public static int readInt() {
		return scanner.nextInt();
	}

	/**
	 * <h1>readDouble()</h1>Reads the next token from standard input, parses it
	 * as a double, and returns the double.
	 * 
	 * @return the next double on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>double</tt>
	 */
	public static double readDouble() {
		return scanner.nextDouble();
	}

	/**
	 * <h1>readFloat()</h1>Reads the next token from standard input, parses it
	 * as a float, and returns the float.
	 * 
	 * @return the next float on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>float</tt>
	 */
	public static float readFloat() {
		return scanner.nextFloat();
	}

	/**
	 * <h1>readLong()</h1>Reads the next token from standard input, parses it as
	 * a long integer, and returns the long integer.
	 * 
	 * @return the next long integer on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>long</tt>
	 */
	public static long readLong() {
		return scanner.nextLong();
	}

	/**
	 * <h1>readShort()</h1>Reads the next token from standard input, parses it
	 * as a short integer, and returns the short integer.
	 * 
	 * @return the next short integer on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>short</tt>
	 */
	public static short readShort() {
		return scanner.nextShort();
	}

	/**
	 * <h1>readByte()</h1>Reads the next token from standard input, parses it as
	 * a byte, and returns the byte.
	 * 
	 * @return the next byte on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>byte</tt>
	 */
	public static byte readByte() {
		return scanner.nextByte();
	}

	/**
	 * Reads the next token from standard input, parses it as a boolean, and
	 * returns the boolean.
	 * 
	 * @return the next boolean on standard input
	 * @throws InputMismatchException
	 *             if the next token cannot be parsed as a <tt>boolean</tt>:
	 *             <tt>true</tt> or <tt>1</tt> for true, and <tt>false</tt> or
	 *             <tt>0</tt> for false, ignoring case
	 */
	public static boolean readBoolean() {
		String s = readString();
		if (s.equalsIgnoreCase("true"))
			return true;
		if (s.equalsIgnoreCase("false"))
			return false;
		if (s.equals("1"))
			return true;
		if (s.equals("0"))
			return false;
		throw new InputMismatchException();
	}

	/**
	 * Reads all remaining tokens from standard input and returns them as an
	 * Array of strings.
	 * <p>
	 * </p>
	 * ***IMP
	 * <p>
	 * </p>
	 * 
	 * @return all remaining tokens on standard input, as an array of strings
	 */
	public static String[] readAllStrings() {
		// we could use readAll.trim().split(), but that's not consistent
		// because trim() uses characters 0x00..0x20 as whitespace
		String[] tokens = WHITESPACE_PATTERN.split(readAll());
		if (tokens.length == 0 || tokens[0].length() > 0) {
			return tokens;
		}

		// don't include first token if it is leading whitespace
		String[] decapitokens = new String[tokens.length - 1];
		for (int i = 0; i < tokens.length - 1; i++) {
			decapitokens[i] = tokens[i + 1];
		}
		return decapitokens;
	}

	/**
	 * Reads all remaining lines from standard input and returns them as an
	 * Array of strings.
	 * 
	 * @return all remaining lines on standard input, as an array of strings
	 */
	public static String[] readAllLines() {
		ArrayList<String> lines = new ArrayList<String>();
		while (hasNextLine()) {
			lines.add(readLine());
		}
		return lines.toArray(new String[0]);
	}

	/**
	 * Reads all remaining tokens from standard input, parses them as integers,
	 * and returns them as an Array of integers.
	 * 
	 * @return all remaining integers on standard input, as an array
	 * @throws InputMismatchException
	 *             if any token cannot be parsed as an <tt>int</tt>
	 */
	public static int[] readAllInts() {
		String[] fields = readAllStrings();
		int[] vals = new int[fields.length];
		for (int i = 0; i < fields.length; i++)
			vals[i] = Integer.parseInt(fields[i]);
		return vals;
	}

	/**
	 * Reads all remaining tokens from standard input, parses them as doubles,
	 * and returns them as an Array of doubles.
	 * 
	 * @return all remaining doubles on standard input, as an array
	 * @throws InputMismatchException
	 *             if any token cannot be parsed as a <tt>double</tt>
	 */
	public static double[] readAllDoubles() {
		String[] fields = readAllStrings();
		double[] vals = new double[fields.length];
		for (int i = 0; i < fields.length; i++)
			vals[i] = Double.parseDouble(fields[i]);
		return vals;
	}

	// do this once when StdIn is initialized
	static {
		resync();
	}

	private static void resync() {
		setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
	}

	private static void setScanner(Scanner scanner) {
		StdIn.scanner = scanner;
		StdIn.scanner.useLocale(LOCALE);
	}

	/**
	 * Reads all remaining tokens, parses them as integers, and returns them as
	 * an array of integers.
	 * 
	 * @return all remaining integers, as an array
	 * @throws InputMismatchException
	 *             if any token cannot be parsed as an <tt>int</tt>
	 * @deprecated For more consistency, use {@link #readAllInts()}
	 */
	public static int[] readInts() {
		return readAllInts();
	}

	/**
	 * Reads all remaining tokens, parses them as doubles, and returns them as
	 * an array of doubles.
	 * 
	 * @return all remaining doubles, as an array
	 * @throws InputMismatchException
	 *             if any token cannot be parsed as a <tt>double</tt>
	 * @deprecated For more consistency, use {@link #readAllDoubles()}
	 */
	public static double[] readDoubles() {
		return readAllDoubles();
	}

	/**
	 * Reads all remaining tokens and returns them as an array of strings.
	 * 
	 * @return all remaining tokens, as an array of strings
	 * @deprecated For more consistency, use {@link #readAllStrings()}
	 */
	public static String[] readStrings() {
		return readAllStrings();
	}

	/**
	 * Create an input stream from a socket.
	 */
	public StdIn(java.net.Socket socket) {
		try {
			InputStream is = socket.getInputStream();
			scanner = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
			scanner.useLocale(LOCALE);
		} catch (IOException ioe) {
			System.err.println("Could not open " + socket);
		}
	}

	/**
	 * Create an input stream from a URL.
	 */
	public StdIn(URL url) {
		try {
			URLConnection site = url.openConnection();
			InputStream is = site.getInputStream();
			scanner = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
			scanner.useLocale(LOCALE);
		} catch (IOException ioe) {
			System.err.println("Could not open " + url);
		}
	}

	/**
	 * Create an input stream from a file.
	 */
	public StdIn(File file) {
		try {
			scanner = new Scanner(file, CHARSET_NAME);
			scanner.useLocale(LOCALE);
		} catch (IOException ioe) {
			System.err.println("Could not open " + file);
		}
	}

	/**
	 * Create an input stream from a filename or web page name.
	 */
	public StdIn(String s) {
		try {
			// first try to read file from local file system
			File file = new File(s);
			if (file.exists()) {
				scanner = new Scanner(file, CHARSET_NAME);
				scanner.useLocale(LOCALE);
				return;
			}

			// next try for files included in jar
			URL url = getClass().getResource(s);

			// or URL from web
			if (url == null) {
				url = new URL(s);
			}

			URLConnection site = url.openConnection();

			// in order to set User-Agent, replace above line with these two
			// HttpURLConnection site = (HttpURLConnection)
			// url.openConnection();
			// site.addRequestProperty("User-Agent", "Mozilla/4.76");

			InputStream is = site.getInputStream();
			scanner = new Scanner(new BufferedInputStream(is), CHARSET_NAME);
			scanner.useLocale(LOCALE);
		} catch (IOException ioe) {
			System.err.println("Could not open " + s);
		}
	}

	/**
	 * Interactive test of basic functionality.
	 */
	public static void main(String[] args) {

		System.out.println("Type a string: ");
		String s = StdIn.readString();
		System.out.println("Your string was: " + s);
		System.out.println();

		System.out.println("Type an int: ");
		int a = StdIn.readInt();
		System.out.println("Your int was: " + a);
		System.out.println();

		System.out.println("Type a boolean: ");
		boolean b = StdIn.readBoolean();
		System.out.println("Your boolean was: " + b);
		System.out.println();

		System.out.println("Type a double: ");
		double c = StdIn.readDouble();
		System.out.println("Your double was: " + c);
		System.out.println();

	}

}
