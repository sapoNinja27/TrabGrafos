package entidades;


public class Header {
	private String totNos;
	private String somaPesos;
	
	
	public Header(String totNos, String somaPesos) {
		super();
		this.totNos = totNos;
		this.somaPesos = somaPesos;
	}
	public String getTotNos() {
		return totNos;
	}
	public int getSomaPesos() {
		return Integer.valueOf(somaPesos);
	}
}
