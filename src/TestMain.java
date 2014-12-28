import java.io.IOException;


public class TestMain {

	public static void main(String[] args) throws IOException{
		
		//monthly apple prices from Jan 1, 2014 -> Dec 20, 2014
		String aaplQuery = "AAPL-0-1-2014-11-20-2014-m";
		
		DataFetcher.fetchSingleStock(aaplQuery);
		
	}
}
