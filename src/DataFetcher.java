import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class DataFetcher {

	// sample data request urls
	// daily
	// http://real-chart.finance.yahoo.com/table.csv?s=AAPL&d=6&e=5&f=2014&g=d&a=11&b=12&c=1980&ignore=.csv
	// weekly
	// http://real-chart.finance.yahoo.com/table.csv?s=AAPL&a=11&b=12&c=1980&d=06&e=5&f=2014&g=w&ignore=.csv
	// monthly
	// http://real-chart.finance.yahoo.com/table.csv?s=AAPL&a=11&b=12&c=1980&d=06&e=5&f=2014&g=m&ignore=.csv
	// dividend
	// http://real-chart.finance.yahoo.com/table.csv?s=AAPL&a=11&b=12&c=1980&d=06&e=5&f=2014&g=v&ignore=.csv
	
	
	//query string must have the form symbol-startDate-endDate-frequency
	//where start and end data have the form mm-dd-yyy
	//and frequency is either d (daily), w (weekly), m (monthly), v (dividend only) 
	
	public static void fetchSingleStock(String query) throws IOException{
		String[] components = query.split("-");
		
		//generate url
		URL url = new URL("http://real-chart.finance.yahoo.com/table.csv?"
				+ "s=" + components[0]
				+ "&a="+ components[1]
				+ "&b="+ components[2]
				+ "&c="+ components[3]
				+ "&d="+ components[4]
				+ "&e="+ components[5]
				+ "&f="+ components[6]
				+ "&g="+ components[7]
				+ "&ignore=.csv");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
		}
		
		
		
	}
	
	
	
}
