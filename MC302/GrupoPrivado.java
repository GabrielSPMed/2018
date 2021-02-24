import java.util.ArrayList;

public class GrupoPrivado extends Grupo{

	private boolean listaAmigos;
	private ArrayList<Usuario> convidados;
	
	public GrupoPrivado(Host host, boolean lista) {
		
		super(host);
		this.listaAmigos = lista;
		this.convidados = new ArrayList<Usuario>();
		
		if(this.listaAmigos == true) {
			
			for(Usuario i : this.getHost().getUsuario().getPerfil().getAmigos()) {
				
				this.convidados.add(i);
				
			}
			
		}
		
	}
	
	public boolean isListaAmigos() {
	
		return listaAmigos;
	
	}

	public void setListaAmigos(boolean listaAmigos) {
	
		this.listaAmigos = listaAmigos;
	
	}

	public ArrayList<Usuario> getConvidados() {
	
		return convidados;
	
	}

	public boolean addConvidado(Usuario convidado) {
		
		return this.convidados.add(convidado);
		
	}
	
	public boolean removeConvidado(Usuario convidado) {
		
		return this.convidados.remove(convidado);
		
	}
	
	public boolean checarConvidado(Usuario convidado) {
		
		return this.convidados.contains(convidado);
		
	}
	
	public String toString() {
		
		String out;
		
		out = super.toString();
		
		out = out + "->Convidados: \n";
		
		for(Usuario i : this.convidados) {
			
			out = out + "-" + i.getNome() + "\n"; 
			
		}
		
		return out;
		
	}
	
}
