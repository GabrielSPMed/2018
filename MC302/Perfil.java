import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Perfil implements Serializable, Salvavel, Carregavel {
	
	private static final long serialVersionUID = 5972155169461L;
	
	private double avaliacao=0;
	private ArrayList <Usuario> amigos = new ArrayList <Usuario>();
	private boolean baralho;
	private ArrayList <Jogo> myJogos = new ArrayList <Jogo>();
	private String status;
	private ArrayList <Jogo> jogosFavoritos = new ArrayList<Jogo>();
	private boolean notificacao;
	private int numAvaliacoes=0;
	
	//Construtor vazio (informações editadas pelo usuário dentro da Main):
	
	public Perfil () {
		
	}
	
	//->Getters e Setters:
	
	//Avaliação:
	public double getAvaliacao() {
		
		return avaliacao;
	
	}
	
	public void setAvaliacao(double avaliacao) {
	
		this.avaliacao = avaliacao;
	
	}
	
	//Amigos:
	public ArrayList<Usuario> getAmigos() {
	
		return amigos;
	
	}
	
	public void setAmigos(ArrayList<Usuario> amigos) {
	
		this.amigos = amigos;
	
	}
	
	//Baralho:
	public boolean isBaralho() {
	
		return baralho;
	
	}
	
	public void setBaralho(boolean baralho) {
		
		this.baralho = baralho;
		
		if(baralho) {
			
			for(Jogo j : Jogo.values()) {
				
				if(j.getCategorias().contains(Categoria.Baralho)) {
					
					this.addMyJogo(j);
					
				}
				
			}
			
		}
	
	}
	
	
	//myJogos:
	public ArrayList<Jogo> getMyJogos() {
		
		return myJogos;
	
	}
	
	public void setMyJogos(ArrayList<Jogo> myJogos) {
	
		this.myJogos = myJogos;
	
	}
	
	
	//status
	public String getStatus() {
	
		return status;
	
	}
	
	public void setStatus(String status) {
	
		this.status = status;
	
	}
	
	
	//Jogos Favoritos
	public ArrayList<Jogo> getJogosFavoritos() {
		
		return jogosFavoritos;
	
	}
	
	public void setJogosFavoritos(ArrayList<Jogo> jogosFavoritos) {
	
		this.jogosFavoritos = jogosFavoritos;
	
	}
	
	
	//Notificação:
	public boolean isNotificacao() {
		
		return notificacao;
	
	}
	
	public void setNotificacao(boolean notificao) {
	
		this.notificacao = notificao;
	
	}

	//Métodos de acesso das listas:
	
	public boolean addAmigo (Usuario usuario) {
		
		if(this.amigos.contains(usuario)) {
		
			return false;
		
		}
	
		this.amigos.add(usuario);
		return true;
		
	}
	
	public boolean removerAmigo (Usuario usuario) {
		
		return this.amigos.remove(usuario);
	
	}
	
	public boolean checarAmigo (Usuario usuario) {
	
		return this.amigos.contains(usuario);
	
	}
	
	public boolean addMyJogo (Jogo jogo) {
	
		if(this.myJogos.contains(jogo)) {
		
			return false;
		
		}
		
		this.myJogos.add(jogo);
		return true;
	
	}
	
	public boolean removerMyJogo (Jogo jogo) {
	
		return this.myJogos.remove(jogo);
	
	}
	
	public boolean checarMyJogo (Jogo jogo) {
	
		return this.myJogos.contains(jogo);
	
	}
	
	public boolean addJogoFav (Jogo jogo) {
	
		if(this.jogosFavoritos.contains(jogo)) {
		
			return false;
	
		}
		
		this.jogosFavoritos.add(jogo);
		return true;
	
	}
	
	public boolean removerJogoFav (Jogo jogo) {
	
		return this.jogosFavoritos.remove(jogo);
	
	}
	
	public boolean checarJogoFav (Jogo jogo) {
	
		return this.jogosFavoritos.contains(jogo);
	
	}
	
	public void salvarNoArquivo() {
		
		File teste = new File("Perfis.dat");
		
		if(teste.exists()) {
			
			int i;
			ArrayList<Perfil> antigo = new ArrayList<Perfil>();

			ObjectInputStream input = null;
			
			try {
				
				input = new ObjectInputStream(new FileInputStream("Perfis.dat"));
				
				while(true) {
					
					antigo.add((Perfil) input.readObject());
					
				}

			} catch (EOFException endOfFile) {
			
				try {
			
					input.close();
				
				} catch (IOException e) {
				
					e.printStackTrace();
				
				}
					
			} catch (ClassNotFoundException e) {
				
				System.err.println("Classe incompatível para desserialização");
				System.exit(1);
					
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}
		
			try {
				
				ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Perfis.dat"));
			
				for(i = 0; i < antigo.size(); i++) {
					
					file.writeObject(antigo.get(i));
					
				}
				
				file.writeObject(this);
				file.flush();
				file.close();
		
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}
			
		} else {

			try {
				
				ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Perfis.dat"));
			
				file.writeObject(this);
				file.flush();
				file.close();
		
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
			}
			
		}
			
	}
	
	//Método para recuperar cadastro de um usuário a partir de um arquivo:
	
	public void carregarDoArquivo(String nomeArquivo) {
		
		
		
	}
	
	//Recebe a nota atribuida a ele e altera a avaliacao desse perfil
	public void acrescentarNota (float nota) {
	
		this.avaliacao=(this.avaliacao * this.numAvaliacoes + nota)/(this.numAvaliacoes+1);
		this.numAvaliacoes++;
	
	}
	
	public String toString() {
		String out;
		int i;
		out="Avaliacao: " + this.avaliacao + "\n";
		if (this.baralho) {
			out+="Possui baralho\n";
		}
		else {
			out+="Nao possui baralho\n";
		}
		out+="Lista de amigos:\n";
		for (i=0;i<this.amigos.size();i++) {
			out += amigos.get(i).getNome() + "(" + amigos.get(i).getRa() + ")" +"\n";
		}
		out+="Lista de jogos que possui:\n";
		for (i=0;i<this.myJogos.size();i++) {
			out += myJogos.get(i).getNome() +"\n";
		}
		out+="Jogos favoritos:\n";
		for (i=0;i<this.jogosFavoritos.size();i++) {
			out += jogosFavoritos.get(i).getNome() +"\n";
		}
		
		return out;
	}
	
}
