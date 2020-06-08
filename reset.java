/**
 * 
 * @author flost
 * this class is not particularly needed, but it just resets data, protects us from messing up our data on a second Action event if we click a button
 */
public class reset {
	public static void resetAllValuesForNewRun() {
		/**
		 * reseting all values in order to not mess up data after a second button click
		 */
		barchartMethods.Version = 0;	
		Import.anzahlZeilen = 0;
		Import.anzahlSpalten = 0;
		areachartMethods.averageArr[0]=0;
		areachartMethods.averageArr[1]=0;
	}
}
