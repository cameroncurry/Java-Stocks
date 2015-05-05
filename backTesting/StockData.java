
public class StockData {
	
	//arrays of data from yahoo
	//will be null if data was not requested from Data Fetcher
	private String[] dates;
	private double[] open;
	private double[] high;
	private double[] low;
	private double[] close;
	private double[] volume;
	private double[] adj_close;
	
	
	//dates array is needed for stock data, all other arrays are optional
	public StockData(String[] dates){
		this.dates = dates;
	}
	
	//dates always set
	public String[] dates(){
		return dates;
	}
	
	public double[] open(){
		if(open == null){
			throw new RuntimeException("open data not fetched");
		}
		return open;
	}
	
	public double[] high(){
		if(high == null){
			throw new RuntimeException("high data not fetched");
		}
		return high;
	}
	
	public double[] low(){
		if(low == null){
			throw new RuntimeException("low data not fetched");
		}
		return low;
	}
	
	public double[] close(){
		if(close == null){
			throw new RuntimeException("close data not fetched");
		}
		return close;
	}
	
	public double[] volume(){
		if(volume == null){
			throw new RuntimeException("volume data not fetched");
		}
		return volume;
	}
	
	public double[] adj_close(){
		if(adj_close == null){
			throw new RuntimeException("adj_close data not fetched");
		}
		return adj_close;
	}
	
	public void set(int i, double[] array){
		switch(i){
		case 1:
			open = array;
			break;
		case 2:
			high = array;
			break;
		case 3:
			low = array;
			break;
		case 4:
			close = array;
			break;
		case 5:
			volume = array;
			break;
		case 6:
			adj_close = array;
			break;
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public void print(){
		for(int i=0; i<dates.length;i++){
			System.out.printf("%s ",dates[i]);
			
			try{
				System.out.printf("%f ",open[i]);
			}catch(NullPointerException e){
				//don't print anything
			}
			try{
				System.out.printf("%.2f ",high[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.2f ",low[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.2f ",close[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.0f ",volume[i]);
			}catch(NullPointerException e){}
			try{
				System.out.printf("%.2f ",adj_close[i]);
			}catch(NullPointerException e){}
			
			System.out.println();
		}
		
	}
}
