
public class Debate extends Varzea{
	
	private String tema;
	private boolean politico;

	public String getTema() {
		
		return tema;
	
	}

	public void setTema(String tema) {
	
		this.tema = tema;
	
	}

	public boolean isPolitico() {
	
		return politico;
	
	}

	public void setPolitico(boolean politico) {
	
		this.politico = politico;
	
	}

	public Debate (String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento, String tema, boolean politico) {
	
		super(titulo, tipo, grupo, privado, previsaoFechamento);
		this.tema=tema;
		this.politico=politico;

	}
	
	public String toString () {
		
		String out;
		
		out = "->Várzea " + getTitulo() + "(" + this.getGrupo().getId() + ")\n";
		out += "->O tema desse debate ";
		
		if(this.politico) {
			
			out += "político ";
		
		}
		
		out += "é"+ this.tema + "\n";
		out += this.getGrupo();
		out += "A previsão de fechamento é: " + super.getPrevisaoFechamento();
		
		
		return out;
	}
}
