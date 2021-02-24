
public class Rpg extends Varzea{
	
	private String sistema;
	private int numParty;	

	public String getSistema() {
	
		return sistema;
	
	}

	public void setSistema(String sistema) {
	
		this.sistema = sistema;
	
	}

	public int getNumParty() {
	
		return numParty;
	
	}

	public void setNumParty(int numParty) {
	
		this.numParty = numParty;
	
	}

	public Rpg(String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento, String sistema, int numParty) {
	
		super(titulo, tipo, grupo, privado, previsaoFechamento);
		this.sistema=sistema;
		this.numParty=numParty;
	
	}
	
	public String toString () {
		
		String out;
		
		out = "->Várzea " + getTitulo() + "(" + this.getGrupo().getId() + ")\n";
		out += "->Sistema de RPG a ser jogado: " + this.sistema + "\n";
		out += "-O tamanho desejado para a Party é: " + this.numParty + "\n";
		out += this.getGrupo();
		out += "A previsão de fechamento é: " + super.getPrevisaoFechamento();
		
		return out;
	}
}
