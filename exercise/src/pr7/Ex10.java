package pr7;

class MyTv2 {
	boolean isPowerOn;
	int channel;
	int volume;
	int prevChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public void gotoPrevChannel() {
		this.setChannel(this.prevChannel);
	}
	
	//getter setter
	
	public void setIsPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	
	public boolean getIsPowerOn() {
		return this.isPowerOn;
	}
	
	public void setChannel(int channel) {
		if(this.channel != 0) this.prevChannel = this.channel; 
		this.channel = channel;
	}
	
	public int getChannel() {
		return this.channel;
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume() {
		return this.volume;
	}
}

public class Ex10 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());
	}
}
