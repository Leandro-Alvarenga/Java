package pjrCadastroCliente;

import javax.swing.JOptionPane;

public class CadastraCliente {
	
	static final int QTEREGISTROS = 10;
	static int fundo=0, quantos=0;
	
	public static String codigo[] = new String[QTEREGISTROS];
	public static String nome[] = new String[QTEREGISTROS];
	public static String email[] = new String[QTEREGISTROS];
	public static String cidade[] = new String[QTEREGISTROS];
	public static String uf[] = new String[QTEREGISTROS];
	

	public static void main(String[] args) {
		
		for (int i=0; i<QTEREGISTROS;i++) {
			codigo[i]=String.valueOf(i);
		}
		
		String opcao = "";
		
		while (!opcao.equals("6")) {
			opcao = entradaDeDadosTexto("Menu de opções\n\n"+
										"1 - Cadastrar \n" +
										"2- Consultar \n" +
										"3- Atualizar Email \n" +
										"4- Excluir \n" +
										"5- Listar Clientes \n" +
										"6 - Sair \n\n"
										);
		
			
				switch (opcao) {
				case "1": cadastrarCliente();
				break;
				case "2": consultarCliente();
				break;
				case "3": atualizarEmailCliente();
				break;
				case "4": excluirCliente();
				break;
				case "5": listarClientes();
				break;
				case "6":
				break;
				
				default:
					mensagemSaida("Opção Inválida");
					
				}
		}

	}
	

	private static void cadastrarCliente() {
		if (!cheio()) {
			nome[fundo] = entradaDeDadosTexto("\nDigite o nome do cliente: ");
			
			if (nome[fundo]!=null && !(nome[fundo].isEmpty())) {
				
			email[fundo] = entradaDeDadosTexto("\nDigite o email: ");
			cidade[fundo] = entradaDeDadosTexto("\nDigite a cidade: ");
			uf[fundo] = entradaDeDadosTexto("\nDigite a UF: ");
			
			mensagemSaida("\nCliente Cadastrado. Código " + codigo[fundo]);
			
			fundo++;
			quantos++;
			
			} else {
				mensagemSaida("Digite um nome para o cliente.");
			}
			
			
		} else {
			mensagemSaida("\nNão há espaço para cadastro.");
		}
		
	}
	


	private static void consultarCliente() {
		int alternativa = 0;
	
		if(!vazio()) {
			
		alternativa = Integer.parseInt(
				entradaDeDadosTexto("Digite a o código do cliente que quer buscar: ")
				);

		try {
			
				if (nome[alternativa]!=null && !(nome[alternativa].isEmpty())) {
					
				
					mensagemSaida("Encontramos o cliente:\n" +
									"\nNome: " + nome[alternativa] +
									"\nEmail: " + email[alternativa] +
									"\nCidade: " + cidade[alternativa] +
									"\nUF: " + uf[alternativa]
								);
				} 
				
				else {
					mensagemSaida("Código não cadastrado");
				}
				
			
			
			
		} catch (Exception ex) {
			mensagemSaida("Código não encontrado");
			
		}
		
			} 
		
			else {
			mensagemSaida("Cadastro vazio.");
			}
				

	}

	
	public static void atualizarEmailCliente() {
		int alternativa = 0;
		String novoEmail;
		
		if(!vazio()) {
			
		alternativa = Integer.parseInt(
				entradaDeDadosTexto("Digite a o código do cliente que deseja atualizar o email: ")
				);

		try {
			
				if (nome[alternativa]!=null && !(nome[alternativa].isEmpty())) {
					
				
					mensagemSaida("Encontramos o cliente " + nome[alternativa] +
									" com o email " + email[alternativa]
								);
					novoEmail = entradaDeDadosTexto("Digite o novo email deste cliente: ");
					
					if (novoEmail!=null) {
						
						email[alternativa] = novoEmail;
						mensagemSaida("Email atualizado!");
						
					} else {
						
						mensagemSaida("Digite um novo email válido");
						
					}
					
					
					
				} 
				
				else {
					mensagemSaida("Código não cadastrado");
				}
				
			
			
			
		} catch (Exception ex) {
			mensagemSaida("Código não encontrado");
			
		}
		
			} 
		
			else {
			mensagemSaida("Cadastro vazio.");
			}
		
		
		
	}
	
	
	public static void excluirCliente() {
		int alternativa = 0;
		
		if(!vazio()) {
			
		alternativa = Integer.parseInt(
				entradaDeDadosTexto("Digite a o código do cliente que deseja excluir: ")
				);

		try {
			
				if (nome[alternativa]!=null && !(nome[alternativa].isEmpty())) {
					
				
					mensagemSaida("Excluímos o cliente:\n" +
									"\nNome: " + nome[alternativa] +
									"\nEmail: " + email[alternativa] +
									"\nCidade: " + cidade[alternativa] +
									"\nUF: " + uf[alternativa]
								);
					
					nome[alternativa] = null;
					email[alternativa] = null;
					cidade[alternativa] = null;
					uf[alternativa] = null;
					
					quantos--;
				} 
				
				else {
					mensagemSaida("Código não cadastrado");
				}
				
			
			
			
		} catch (Exception ex) {
			mensagemSaida("Código não encontrado");
			
		}
		
			} 
		
			else {
			mensagemSaida("Cadastro vazio.");
			}
		
		
	}
	
	
	public static void listarClientes() {
		
		if (!vazio()) {
			for (int i=0;i<fundo;i++) {
				
				mensagemSaida("\nCódigo: " + codigo[i] + " - Nome: " + nome[i] + "\n");
		
			}
			
		
		} else {
			
			mensagemSaida("Cadastro vazio.");
			
		}
	
	}
	
	
	
	
	
	public static boolean cheio() {

		return (quantos==QTEREGISTROS);
	}
	
	public static boolean vazio() {

		return (quantos==0);
	}
	
	
	public static void mensagemSaida (String texto) {
		JOptionPane.showMessageDialog(null, texto);
		
	}
	
	public static String entradaDeDadosTexto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}

}
