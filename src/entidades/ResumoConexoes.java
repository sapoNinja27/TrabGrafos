package entidades;

public class ResumoConexoes {
	private String noOrigem;
	private String noDestino;
	
	public ResumoConexoes(String noOrigem, String noDestino) {
		super();
		this.noOrigem = noOrigem;
		this.noDestino = noDestino;
	}
	public String getNoOrigem() {
		return noOrigem;
	}
	public String getNoDestino() {
		return noDestino;
	}
}
