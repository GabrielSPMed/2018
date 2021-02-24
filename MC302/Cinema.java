
public class Cinema extends Varzea{
	
	private String filme;
	private String ambiente;

	public String getFilme() {
		
		return filme;
	
	}

	public void setFilme(String filme) {
	
		this.filme = filme;
	
	}

	public String getAmbiente() {
	
		return ambiente;
	
	}

	public void setAmbiente(String ambiente) {
	
		this.ambiente = ambiente;
	
	}

	public Cinema (String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento, String filme, String ambiente) {
		
		super(titulo, tipo, grupo, privado, previsaoFechamento);
		this.filme=filme;
		this.ambiente=ambiente;
	
	}
	
	public String toString () {
		
		String out;
		
		out = "->Várzea " + getTitulo() + "(" + this.getGrupo().getId() + ")\n";
		out += "->O filme que vai passar é: " + this.filme + "\n";
		out += "->local de exibição do filme é: " + this.ambiente + "\n";
		out += this.getGrupo();
		out += "A previsao de fechamento é: " + super.getPrevisaoFechamento();
		
		return out;
	}
}
