
public class Jogos extends Varzea{
	
	private Jogo jogo;
	
	public Jogo getJogo() {
		
		return jogo;
	
	}

	public void setJogo(Jogo jogo) {
	
		this.jogo = jogo;
	
	}

	public Jogos(String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento, Jogo jogo) {
		
		super(titulo, tipo, grupo, privado, previsaoFechamento);
		this.jogo=jogo;
	
	}
	
	public String toString () {
		
		String out;
		
		out = "->Várzea " + getTitulo() + "(" + this.getGrupo().getId() + ")\n";
		out += "->O jogo que está sendo jogado é: " + this.jogo.getNome() + "\n";
		out += this.getGrupo();
		out +="A previsão de fechamento é: " + this.getPrevisaoFechamento();
		
		return out;
	}
}
