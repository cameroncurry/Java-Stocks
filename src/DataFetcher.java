import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


public class DataFetcher {

	public static StockData fetchSingleStock(String query, int... args) throws IOException {
		
		//query string must have the form symbol-startDate-endDate-frequency
		//where start and end data have the form mm-dd-yyy
		//and frequency is either d (daily), w (weekly), m (monthly), v (dividend only) 
	
		//yahoo supplies data in the form: Date,Open,High,Low,Close,Volume,Adj Close
	
		//args specifies which data to keep from url request
		//eg. for closing price and volume: args = {4,5}
		//Date is always stored in StockData
	
	
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
		
		//List of lists to hold data
		ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
		for(int i=0; i<args.length; i++){
			data.add(new ArrayList<Double>());	
		}
		
		//list of Strings to hold dates
		ArrayList<String> dateList = new ArrayList<String>();
		
		String s;
		while ((s = in.readLine()) != null) {
			
			if(!s.startsWith("Date")){
				String[] line = s.split(",");
				
				dateList.add(line[0]);
				
				for(int i=0; i<args.length; i++){
					if(args[i] != 0){
						data.get(i).add(Double.parseDouble(line[args[i]]));
					}
				}
			}
		}
		
		
		int len = dateList.size();
		String[] dates = new String[len];
		
		//reverse order of all elements in arrayLists
		for(int i=0; i<len; i++){
			dates[i] = dateList.get(len-1-i);
		}
		
		StockData stockData = new StockData(dates);
		
		for(int i=0; i<args.length;i++){
			double[] array = new double[len];
			for(int j=0;j<len;j++){
				ArrayList<Double> list = data.get(i);
				array[j] = list.get(len-1-j);
			}
			stockData.set(args[i],array);
		}
		
		return stockData;
	}

	
	
}
