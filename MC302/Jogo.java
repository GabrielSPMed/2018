import java.util.ArrayList;

public enum Jogo {

	Truco("Truco", "Jogo dinâmico de baralho e blefe para 4 pessoas", 4, 4, Categoria.Baralho, Categoria.Blefe, Categoria.Roubo),
	TrucoDe6("TrucoDe6", "Truco, só que de 6 pessoas", 6, 6, Categoria.Baralho, Categoria.Blefe, Categoria.Roubo),
	Fodinha("Fodinha", "Similar a truco, mas individual e com apostas", 2, 20, Categoria.Baralho, Categoria.Aposta, Categoria.Blefe),
	Avalon("Avalon", "Jogo dinâmico de dois tipos e blefe", 5, 10, Categoria.Blefe, Categoria.Mafia, Categoria.Deducao),
	Werewolf("Werewolf", "Jogo dinâmico de blefe e mafia", 6, 21, Categoria.Blefe, Categoria.Mafia, Categoria.Deducao),
	Codenames("Codenames", "Disputa de deducao entre dois times de espioes", 2, 10, Categoria.Deducao, Categoria.Family),
	Coup("Coup", "Jogo rapido de cartas com blefe", 2, 10, Categoria.Blefe, Categoria.Cartas, Categoria.Estrategia);
	
	private final String nome;
	private final String descricao;
	private final int rangeMin;
	private final int rangeMax;
	private final ArrayList<Categoria> categorias;
	
	Jogo(String nome, String descricao, int rangeMin, int rangeMax, Categoria... c){
		
		this.categorias = new ArrayList<Categoria>();
		
		for(Categoria i : c) {
			
			this.categorias.add(i);
			
		}
		
		this.nome = nome;
		this.descricao = descricao;
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		
	}
	
	public String getNome() {
	
		return nome;
	
	}

	public String getDescricao() {
	
		return descricao;
	
	}

	public int getRangeMin() {
	
		return rangeMin;
	
	}

	public int getRangeMax() {
	
		return rangeMax;
	
	}

	public ArrayList<Categoria> getCategorias() {
	
		return categorias;
	
	}

	public String toString() {
		
		String out;
		int i;
		
		out = "--->Jogo: " + getNome() + "\n";
		out = out + "->Descricao: " + getDescricao() + "\n";
		out = out + "->Numero de Jogadores: " + getRangeMin() + " ~ " + getRangeMax() + "\n";
		out = out + "->Categorias: ";
		
		for(i = 0; i < this.categorias.size(); i++) {
			
			out = out + this.categorias.get(i);
			
			if(i != this.categorias.size() - 1) {
				
				out = out + ", ";
				
			}
			
		}
		
		out = out + "\n";
		
		return out;
		
	}
	
}
