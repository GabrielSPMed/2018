
public class Host {

	private Usuario usuario;
	private float avaliacao;
	
	private Jogo jogo;
	
	private String nomeBar;
	
	private String sistema;
	private int numParty;
	
	private String filme;
	private String ambiente;
	
	private String tema;
	private boolean politico;
	
	private Varzea varzea;
	
	public Host(Usuario usuario, Jogo jogo) {
		
		this.jogo = jogo;
		this.usuario = usuario;
		
	}
	
	public Host(Usuario usuario) {
		
		this.usuario = usuario;
		
	}
	
	public Host(Usuario usuario, String nomeBar) {
	
		this.nomeBar=nomeBar;
		this.usuario=usuario;
	
	}
	
	public Host(Usuario usuario, String sistema, int numParty) {
	
		this.sistema=sistema;
		this.numParty=numParty;
		this.usuario=usuario;
	
	}
	
	public Host(Usuario usuario, String filme, String ambiente) {
	
		this.usuario=usuario;
		this.filme=filme;
		this.ambiente=ambiente;
	
	}
	
	public Host(Usuario usuario, String tema, boolean politico) {
	
		this.usuario=usuario;
		this.tema=tema;
		this.politico=politico;
	
	}
	
	public Jogo getJogo() {
	
		return jogo;
	
	}

	public void setJogo(Jogo jogo) {
	
		this.jogo = jogo;
	
	}

	public Usuario getUsuario() {
	
		return usuario;
	
	}

	public void setUsuario(Usuario usuario) {
	
		this.usuario = usuario;
	
	}

	public float getAvaliacao() {
	
		return avaliacao;
	
	}

	public void setAvaliacao(float avaliacao) {
	
		this.avaliacao = avaliacao;
	
	}

	public String getNomeBar() {
		
		return nomeBar;
	
	}

	public void setNomeBar(String nomeBar) {
	
		this.nomeBar = nomeBar;
	
	}

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

	public Grupo criarGrupo(Guest... g) {
		
		Grupo grupo = new Grupo(this);
		
		for(Guest i : g) {
			
			grupo.addMembro(i);
			
		}
		
		return grupo;
		
	}
	
	public GrupoPrivado criarGrupoPrivado(boolean lista, Usuario... g) {
		
		GrupoPrivado grupo = new GrupoPrivado(this, lista);
		
		for(Usuario i : g) {
			
			grupo.addConvidado(i);
			
		}
		
		return grupo;
		
	}
	
	//Chamado pelos guests para dar a nota do host
	
	public void atribuirNotaAEsteHost (float nota) {
		try {
			if (nota<0||nota>10) throw  new NotaForaDoRangeException();
			this.usuario.getPerfil().acrescentarNota(nota);
		}
		catch (NotaForaDoRangeException e) {
			System.out.println(e);
		}
	}
	
	
	public Varzea criarVarzea(String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento) {
		
		Varzea v;
		
		if(tipo == TiposVarzea.Jogos) {
			
			v = new Jogos(titulo, tipo, grupo, privado, previsaoFechamento, this.jogo);
			
		} else if(tipo == TiposVarzea.Bar) {
			
			v = new Bar(titulo, tipo, grupo, privado, previsaoFechamento, this.nomeBar);
			
		} else if(tipo == TiposVarzea.Cinema) {
			
			v = new Cinema(titulo, tipo, grupo, privado, previsaoFechamento, this.filme, this.ambiente);
			
		} else if(tipo == TiposVarzea.Debate) {
			
			v = new Debate(titulo, tipo, grupo, privado, previsaoFechamento, this.tema, this.politico);
			
		} else {
			
			v = new Rpg(titulo, tipo, grupo, privado, previsaoFechamento, this.sistema, this.numParty);
			
		}
		
		this.varzea=v;
		
		return v;
		
	}
			
}
