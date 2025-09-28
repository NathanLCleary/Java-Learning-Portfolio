public class Rooms {
	
	private int temp;
	private int hum;

	private static int id;
	
	Rooms(int temp, int hum){
		this.temp=temp;
		this.hum = hum;
		id++;
	}
	
	public double getTemp(){
		return temp;
	}

	public void setTemp(int temp){
		this.temp=temp;
	}

	public int getId(){
		return id;
	}
}

