public abstract class Varzea {
	
	private TiposVarzea tipo;
	private Grupo grupo;
	private boolean privado;
	private String previsaoFechamento;
	private String titulo;
	//O plano final é usar a API do google maps para implementar Mapa com PINS, mas não sabemos implementar atualmente:
	@SuppressWarnings("unused")
	private double latitude;
	@SuppressWarnings("unused")
	private double longitude;

	//Construtores
	public Varzea (String titulo, TiposVarzea tipo, Grupo grupo, boolean privado, String previsaoFechamento) {
	
		this.titulo = titulo;
		this.tipo=tipo;
		this.grupo=grupo;
		this.privado=privado;
		this.previsaoFechamento=previsaoFechamento;
		
	}
	
	public Varzea() {
		
	}
	
	//Getters e Setters:
	
	//Tipo da Várzea:
	
	public TiposVarzea getTipo() {
		
		return tipo;
	
	}
	
	public void setTipo(TiposVarzea tipo) {
		
		this.tipo = tipo;
	
	}
	
	
	//Grupo
	
	public Grupo getGrupo() {
	
		return grupo;
	
	}
	
	public void setGrupo(Grupo grupo) {
	
		this.grupo = grupo;
	
	}
	
	
	//Privado
	
	public boolean isPrivado() {
	
		return privado;
	
	}
	
	public void setPrivado(boolean privado) {
	
		this.privado = privado;
	
	}
	
	
	//Previsao de Fechamento
	
	public String getPrevisaoFechamento() {
	
		return previsaoFechamento;
	
	}
	
	public void setPrevisaoFechamento(String previsaoFechamento) {
	
		this.previsaoFechamento = previsaoFechamento;
	
	}
	
	
	//titulo:
	
	public String getTitulo() {
	
		return titulo;
	
	}

	public void setTitulo(String titulo) {
	
		this.titulo = titulo;
	
	}
	
	//Postar a varzea e sua localizacao na lista do aplicativo - não sabemos a implementação dinâmica, a "estática" está na main:
	
	public void postarVarzea() {
		
	}
	
}