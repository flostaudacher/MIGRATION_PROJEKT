import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Import {
	/**
	 * variables which are needed in this and in other classes
	 */
	public static String [][] arr;
	public static int anzahlZeilen;
	public static int anzahlSpalten;
	private static final String FILELOCATION= "E:\\Migration_data\\noe_pop_migration_background_2012_2019_lau3.dat";
	private static String InputLine = "";

	/**
	 * all our data gets setup in a 2 D array which can be used in other classes
	 */
	static void setup() {
		getNumOfRowCol();
		arr = new String [anzahlZeilen][anzahlSpalten];
		Scanner sc= null;
		int Rowc = 0;
		System.out.println("Creating Array ...");
		/**
		 * reading our csv file
		 */
		try 
		{
			sc= new Scanner (new BufferedReader(new FileReader(FILELOCATION)));

			while (sc.hasNextLine()) {
				InputLine= sc.nextLine();
				String[] inArr = InputLine.split(";");
				for (int x = 0; x < inArr.length; x++) {
					arr[Rowc][x]=inArr[x];
				}
				Rowc++;
			}
		}catch (Exception e) {
			System.out.println(e);
		}	
	}
	/**
	 * prints our data which was translated to an array to console
	 */
	public static void printArray() {
		for (int Rowc = 0; Rowc < anzahlZeilen; Rowc++) {
			for (int Colc = 0; Colc < anzahlSpalten; Colc++) {
				System.out.println(arr[Rowc][Colc]);
			}
			System.out.println();
		}
		return;
	}
	/**
	 * Scans and calculates the Number of Columms and Rows our file has
	 */
	static void getNumOfRowCol() {
		Scanner sc= null;
		System.out.println("Translating Data to Array ...");
		try {
			sc = new Scanner(new BufferedReader(new FileReader(FILELOCATION)));
			sc.useDelimiter(";");
			while (sc.hasNextLine()) {
				InputLine=sc.nextLine();
				String[] inArr = InputLine.split(";");
				Import.anzahlZeilen++;
				Import.anzahlSpalten = inArr.length;
			}
		} catch (Exception e ) {
			System.out.println(e);
		}
	}
}
