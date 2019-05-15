package pr8;

class UnsupportedFuctionException extends RuntimeException {
	final private int ERR_CODE;
	UnsupportedFuctionException(String str) {
		this(str,100);
	}
	
	UnsupportedFuctionException(String str, int code) {
		super(str);
		ERR_CODE = code;
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "["+getErrorCode()+"]"+ super.getMessage();
	}
}

public class Ex9 {
	public static void main(String[] args) throws Exception{
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.",100);
	}
}
