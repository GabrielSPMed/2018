
public class Bar extends Varzea{
	
	private String nomeBar;
	
	public String getNomeBar() {
	
		return nomeBar;
	
	}

	public void setNomeBar(String tituloBar) {
	
		this.nomeBar = tituloBar;
	
	}

	public Bar (String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento, String nomeBar) {
	
		super(titulo, tipo, grupo, privado, previsaoFechamento);
		this.nomeBar = nomeBar;
	
	}
	
	public String toString () {
	
		String out;
		
		out = "->Várzea " + getTitulo() + "(" + this.getGrupo().getId() + ")\n";
		out += "->Estamos no bar " + this.nomeBar + "\n";
		out += "->Seus integrantes são: \n -Anfitrião: " + this.getGrupo().getHost().getUsuario().getNome() + "(" + this.getGrupo().getHost().getUsuario().getRa()+")\n";
		out += this.getGrupo();
		out += "A previsão de fechamento é: " + super.getPrevisaoFechamento();
		
		return out;
		
	}
}
