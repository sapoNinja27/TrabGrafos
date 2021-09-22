package entidades;


public class ResumoPesos {
	private String noOrigem;
	private String noDestino;
	private String pesoAresta;
	
	
	public ResumoPesos(String noOrigem, String noDestino, String pesoAresta) {
		super();
		this.noOrigem = noOrigem;
		this.noDestino = noDestino;
		this.pesoAresta = pesoAresta;
	}
	public String getNoOrigem() {
		return noOrigem;
	}
	public String getNoDestino() {
		return noDestino;
	}
	public int getPesoAresta() {
		return Integer.valueOf(pesoAresta);
	}
}
