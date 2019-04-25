package pjrCadastroCliente;

import javax.swing.JOptionPane;

public class CadastraCliente {
	
	static final int QTEREGISTROS = 2;
	static int inicio=0, fundo=0, quantos=0;
	
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
										"6 - Sair \n\n"
										);
		
			
				switch (opcao) {
				case "1": cadastrarCliente();
				break;
				case "2": consultarCliente();
				break;
				/*case "3": atualizarCliente();
				break;
				case "4": excluirCliente();
				break;
				case "5": listarClientes();
				break;
				*/
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
			email[fundo] = entradaDeDadosTexto("\nDigite o email: ");
			cidade[fundo] = entradaDeDadosTexto("\nDigite a cidade: ");
			uf[fundo] = entradaDeDadosTexto("\nDigite a UF: ");
			
			mensagemSaida("\nCliente Cadastrado. Código " + codigo[fundo]);
			
			fundo++;
			quantos++;
			
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
			
				if (nome[alternativa]!=null) {
					
				
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
