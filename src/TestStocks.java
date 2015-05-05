import java.io.IOException;
import java.util.concurrent.*;

public class TestStocks {

	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException{
		ExecutorService e = Executors.newFixedThreadPool(1);
		
		String aaplQuery = "AAPL-0-1-2014-11-20-2014-m";
		
		Future<BTStock> aaplFuture = e.submit(new YahooFetcher(aaplQuery,6,5));
		
		BTStock aapl = aaplFuture.get();
		e.shutdown();
		
		
		//aapl.data.print();
		
		Sharpe s = new Sharpe(aapl);
		
		System.out.println("average monthly return: "+s.averageIncrementalReturn());
		System.out.println("stdev monthly return: "+s.stdevIncrementalReturn());
		System.out.println("sharpe ratio: "+s.sharpeRatio());
		
		
		
		//aapl.data.print();
		
		//System.out.println("average monthly return: " + aapl.averageIncrementalReturn());
		//System.out.println("variance: " + aapl.varianceOfIncrementalReturn());
		//System.out.println("variance: " + aapl.stdev());
		
		//System.out.println("sharpe: " + aapl.sharpeRatio());
		
		
		
	}

}
