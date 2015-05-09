
public class TestStocks {

	public static void main(String[] args) {
		
		BTStock aapl = new BTStock("AAPL-0-1-2014-11-20-2014-m",6,5);
		//BTStock sp500 = new BTStock(Indexes.SP_500,"0-1-2014-11-20-2014-m",6,5);
		
		//sp500.data().print();
		//aapl.data().print();
		
		
		Sharpe s = new Sharpe(aapl);
		
		System.out.println("average monthly return: "+s.averageIncrementalReturn());
		System.out.println("stdev monthly return: "+s.stdevIncrementalReturn());
		System.out.println("sharpe ratio: "+s.sharpeRatio());
		
	}

}
