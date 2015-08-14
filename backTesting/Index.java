
public enum Index {
	/*
	 * from Yahoo symbol appears as ^GSPC
	 * here use %5EGSPC
	 */
	SP_500 ("%5EGSPC"),
	NASDAQ ("%5EIXIC"),
	DOW ("%5EDJI"),
	FTSE_100 ("%5EFTSE");
	
	public String symbol;
	Index(String symbol){
		this.symbol = symbol;
	}
}
