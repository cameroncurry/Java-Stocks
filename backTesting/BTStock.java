import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


enum Indexes {
	
	SP_500 ("%5EGSPC"),
	FTSE_100 ("%5EFTSE");
	
	public String symbol;
	Indexes(String symbol){
		this.symbol = symbol;
	}
}


public class BTStock implements Sharpeable {
	
	private ExecutorService e;
	private Future<StockData> future;
	private StockData data;
	
	public BTStock(String query, int... args){
		this.e = Executors.newSingleThreadExecutor();
		this.future = e.submit(new YahooFetcher(query,args));
	}
	
	public BTStock(Indexes index, String datesQuery, int... args){
		this(index.symbol+"-"+datesQuery,args);
	}

	public BTStock(StockData data) {
		this.data = data;
	}
	
	public StockData data(){
		if(this.data == null){
			try {
				this.data = this.future.get();
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				this.e.shutdown();
			}
		}
		return data;
	}
	
	
	//latest price / initial price
	public double totalReturn(){
		double latest = data().adj_close()[data().adj_close().length-1];
		double purchase = data().adj_close()[0];
		
		return latest/purchase - 1;
	}
	
	public double[] incrementalValues(){
		double[] increments = new double[data().adj_close().length-1];
		
		for(int i=0;i<increments.length;i++){
			increments[i] = data().adj_close()[i+1] / data().adj_close()[i] - 1;
		}
		
		return increments;
	}
	
	
	
}
