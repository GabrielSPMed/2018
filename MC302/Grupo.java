import java.util.ArrayList;

public class Grupo {

	private ArrayList<Guest> membros;
	private Host host;
	private int id;
	private static int idGenerator = 0;
	
	public Grupo(Host host) {
		
		Grupo.idGenerator++;
		this.id = Grupo.idGenerator;
		this.host = host;
		this.membros = new ArrayList<Guest>();
		
	}
	
	public ArrayList<Guest> getMembros() {

		return membros;
	
	}

	public Host getHost() {
	
		return host;
	
	}

	public void setHost(Host host) {
	
		this.host = host;
	
	}

	public int getId() {
	
		return id;
	
	}

	public void setId(int id) {
	
		this.id = id;
	
	}

	public static int getIdGenerator() {
	
		return idGenerator;
	
	}
	
	public boolean addMembro(Guest membro) {
		
		
		if(this.host.getJogo() != null) {
			
			if(this.membros.size() >= host.getJogo().getRangeMax()) {
				
				return false;
				
			}
			
		}
		
			
		if(this.membros.contains(membro)) {
				
			return false;
				
		}
			
		
		this.membros.add(membro);
		return true;
		
	}
	
	public boolean removeMembro(Guest membro) {
		
		return this.membros.remove(membro);
		
	}
	
	public boolean checarMembro(Guest membro) {
		
		return this.membros.contains(membro);
		
	}
	
	public String toString() {
		
		String out;
		int i;
		
		out = "->Grupo" + ":\n";
		out = out + "->Host: " + getHost().getUsuario().getNome() + "\n";
		out += "->Telefone: " + getHost().getUsuario().getTelefone() + "\n";
		
		for(i = 0; i < this.membros.size(); i++) {
			
			out = out + "-Membro " + (i+1) + ": " + this.membros.get(i).getUsuario().getNome() + "\n";
			
		}
		
		return out;
		
	}
	
}
