
public class Guest {

	private Usuario usuario;
	private float avaliacao;
	
	public Guest(Usuario usuario) {
			
		this.usuario = usuario;
		
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
	
	//Para o host e outros guests atribuirem a nota a este guest
	public void atribuirNotaAEsteGuest (float nota) {
		try {
			if (nota<0||nota>10) throw  new NotaForaDoRangeException();
			this.usuario.getPerfil().acrescentarNota(nota);
		}
		catch (NotaForaDoRangeException e) {
			System.out.println(e);
		}
	}
	
}