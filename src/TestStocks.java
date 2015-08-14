import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class TestStocks {

	public static void main(String[] args) {
		/*
		BTStock aapl = new BTStock("AAPL-0-1-2014-11-20-2014-m");
		
		BTStock sp500 = new BTStock(Indexes.SP_500,"0-1-2014-11-20-2014-m");
		
		sp500.data().print();
		System.out.println();
		aapl.data().print();
		*/
		
		
		List<String> list = new LinkedList<String>(Arrays.asList("2014-01-02", "2014-02-03", "2014-03-03",
				"2014-04-01", "2014-05-01", "2014-06-02", "2014-07-01",
				"2014-08-01", "2014-09-02", "2014-10-01", "2014-11-03",
				"2014-12-01"));
		
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			iter.next();
			iter.remove();
			//System.out.println(iter.next());
		}

		/*
		Sharpe s = new Sharpe(aapl);
		
		
		System.out.println("average monthly return: "+s.averageIncrementalReturn());
		System.out.println("stdev monthly return: "+s.stdevIncrementalReturn());
		System.out.println("sharpe ratio: "+s.sharpeRatio());
		*/
	}

}
