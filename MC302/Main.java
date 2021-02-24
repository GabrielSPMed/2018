//Sistema Varzeapp

/*--->Main do sistema Várzeapp, referente ao Projeto 1 de MC302 com data de entrega final 26/04/2018
 * 
 * ->Grupo de Desenvolvimento do Projeto:
 * -Eduardo Augusto Simão Vasconcellos (196240)
 * -Gabriel Souza Pinto Medeiros (172497)
 * -Henrique Sandes Lima Almeida (198850)
 * -Vitor Coppo Ferreira (206956)
 * 
 * ->Main referente à primeira parte de execução do projeto, com testes do sistema antes da versão final com interface gráfica.
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		
		/*
		ArrayList<Usuario> cadastrados = new ArrayList<Usuario>();
		cadastrados.add(new Usuario(198850, "Henrique Sandes", "123", 34, "(71) 992744970", "henriquesandes@hotmail.com"));
		cadastrados.add(new Usuario(172497, "Gabriel Medeiros", "456", 34, "(19) 997510704", "gabrielspmedeiros@gmail.com"));
		cadastrados.add(new Usuario(206956, "Vitor Coppo", "789", 34, "(19) 993078412", "coppoferreira@gmail.com"));
		cadastrados.add(new Usuario(196240, "Eduardo Augusto", "000", 34, "(19) 986035043", "eduardo.asvascocellos@gmail.com"));
		*/
		
		ArrayList<Varzea> varzeas = new ArrayList<Varzea>();

		//Exemplos de Várzeas
		
		/*
		cadastrados.get(0).setHost(new Host(cadastrados.get(0), Jogo.Avalon));
		varzeas.add(new Jogos("Várzea Teste", TiposVarzea.Jogos, new Grupo(cadastrados.get(0).getHost()), false, "18h", Jogo.Avalon));
		varzeas.get(0).getGrupo().getMembros().add(new Guest(cadastrados.get(2)));
		
		cadastrados.get(3).setHost(new Host(cadastrados.get(3), "StarClean"));
		varzeas.add(new Bar("Bora beber", TiposVarzea.Bar, new Grupo(cadastrados.get(3).getHost()), false, "03:00h", cadastrados.get(3).getHost().getNomeBar()));
		*/

		//Variáveis auxiliares:
		
		int opcao, i, id;
		GrupoPrivado aux2;
		Varzea aux1;
		boolean ok, baralho, notificacao, priva, polit;
		Jogo jogo;
		String jogoNome, status, fecha, titulo, sistJogado, movie, ambiente, tema, barName;
		Usuario logado, user, auxUser;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		int ra, curso, partyRpg;
		@SuppressWarnings("unused")
		String nome, senha, telefone, email, lixo;

		auxUser = new Usuario();
		
		//Execução do sistema:
		
		System.out.println("--->Bem Vindo ao Varzeapp!<---\n");
		
		while(true) {
			
			System.out.println("Escolha uma das opções abaixo: \n");
			
			System.out.println("1 - Cadastrar novo usuario");
			System.out.println("2 - Logar com usuario existente");
			System.out.println("3 - Sair do aplicativo\n");
			
			opcao = scan.nextInt();
			lixo = scan.nextLine();
			
			if(opcao == 1) {
				
				System.out.println("\nInsira as informações do novo usuário:");
				System.out.print("-RA:");
				ra = scan.nextInt();
				lixo = scan.nextLine();
				ok = true;
				
				auxUser.carregarDoArquivo("Users.dat", ra);
				
				if(auxUser.getRa() == ra) {
					
					ok = false;
					
				}
				
				if(ok == false) {
					
					System.out.println("\nUsuário já cadastrado no sistema!\n");
					continue;
					
				}
				
				System.out.print("-Nome e Sobrenome:");
				nome = scan.nextLine();
				System.out.print("-Senha:");
				senha = scan.nextLine();
				System.out.print("-Curso (Número):");
				curso = scan.nextInt();
				lixo = scan.nextLine();
				System.out.print("-Telefone:");
				telefone = scan.nextLine();
				System.out.print("-E-mail:");
				email = scan.nextLine();
				
				auxUser = new Usuario(ra, nome, senha, curso, telefone, email);
				
				auxUser.salvarNoArquivo();
					
				System.out.println("\nUsuário " + nome + " cadastrado com sucesso!\n");
				
			} else if(opcao == 2) {
				
				System.out.print("\nInsira seu ra:");
				ra = scan.nextInt();
				lixo = scan.nextLine();
				System.out.print("Insira sua senha:");
				senha = scan.nextLine();
				ok = false;
				
				auxUser.carregarDoArquivo("Users.dat", ra);
				
				if(auxUser.getRa() == ra) {
					
					ok = true;
					
				}
				
				if(ok == true) {
					
					logado = auxUser;
					System.out.println("\nBem vindo, " + logado.getNome());
					
					while(true) {
						
						System.out.println("\nEscolha uma das opções abaixo: \n");
						
						System.out.println("1 - Ser Host");
						System.out.println("2 - Ser Guest");
						System.out.println("3 - Editar Perfil");
						System.out.println("4 - Log out\n");
						
						opcao = scan.nextInt();
						lixo = scan.nextLine();
						
						if(opcao == 1) { //Aqui começa as funcionalidades do host
							
							while(true) {
							
								System.out.println("Escolha uma das opções abaixo: \n");
								
								System.out.println("1 - Criar Várzeas");
								System.out.println("2 - Entrar em sua Várzea criada");
								System.out.println("3 - Voltar\n");
								
								opcao = scan.nextInt();
								lixo = scan.nextLine();
								
								if(opcao == 1) {
										
										ok = false;
										
										for(Varzea v : varzeas) {
											
											if(v.getGrupo().checarMembro(logado.getGuest()) || v.getGrupo().getHost().getUsuario() == logado) {
												
												ok = true;
												break;
												
											}
											
										}
										
										if(ok) {
											
											System.out.println("Você já está em uma Várzea, saia da sua primeiro se quiser entrar em outra!\n");
											break;
											
										}
										
										System.out.println("Escolha tipo de Várzea");
										
										for(i = 0; i < TiposVarzea.values().length; i++) {
											
											System.out.println((i+1) + " - " + TiposVarzea.values()[i]);
											
										}
										
										System.out.println("6 - Voltar");
										
										opcao = scan.nextInt();
										lixo = scan.nextLine();
										
										if(opcao == 1) {
											
											System.out.println("Selecione um dos seus jogos:");
											
											for(Jogo j : logado.getPerfil().getMyJogos()) {
												
												System.out.println(j.getNome());
												
											}
											
											jogoNome = scan.nextLine();
											ok = false;
											
											for(i = 0; i < logado.getPerfil().getMyJogos().size(); i++) {
												
												if(jogoNome.equals(logado.getPerfil().getMyJogos().get(i).getNome())) {
													
													ok = true;
													break;
													
												}
												
											}
											
											if(ok) {
												
												jogo = logado.getPerfil().getMyJogos().get(i);
												logado.setHost(new Host(logado, jogo));
												
												System.out.print("Informe título da Várzea:");
												titulo = scan.nextLine();
												
												System.out.print("Informe previsão de horário de fechamento da Várzea:");
												fecha = scan.nextLine();
												
												System.out.print("O Grupo será Privado? (true ou false): ");
												priva = scan.nextBoolean();
												
												if(priva) {
													
													System.out.print("Convidar todos da lista de amigos? (true ou false):");
													ok = scan.nextBoolean();
													
													aux2 = logado.getHost().criarGrupoPrivado(ok);
													
													while(true) {
														
														System.out.print("Quer convidar mais alguém em específico? (true ou false):");
														ok = scan.nextBoolean();
														
														if(ok) {
															
															System.out.print("Digite o RA da pessoa:");
															ra = scan.nextInt();
															lixo = scan.nextLine();
															ok = false;
															
															auxUser.carregarDoArquivo("Users.dat", ra);
															
															if(auxUser.getRa() == ra) {
																
																ok = true;
																
															}
															
															if(ok) {
																
																aux2.addConvidado(auxUser);
																System.out.println("Usuário convidado com sucesso!");
															
															} else {
																
																System.out.println("Usuário não encontrado no sistema!");
																
															}
															
															
														} else {
															
															break;
															
														}
														
													}
													
													aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Jogos, aux2, priva, fecha);
													
													varzeas.add(aux1);
													
												} else {
													
													aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Jogos, logado.getHost().criarGrupo(), false, fecha);
													
													varzeas.add(aux1);
													
												}
												
												while(true) {
													
													System.out.println("Escolha uma das opções abaixo: \n");
													
													System.out.println("1 - Listar informações da Várzea");
													System.out.println("2 - Remover Membro");
													System.out.println("3 - Retirar Várzea da Lista e parar de ser Host");
													System.out.println("4 - Voltar");
													
													opcao = scan.nextInt();
													lixo = scan.nextLine();
													
													if(opcao == 1) {
														
														System.out.println(aux1);
														
													} else if(opcao == 2) {
														
														System.out.print("Digite o RA do Membro a ser retirado da Várzea");
														ra = scan.nextInt();
														lixo = scan.nextLine();
														ok = false;
														
														for(i = 0; i < aux1.getGrupo().getMembros().size(); i++) {
															
															if(aux1.getGrupo().getMembros().get(i).getUsuario().getRa() == ra) {
																
																ok = true;
																break;
																
															}
															
														}
														
														if(ok) {
															
															aux1.getGrupo().getMembros().remove(i);
																
															System.out.println("Membro removido com sucesso");
															
														} else {
															
															System.out.println("Membro não encontrado");
															
														}
														
													}else if(opcao == 3) {
														
														if(varzeas.remove(aux1)) {
															
															System.out.println("Várzea removida do sistema!");
															
														} else {
															
															System.out.println("Erro ao remover sua Várzea do sistema!");
															
														}

														logado.setHost(null);
														
														break;
														
													} else if(opcao == 4) {
													
														break;
														
													}
													
												}
												
											} else {
												
												System.out.println("Jogo não encontrado no sistema!");
												
											}
											
										} else if(opcao == 2) {
											
											System.out.print("Qual o nome do sistema a ser jogado:");
											
											sistJogado = scan.nextLine();
								
											System.out.print("Qual o tamanho desejado do Grupo:");
											
											partyRpg = scan.nextInt();
											lixo = scan.nextLine();
											
											logado.setHost(new Host(logado, sistJogado, partyRpg));
											
											System.out.print("Informe título da Várzea:");
											titulo = scan.nextLine();
											
											System.out.print("Informe previsão de horário de fechamento da Várzea:");
											fecha = scan.nextLine();
											
											System.out.print("O Grupo será Privado? (true ou false): ");
											priva = scan.nextBoolean();
											
											if(priva) {
												
												System.out.print("Convidar todos da lista de amigos? (true ou false):");
												ok = scan.nextBoolean();
												
												aux2 = logado.getHost().criarGrupoPrivado(ok);
												
												while(true) {
													
													System.out.print("Quer convidar mais alguém em específico? (true ou false):");
													ok = scan.nextBoolean();
													
													if(ok) {
														
														System.out.print("Digite o RA da pessoa:");
														ra = scan.nextInt();
														lixo = scan.nextLine();
														ok = false;
														
														auxUser.carregarDoArquivo("Users.dat", ra);
														
														if(auxUser.getRa() == ra) {
															
															ok = true;
															
														}
														
														if(ok) {
															
															aux2.addConvidado(auxUser);
															System.out.println("Usuário convidado com sucesso!");
														
														} else {
															
															System.out.println("Usuário não encontrado no sistema!");
															
														}
														
														
													} else {
														
														break;
														
													}
													
												}
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.RPG, aux2, priva, fecha);
												
												varzeas.add(aux1);
												
											} else {
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.RPG, logado.getHost().criarGrupo(), false, fecha);
												
												varzeas.add(aux1);
												
											}
											
											while(true) {
												

												System.out.println("Escolha uma das opções abaixo: \n");
												
												System.out.println("1 - Listar informações da Várzea");
												System.out.println("2 - Remover Membro");
												System.out.println("3 - Retirar Várzea da Lista e parar de ser Host");
												System.out.println("4 - Voltar");
												
												opcao = scan.nextInt();
												lixo = scan.nextLine();
												
												if(opcao == 1) {
													
													System.out.println(aux1);
													
												} else if(opcao == 2) {
													
													System.out.print("Digite o RA do Membro a ser retirado da Várzea");
													ra = scan.nextInt();
													lixo = scan.nextLine();
													ok = false;
													
													for(i = 0; i < aux1.getGrupo().getMembros().size(); i++) {
														
														if(aux1.getGrupo().getMembros().get(i).getUsuario().getRa() == ra) {
															
															ok = true;
															break;
															
														}
														
													}
													
													if(ok) {
														
														aux1.getGrupo().getMembros().remove(i);
															
														System.out.println("Membro removido com sucesso");
														
													} else {
														
														System.out.println("Membro não encontrado");
														
													}
													
												}else if(opcao == 3) {
													
													if(varzeas.remove(aux1)) {
														
														System.out.println("Várzea removida do sistema!");
														
													} else {
														
														System.out.println("Erro ao remover sua Várzea do sistema!");
														
													}

													logado.setHost(null);
													
													break;
													
												} else if(opcao == 4) {
												
													break;
													
												}
												
											}
												
										} else if(opcao == 3){

											System.out.print("Qual vai ser o filme:");
											movie = scan.nextLine();
							
											System.out.print("Onde vamos ver o filme:");
											ambiente = scan.nextLine();
											
											logado.setHost(new Host(logado, movie, ambiente));
											
											System.out.print("Informe título da Várzea:");
											titulo = scan.nextLine();
											
											System.out.print("Informe previsão de horário de fechamento da Várzea:");
											fecha = scan.nextLine();
											
											System.out.print("O Grupo será Privado? (true ou false): ");
											priva = scan.nextBoolean();
											
											if(priva) {
												
												System.out.print("Convidar todos da lista de amigos? (true ou false):");
												ok = scan.nextBoolean();
												
												aux2 = logado.getHost().criarGrupoPrivado(ok);
												
												while(true) {
													
													System.out.print("Quer convidar mais alguém em específico? (true ou false):");
													ok = scan.nextBoolean();
													
													if(ok) {
														
														System.out.print("Digite o RA da pessoa:");
														ra = scan.nextInt();
														lixo = scan.nextLine();
														ok = false;
														
														auxUser.carregarDoArquivo("Users.dat", ra);
														
														if(auxUser.getRa() == ra) {
															
															ok = true;
															
														}
														
														if(ok) {
															
															aux2.addConvidado(auxUser);
															System.out.println("Usuário convidado com sucesso!");
														
														} else {
															
															System.out.println("Usuário não encontrado no sistema!");
															
														}
														
														
													} else {
														
														break;
														
													}
													
												}
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Cinema, aux2, priva, fecha);
												
												varzeas.add(aux1);
												
											} else {
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Cinema, logado.getHost().criarGrupo(), false, fecha);
												
												varzeas.add(aux1);
												
											}
											
											while(true) {
												

												System.out.println("Escolha uma das opções abaixo: \n");
												
												System.out.println("1 - Listar informações da Várzea");
												System.out.println("2 - Remover Membro");
												System.out.println("3 - Retirar Várzea da Lista e parar de ser Host");
												System.out.println("4 - Voltar");
												
												opcao = scan.nextInt();
												lixo = scan.nextLine();
												
												if(opcao == 1) {
													
													System.out.println(aux1);
													
												} else if(opcao == 2) {
													
													System.out.print("Digite o RA do Membro a ser retirado da Várzea");
													ra = scan.nextInt();
													lixo = scan.nextLine();
													ok = false;
													
													for(i = 0; i < aux1.getGrupo().getMembros().size(); i++) {
														
														if(aux1.getGrupo().getMembros().get(i).getUsuario().getRa() == ra) {
															
															ok = true;
															break;
															
														}
														
													}
													
													if(ok) {
														
														aux1.getGrupo().getMembros().remove(i);
															
														System.out.println("Membro removido com sucesso");
														
													} else {
														
														System.out.println("Membro não encontrado");
														
													}
													
												}else if(opcao == 3) {
													
													if(varzeas.remove(aux1)) {
														
														System.out.println("Várzea removida do sistema!");
														
													} else {
														
														System.out.println("Erro ao remover sua Várzea do sistema!");
														
													}

													logado.setHost(null);
													
													break;
													
												} else if(opcao == 4) {
												
													break;
													
												}

											}
											
										} else if(opcao == 4) {

											System.out.print("Qual vai ser o tema do Debate:");
											tema = scan.nextLine();
								
											System.out.print("O Debate vai envolver política: (true ou false)");
											polit = scan.nextBoolean();
											
											logado.setHost(new Host(logado, tema, polit));
											
											System.out.print("Informe título da Várzea:");
											titulo = scan.nextLine();
											
											System.out.print("Informe previsão de horário de fechamento da Várzea:");
											fecha = scan.nextLine();
											
											System.out.print("O Grupo será Privado? (true ou false): ");
											priva = scan.nextBoolean();
											
											if(priva) {
												
												System.out.print("Convidar todos da lista de amigos? (true ou false):");
												ok = scan.nextBoolean();
												
												aux2 = logado.getHost().criarGrupoPrivado(ok);
												
												while(true) {
													
													System.out.print("Quer convidar mais alguém em específico? (true ou false):");
													ok = scan.nextBoolean();
													
													if(ok) {
														
														System.out.print("Digite o RA da pessoa:");
														ra = scan.nextInt();
														lixo = scan.nextLine();
														ok = false;
														
														auxUser.carregarDoArquivo("Users.dat", ra);
														
														if(auxUser.getRa() == ra) {
															
															ok = true;
															
														}
														
														if(ok) {
															
															aux2.addConvidado(auxUser);
															System.out.println("Usuário convidado com sucesso!");
														
														} else {
															
															System.out.println("Usuário não encontrado no sistema!");
															
														}
														
														
													} else {
														
														break;
														
													}
													
												}
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Debate, aux2, priva, fecha);
												
												varzeas.add(aux1);
												
											} else {
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Debate, logado.getHost().criarGrupo(), false, fecha);
												
												varzeas.add(aux1);
												
											}
											
											while(true) {

												System.out.println("Escolha uma das opções abaixo: \n");
												
												System.out.println("1 - Listar informações da Várzea");
												System.out.println("2 - Remover Membro");
												System.out.println("3 - Retirar Várzea da Lista e parar de ser Host");
												System.out.println("4 - Voltar");
												
												opcao = scan.nextInt();
												lixo = scan.nextLine();
												
												if(opcao == 1) {
													
													System.out.println(aux1);
													
												} else if(opcao == 2) {
													
													System.out.print("Digite o RA do Membro a ser retirado da Várzea");
													ra = scan.nextInt();
													lixo = scan.nextLine();
													ok = false;
													
													for(i = 0; i < aux1.getGrupo().getMembros().size(); i++) {
														
														if(aux1.getGrupo().getMembros().get(i).getUsuario().getRa() == ra) {
															
															ok = true;
															break;
															
														}
														
													}
													
													if(ok) {
														
														aux1.getGrupo().getMembros().remove(i);
															
														System.out.println("Membro removido com sucesso");
														
													} else {
														
														System.out.println("Membro não encontrado");
														
													}
													
												}else if(opcao == 3) {
													
													if(varzeas.remove(aux1)) {
														
														System.out.println("Várzea removida do sistema!");
														
													} else {
														
														System.out.println("Erro ao remover sua Várzea do sistema!");
														
													}

													logado.setHost(null);
													
													break;
													
												} else if(opcao == 4) {
												
													break;
													
												}
												
											}
											
											
										} else if(opcao == 5) {

											System.out.print("Em qual Bar ficaremos:");											
											barName = scan.nextLine();

											logado.setHost(new Host(logado, barName));
											
											System.out.print("Informe título da Várzea:");
											titulo = scan.nextLine();
											
											System.out.print("Informe previsão de horário de fechamento da Várzea:");
											fecha = scan.nextLine();
											
											System.out.print("O Grupo será Privado? (true ou false): ");
											priva = scan.nextBoolean();
											
											if(priva) {
												
												System.out.print("Convidar todos da lista de amigos? (true ou false):");
												ok = scan.nextBoolean();
												
												aux2 = logado.getHost().criarGrupoPrivado(ok);
												
												while(true) {
													
													System.out.print("Quer convidar mais alguém em específico? (true ou false):");
													ok = scan.nextBoolean();
													
													if(ok) {
														
														System.out.print("Digite o RA da pessoa:");
														ra = scan.nextInt();
														lixo = scan.nextLine();
														ok = false;
														
														auxUser.carregarDoArquivo("Users.dat", ra);
														
														if(auxUser.getRa() == ra) {
															
															ok = true;
															
														}
														
														if(ok) {
															
															aux2.addConvidado(auxUser);
															System.out.println("Usuário convidado com sucesso!");
														
														} else {
															
															System.out.println("Usuário não encontrado no sistema!");
															
														}
														
														
													} else {
														
														break;
														
													}
													
												}
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Bar, aux2, priva, fecha);
												
												varzeas.add(aux1);
												
											} else {
												
												aux1 = logado.getHost().criarVarzea(titulo, TiposVarzea.Bar, logado.getHost().criarGrupo(), false, fecha);
												
												varzeas.add(aux1);
												
											}
											
											while(true) {

												System.out.println("Escolha uma das opções abaixo: \n");
												
												System.out.println("1 - Listar informações da Várzea");
												System.out.println("2 - Remover Membro");
												System.out.println("3 - Retirar Várzea da Lista e parar de ser Host");
												System.out.println("4 - Voltar");
												
												opcao = scan.nextInt();
												lixo = scan.nextLine();
												
												if(opcao == 1) {
													
													System.out.println(aux1);
													
												} else if(opcao == 2) {
													
													System.out.print("Digite o RA do Membro a ser retirado da Várzea");
													ra = scan.nextInt();
													lixo = scan.nextLine();
													ok = false;
													
													for(i = 0; i < aux1.getGrupo().getMembros().size(); i++) {
														
														if(aux1.getGrupo().getMembros().get(i).getUsuario().getRa() == ra) {
															
															ok = true;
															break;
															
														}
														
													}
													
													if(ok) {
														
														aux1.getGrupo().getMembros().remove(i);
															
														System.out.println("Membro removido com sucesso");
														
													} else {
														
														System.out.println("Membro não encontrado");
														
													}
													
												}else if(opcao == 3) {
													
													if(varzeas.remove(aux1)) {
														
														System.out.println("Várzea removida do sistema!");
														
													} else {
														
														System.out.println("Erro ao remover sua Várzea do sistema!");
														
													}

													logado.setHost(null);
													
													break;
													
												} else if(opcao == 4) {
												
													break;
													
												}
												
											}
											
										} else {
											
											break;
											
										}
									
								} else if(opcao == 2) {
									
									ok = false;
									
									for(i = 0; i < varzeas.size(); i++) {
										
										if(varzeas.get(i).getGrupo().getHost().getUsuario() == logado) {
											
											ok = true;
											logado.setHost(varzeas.get(i).getGrupo().getHost());
											break;
											
										}
										
									}
									
									if(ok) {
										
										aux1 = varzeas.get(i);
										
										while(true) {
											

											System.out.println("Escolha uma das opções abaixo: \n");
											
											System.out.println("1 - Listar informações da Várzea");
											System.out.println("2 - Remover Membro");
											System.out.println("3 - Retirar Várzea da Lista e parar de ser Host");
											System.out.println("4 - Voltar");
											
											opcao = scan.nextInt();
											lixo = scan.nextLine();
											
											if(opcao == 1) {
												
												System.out.println(aux1);
												
											} else if(opcao == 2) {
												
												System.out.print("Digite o RA do Membro a ser retirado da Várzea");
												ra = scan.nextInt();
												lixo = scan.nextLine();
												ok = false;
												
												for(i = 0; i < aux1.getGrupo().getMembros().size(); i++) {
													
													if(aux1.getGrupo().getMembros().get(i).getUsuario().getRa() == ra) {
														
														ok = true;
														break;
														
													}
													
												}
												
												if(ok) {
													
													aux1.getGrupo().getMembros().remove(i);
														
													System.out.println("Membro removido com sucesso");
													
												} else {
													
													System.out.println("Membro não encontrado");
													
												}
												
											}else if(opcao == 3) {
												
												if(varzeas.remove(aux1)) {
													
													System.out.println("Várzea removida do sistema!");
													
												} else {
													
													System.out.println("Erro ao remover sua Várzea do sistema!");
													
												}

												logado.setHost(null);
												
												break;
												
											} else if(opcao == 4) {
											
												break;
												
											}
											
										}
										
									} else {
										
										System.out.println("Não foi encontrada uma várzea sua");
										
									}
									
								} else if(opcao == 3) {
									
									break;
									
								}
								
							}
						
						//Aqui Termina Funcionalidades do Host
						
						} else if(opcao == 2) { //Aqui começa Funcionalidades do Guest.
							
							while(true) {
								
								System.out.println("Escolha uma das opções abaixo: \n");
								
								System.out.println("1 - Listar Várzeas");
								System.out.println("2 - Listar Várzeas de Jogos");
								System.out.println("3 - Listar Várzeas de RPG");
								System.out.println("4 - Listar Várzeas de Cinema");
								System.out.println("5 - Listar Várzeas de Debate");
								System.out.println("6 - Listar Várzeas de Bar");
								System.out.println("7 - Entrar em Várzea");
								System.out.println("8 - Ver Várzea em que está presente");
								System.out.println("9 - Voltar");
								
								opcao = scan.nextInt();
								lixo = scan.nextLine();
								
								if(opcao == 1) {
									
									System.out.println("\nVárzeas disponíveis:\n");
									
									for(Varzea v : varzeas) {
									
										if(v.isPrivado()) {
											
											if(((GrupoPrivado) v.getGrupo()).getConvidados().contains(logado)) {
												
												System.out.println(v + "\n");
												
											} else {
												
												continue;
												
											}
											
										} else {
										
											System.out.println(v + "\n");
										
										}
										
									}
										
									
								} else if(opcao == 2){
									
									System.out.println("\nVárzeas de Jogos disponíveis:\n");
									
									for(Varzea v : varzeas) {
									
										if(v.getTipo() == TiposVarzea.Jogos) {
											
											if(v.isPrivado()) {
												
												if(((GrupoPrivado) v.getGrupo()).getConvidados().contains(logado)) {
													
													System.out.println(v + "\n");
													
												} else {
													
													continue;
													
												}
												
											} else {
											
												System.out.println(v + "\n");
											
											}
											
										}
											
									}
									
								} else if(opcao == 3) {
									
									System.out.println("\nVárzeas de RPG disponíveis:\n");
									
									for(Varzea v : varzeas) {
									
										if(v.getTipo() == TiposVarzea.RPG) {
											
											if(v.isPrivado()) {
												
												if(((GrupoPrivado) v.getGrupo()).getConvidados().contains(logado)) {
													
													System.out.println(v + "\n");
													
												} else {
													
													continue;
													
												}
												
											} else {
											
												System.out.println(v + "\n");
											
											}
											
										}
											
									}
									
									
								} else if(opcao == 4) {
									
									System.out.println("\nVárzeas de Cinema disponíveis:\n");
									
									for(Varzea v : varzeas) {
									
										if(v.getTipo() == TiposVarzea.Cinema) {
											
											if(v.isPrivado()) {
												
												if(((GrupoPrivado) v.getGrupo()).getConvidados().contains(logado)) {
													
													System.out.println(v + "\n");
													
												} else {
													
													continue;
													
												}
												
											} else {
											
												System.out.println(v + "\n");
											
											}
											
										}
											
									}
									
									
								} else if(opcao == 5) {
									
									System.out.println("\nVárzeas de Debate disponíveis:\n");
									
									for(Varzea v : varzeas) {
									
										if(v.getTipo() == TiposVarzea.Debate) {
											
											if(v.isPrivado()) {
												
												if(((GrupoPrivado) v.getGrupo()).getConvidados().contains(logado)) {
													
													System.out.println(v + "\n");
													
												} else {
													
													continue;
													
												}
												
											} else {
											
												System.out.println(v + "\n");
											
											}
											
										}
											
									}
									
									
								} else if(opcao == 6) {
									
									System.out.println("\nVárzeas de Bar disponíveis:\n");
									
									for(Varzea v : varzeas) {
									
										if(v.getTipo() == TiposVarzea.Bar) {
											
											if(v.isPrivado()) {
												
												if(((GrupoPrivado) v.getGrupo()).getConvidados().contains(logado)) {
													
													System.out.println(v + "\n");
													
												} else {
													
													continue;
													
												}
												
											} else {
											
												System.out.println(v + "\n");
											
											}
											
										}
											
									}
									
									
								} else if(opcao == 7) {
									
									ok = false;
									
									for(Varzea v : varzeas) {
										
										if(v.getGrupo().checarMembro(logado.getGuest()) || v.getGrupo().getHost().getUsuario() == logado) {
											
											ok = true;
											break;
											
										}
										
									}
									
									if(ok) {
										
										System.out.println("\nVocê já está em uma Várzea, saia da sua primeiro se quiser entrar em outra!\n");
										continue;
										
									}
									
									System.out.print("\nDigite o ID (Número entre () ) da Várzea desejada:");
									id = scan.nextInt();
									lixo = scan.nextLine();
									ok = false;
									
									for(i = 0; i < varzeas.size(); i++) {
										
										if(varzeas.get(i).getGrupo().getId() == id) {
											
											ok = true;
											logado.setGuest(new Guest(logado));
											varzeas.get(i).getGrupo().addMembro(logado.getGuest());
											break;
											
										}
										
									}
									
									if(ok) {
										
										aux1 = varzeas.get(i);
										
										while(true) {
											
											System.out.println("Escolha uma das opções abaixo: \n");
											
											System.out.println("1 - Listar informações da Várzea");
											System.out.println("2 - Sair da Várzea");
											System.out.println("3 - Voltar");
											
											opcao = scan.nextInt();
											lixo = scan.nextLine();
											
											if(opcao == 1) {
												
												System.out.println(aux1);
												
											} else if(opcao == 2) {
												
												if(aux1.getGrupo().removeMembro(logado.getGuest())) {
												
													logado.setGuest(null);
													
													System.out.println("\nRemovido da Várzea atual com sucesso!\n");
													
													break;
												
												} else {
													
													System.out.println("\nErro ao te remover dessa Várzea!");
													
												}
												
											} else if(opcao == 3) {
												
												break;
												
											}
											
										}
										
									} else {
										
										System.out.println("Várzea não encontrada");
										
									}
									
								} else if(opcao == 8) {
									
									ok = false;
									
									for(i = 0; i < varzeas.size(); i++) {
										
										if(varzeas.get(i).getGrupo().checarMembro(logado.getGuest())) {
											
											ok = true;
											break;
											
										}
										
									}
									
									if(ok) {
										
										aux1 = varzeas.get(i);
										
										while(true) {
											
											System.out.println("Escolha uma das opções abaixo: \n");
											
											System.out.println("1 - Listar informações da Várzea");
											System.out.println("2 - Sair da Várzea");
											System.out.println("3 - Voltar");
											
											opcao = scan.nextInt();
											lixo = scan.nextLine();
											
											if(opcao == 1) {
												
												System.out.println(aux1);
												
											} else if(opcao == 2) {
												
												if(aux1.getGrupo().removeMembro(logado.getGuest())) {
													
													logado.setGuest(null);
													
													System.out.println("\nRemovido da Várzea atual com sucesso!\n");
													
													break;
												
												} else {
													
													System.out.println("\nErro ao te remover dessa Várzea!");
													
												}
												
												
											} else if(opcao == 3) {
												
												break;
												
											}
											
										}
										
									} else {
										
										System.out.println("Você não é Guest em nenhuma Várzea!\n");
										
									}
									
								} else if(opcao == 9) {
									
									break;
									
								}
								
							}
							
						} else if(opcao == 3) {
							
							while(true) {
								
								System.out.println("Escolha uma das opções abaixo: \n");
								
								System.out.println("1 - Modificar Lista de Amigos");
								System.out.println("2 - Modificar se tem Baralho disponível");
								System.out.println("3 - Modificar coleção de jogos");
								System.out.println("4 - Modificar Status");
								System.out.println("5 - Modificar Jogos Favoritos");
								System.out.println("6 - Ativar/Desativar Notificações");
								System.out.println("7 - Voltar");
								
								opcao = scan.nextInt();
								lixo = scan.nextLine();
								
								if(opcao == 1) {
									
									System.out.println("1 - Adicionar?");
									System.out.println("2 - Remover?");
									System.out.println("3 - Checar?");
									
									opcao = scan.nextInt();
									lixo = scan.nextLine();
									
									if(opcao == 1) {
									
										System.out.print("Digite RA do Amigo a ser adicionado:");
										ra = scan.nextInt();
										
										auxUser.carregarDoArquivo("Users.dat", ra);
										
										if(auxUser.getRa() == ra) {
											
											logado.getPerfil().addAmigo(auxUser);
											ok = true;
											
										}
										
										if(ok) {
											
											System.out.println("\nAmigo adicionado com sucesso!\n");
											
										} else {
										
											System.out.println("\nUsuário não encontrado no sistema!\n");
										
										}
										
									} else if(opcao == 2) {
										
										System.out.print("Digite RA do Amigo a ser removido:");
										ra = scan.nextInt();
										ok = false;
										
										auxUser.carregarDoArquivo("Users.dat", ra);
										
										if(auxUser.getRa() == ra) {
											
											ok = true;
											
										}
										
										
										if(ok) {
											
											user = auxUser;
											if(logado.getPerfil().removerAmigo(user)) {
												
												System.out.println("\nAmigo removido com sucesso!\n");
												
											} else {
											
												System.out.println("\nUsuário não encontrado na lista!\n");
											
											}
											
										} else {
											
											System.out.println("\nUsuário não encontrado no sistema!\n");
											
										}
										
										
									} else if(opcao == 3) {
										
										System.out.print("Digite RA do Amigo pra ver se ele está na sua lista:");
										ra = scan.nextInt();
										ok = false;
										
										auxUser.carregarDoArquivo("Users.dat", ra);
										
										if(auxUser.getRa() == ra) {
											
											ok = true;
											
										}
									
										if(ok) {
											
											user = auxUser;
											if(logado.getPerfil().checarAmigo(user)) {
												
												System.out.println("\nUsuário presente na lista!\n");
												
											} else {
											
												System.out.println("\nUsuário não encontrado na lista!\n");
											
											}
											
										} else {
											
											System.out.println("\nUsuário não encontrado no sistema!\n");
											
										}
										
									}
										
								} else if(opcao == 2) {
									
									System.out.print("Você tem baralho disponível? (true ou false)");
									baralho = scan.nextBoolean();
									
									logado.getPerfil().setBaralho(baralho);
									
									if(baralho) {
										
										System.out.println("\nJogos de baralho adicionados aos seus Jogos!\n");
										
									}
									
								} else if(opcao == 3) {
									
									System.out.println("Jogos Disponíveis:");
									
									for(Jogo j : Jogo.values()) {
										
										if(j.getCategorias().contains(Categoria.Baralho) == false) {
										
										System.out.println(j.getNome());
										
										}
										
									}
									
									System.out.println("1 - Adicionar?");
									System.out.println("2 - Remover?");
									System.out.println("3 - Checar?");
									
									opcao = scan.nextInt();
									lixo = scan.nextLine();
									
									if(opcao == 1) {
									
										System.out.print("Digite nome do jogo a ser adicionado:");
										jogoNome = scan.nextLine();
										ok = false;
										
										for(Jogo j : Jogo.values()) {
											
											if(jogoNome.equals(j.getNome())) {
												
												logado.getPerfil().addMyJogo(j);
												ok = true;
												break;
												
											}
											
										}
										
										if(ok) {
											
											System.out.println("\nJogo " + jogoNome + " adicionado à coleção com sucesso!\n");
											
										} else {
											
											System.out.println("\nJogo não encontrado no sistema!\n");
											
										}
										
									} else if(opcao == 2) {
										
										System.out.print("Digite nome do jogo a ser removido:");
										jogoNome = scan.nextLine();
										ok = false;
											
										for(i = 0; i < Jogo.values().length; i++) {
											
											if(jogoNome.equals(Jogo.values()[i].getNome())) {
												
												ok = true;
												break;
												
											}
											
										}
										
										if(ok) {
											
											jogo = Jogo.values()[i];
											if(logado.getPerfil().removerMyJogo(jogo)) {
												
												System.out.println("\nJogo " + jogoNome + " removido da coleção com sucesso!\n");
												
											} else {
												
												System.out.println("\nJogo " + jogoNome + " não presente na coleção!\n");
												
											}
											
										} else {
											
											System.out.println("Jogo não encontrado no sistema!");
											
										}
										
									} else if(opcao == 3) {
										
										System.out.print("\nDigite nome do jogo pra ver se ele está na sua lista:");
										jogoNome = scan.nextLine();
										ok = false;
										
										for(i = 0; i < Jogo.values().length; i++) {
											
											if(jogoNome.equals(Jogo.values()[i].getNome())) {
												
												ok = true;
												break;
												
											}
											
										}
											
										if(ok) {
											
											jogo = Jogo.values()[i];
											
											System.out.printf("\nJogo %s %sestá presente na coleção!\n\n", jogoNome, logado.getPerfil().checarMyJogo(jogo) ?  "" : "não ");
											
										} else {
											
											System.out.println("Jogo não encontrado no sistema!\n");
											
										}
										
									}
									
								} else if(opcao == 4) {
									
									System.out.println("\nStatus atual: " + logado.getPerfil().getStatus() + "\n");
									
									System.out.print("Digite novo Status:");
									status = scan.nextLine();
									
									logado.getPerfil().setStatus(status);							
									
									System.out.println("\nNovo Status: " + status + "\n");
									
								} else if(opcao == 5) {
									
									System.out.println("\nJogos Disponíveis:");
									
									for(Jogo j : Jogo.values()) {
										
										System.out.println(j.getNome());
										
									}
									
									System.out.println("1 - Adicionar?");
									System.out.println("2 - Remover?");
									System.out.println("3 - Checar?");
									
									opcao = scan.nextInt();
									lixo = scan.nextLine();
									
									if(opcao == 1) {
									
										System.out.print("Digite nome do jogo a ser adicionado:");
										jogoNome = scan.nextLine();
										
										for(Jogo j : Jogo.values()) {
											
											if(jogoNome.equals(j.getNome())) {
												
												logado.getPerfil().addJogoFav(j);
												ok = true;
												break;
												
											}
											
										}
										
										if(ok) {
											
											System.out.println("\nJogo " + jogoNome + " adicionado aos favoritos com sucesso!\n");
											
										} else {
											
											System.out.println("\nJogo não encontrado no sistema!\n");
											
										}
										
									} else if(opcao == 2) {
										
										System.out.print("Digite nome do jogo a ser removido:");
										jogoNome = scan.nextLine();
											
										for(i = 0; i < Jogo.values().length; i++) {
											
											if(jogoNome.equals(Jogo.values()[i].getNome())) {
												
												ok = true;
												break;
												
											}
											
										}
										
										if(ok) {
											
											jogo = Jogo.values()[i];
											if(logado.getPerfil().removerJogoFav(jogo)) {
												
												System.out.println("\nJogo " + jogoNome + " removido dos favoritos com sucesso!\n");
												
											} else {
												
												System.out.println("\nJogo " + jogoNome + " não presente nos favoritos!\n");
												
											}
											
										} else {
											
											System.out.println("Jogo não encontrado no sistema!");
											
										}
										
									} else if(opcao == 3) {
										
										System.out.print("Digite nome do jogo pra ver se ele está na sua lista:");
										jogoNome = scan.nextLine();
										
										for(i = 0; i < Jogo.values().length; i++) {
											
											if(jogoNome.equals(Jogo.values()[i].getNome())) {
												
												ok = true;
												break;
												
											}
											
										}
											
										if(ok) {
											
											jogo = Jogo.values()[i];
											
											System.out.printf("\nJogo %s %sestá presente nos favoritos!\n\n", jogoNome, logado.getPerfil().checarJogoFav(jogo) ?  "" : "não ");
											
										} else {
											
											System.out.println("Jogo não encontrado no sistema!");
											
										}
										
									}
									
								} else if(opcao == 6) {
									
									System.out.print("Você quer notificações? (true ou false)");
									notificacao = scan.nextBoolean();
									
									logado.getPerfil().setNotificacao(notificacao);
									
									System.out.printf("\nNotificações %sativadas no seu Perfil\n\n", notificacao ? "" : "des");
									
								} else if(opcao == 7) {
									
									break;
									
								}
								
							}
							
						} else if(opcao == 4) {
							
							logado.setGuest(null);
							logado.setHost(null);
							
							break;
							
						}
						
					}
					
				} else if(ok == false) {
					
					System.out.println("\nConjunto de Usuário e Senha não encontrado no sistema!\n");
					
				}
				
			} else if(opcao == 3) {
				
				return;
				
			}	
			
		}	
		
	}	
	
}