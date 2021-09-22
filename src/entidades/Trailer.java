package entidades;


public class Trailer {
	private String numLinhasConexoes;
	private String numLinhasPesos;
	
	public Trailer(String numLinhasConexoes, String numLinhasPesos) {
		super();
		this.numLinhasConexoes = numLinhasConexoes;
		this.numLinhasPesos = numLinhasPesos;
	}
	public int getNumLinhasConexoes() {
		return  Integer.valueOf(numLinhasConexoes);
	}
	public int getNumLinhasPesos() {
		return Integer.valueOf(numLinhasPesos);
	}
}
