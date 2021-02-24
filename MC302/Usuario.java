import java.io.*;
import java.util.ArrayList;

public class Usuario implements Serializable, Salvavel, Carregavel {

	private static final long serialVersionUID = 5896001452054L;
	
	private int ra;
	private String nome;
	private String senha;
	private Perfil perfil;
	@SuppressWarnings("unused")
	private transient double latitude;
	@SuppressWarnings("unused")
	private transient double longitude;
	//Nao sabemos implementar a API do Google Maps;
	private int curso;
	private String telefone; 
	private String email;
	private transient Host host;
	private transient Guest guest; // glub
	
	//Construtor
	
	public Usuario (int ra, String nome, String senha, int curso, String telefone, String email) {
		
		this.ra=ra;
		this.nome=nome;
		this.senha=senha;
		this.curso=curso;
		this.telefone=telefone;
		this.email=email;
		this.perfil = new Perfil();
		
	}
	
	public Usuario() {
		
	}
	
	//Getters e setters:
	
	
	//Telefone:
	public String getTelefone() {
	
		return telefone;
	
	}
	
	public void setTelefone(String telefone) {
	
		this.telefone = telefone;
	
	}
	
	
	//Email
	public String getEmail() {
		
		return email;
	
	}
	
	public void setEmail(String email) {
	
		this.email = email;
	
	}
	
	
	//RA:
	public int getRa() {
	
		return ra;
	
	}
	
	public void setRa(int ra) {
	
		this.ra = ra;
	
	}
	
	
	//Nome:
	public String getNome() {
		
		return nome;
	
	}
	
	public void setNome(String nome) {
	
		this.nome = nome;
	
	}
	
	
	//Senha:
	public String getSenha() {
		
		return senha;
	
	}
	
	public void setSenha(String senha) {
	
		this.senha = senha;
	
	}
	
	
	//Perfil:
	public Perfil getPerfil() {
		
		return perfil;
	
	}
	
	public void setPerfil(Perfil perfil) {
	
		this.perfil = perfil;
	
	}
	
	
	//Curso:
	public int getCurso() {
	
		return curso;
	
	}
	
	public void setCurso(int curso) {
	
		this.curso = curso;
	
	}
	
	
	//Host:
	public Host getHost() {
	
		return host;
	
	}
	
	public void setHost(Host host) {
	
		this.host = host;
	
	}
	
	//Guest:
	public Guest getGuest() {
	
		return guest;
	
	}
	
	public void setGuest(Guest guest) {
	
		this.guest = guest;
	
	}

	//Método para salvar cadastro do usuário em Arquivo:
	
	public void salvarNoArquivo() {
		
		File teste = new File("Users.dat");
		
		if(teste.exists()) {
			
			int i;
			ArrayList<Usuario> antigo = new ArrayList<Usuario>();

			ObjectInputStream input = null;
			
			try {
				
				input = new ObjectInputStream(new FileInputStream("Users.dat"));
				
				while(true) {
					
					antigo.add((Usuario) input.readObject());
					
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
				
				ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Users.dat"));
			
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
				
				ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("Users.dat"));
			
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
	
	public void carregarDoArquivo(String nomeArquivo, int ra) {
		
		File teste = new File("Users.dat");
		
		Usuario aux = null;
		
		ObjectInputStream input = null;
		boolean achou = false;
		
		if(teste.exists() == false) {
			
			return;
			
		}
		
		try {
			
			input = new ObjectInputStream(new FileInputStream("Users.dat"));
			
			while(true) {
				
				aux = (Usuario) input.readObject();
				
				if(aux.getRa() == ra) {
					
					achou = true;
					break;
					
				}
				
			}
			
			try {
				
				input.close();
			
			} catch (IOException e) {
			
				e.printStackTrace();
			
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
		
		if(achou && aux != null) {

			this.ra = aux.getRa();
			this.nome = aux.getNome();
			this.senha = aux.getSenha();
			this.curso = aux.getCurso();
			this.telefone = aux.getTelefone();
			this.email = aux.getEmail();
			this.perfil = aux.getPerfil();
			
			
		} else {
			
			//System.err.println("Erro na leitura do Usuário");
			
			return;
			
		}
		
	}
	
	public boolean login (String senha) {
		return this.senha.equals(senha);
		//Usuario vai ser encontrado na database pelo email, logo o email ja foi usado para encontrar esse usuario
	}
	
	//toString:
	public String toString () {
	
		String out;
		
		out = "Nome: " + this.nome + "(" + this.ra  + ")\n";
		out += "Curso: " + this.curso + "\n";
		out += "Telefone: " + this.telefone + "\n";
		out += "E-mail: " + this.email + "\n";
		out += this.perfil;
		
		return out;

	}
//kkkk
}
