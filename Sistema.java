import java.util.Scanner;

public class Sistema {

	public Sistema() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner iscanner = new Scanner(System.in);
		Scanner sscanner = new Scanner(System.in);
		System.out.println("Inicio\n\nCadastrar Usuarios\nInforme o numero de usuarios a serem cadastrados:\t");
		int index = iscanner.nextInt();
		int userqnt = index;
		String[] nome = new String[index];
		String[] graduacao = new String[index];
		String[] email = new String[index];
		for(int i = 0; i < index; i++) {
			int d=i+1;
			System.out.println("Informe o nome do usuário de numero "+ d +":\t");
			nome[i] = sscanner.nextLine();
			System.out.println("Informe as credenciais do usuário de numero "+ d +":\t");
			graduacao[i] = sscanner.nextLine();
			System.out.println("Informe o endereco de email do usuário de numero "+ d +":\t");
			email[i] = sscanner.nextLine();
		}
		
		System.out.println("\nCadastrar Recursos\nInforme o numero de recursos disponiveis:\t");
		index = iscanner.nextInt();
		int recqnt = index;
		String[] recurso = new String[index];
		String[] estado = new String[index];
		for(int i = 0; i < index; i++) {
			int d=i+1;
			System.out.println("Informe como se chamara o recurso de numero "+ d +":\t");
			recurso[i] = sscanner.nextLine();
			estado[i] = "Em processo de alocacao";
		}
		String[] data = new String[10];
		String[] inicio = new String[10];
		String[] termino = new String[10];
		String[] alocacao = new String[10];
		String[] responsavel = new String[10];
		String[] descricao = new String[10];
		int[] userindex = new int[10];
		int aloc = 0;
		do {
		System.out.println("\n\nNavegacao\n[1] - Realizar Alocacao\n[2] - Realizar Consulta\n[3] - Exibir Relatorios\n");
		index = iscanner.nextInt();
		switch(index) {
		case 1:
			System.out.println("Informe a data da atividade:\t");
			String curr_data = sscanner.nextLine();
			System.out.println("Informe a hora de inicio da atividade:\t");
			String curr_inicio = sscanner.nextLine();
			System.out.println("Informe a hora de termino da atividade:\t");
			String curr_termino = sscanner.nextLine();
			System.out.println("Informe o nome do recurso necessario para a execucao da atividade:\t");
			String curr_alocacao = sscanner.nextLine();
			System.out.println("Informe o nome do responsavel pela atividade:\t");
			String curr_responsavel = sscanner.nextLine();
			System.out.println("Informe a descricao da atividade:\t");
			String curr_descricao = sscanner.nextLine();
			
			int i = 0;
			int teste_user = 0;
			do {
				if(curr_responsavel.equals(nome[i])) {
					if(curr_descricao.equals("Aula Tradicional") || curr_descricao.equals("Laboratorio")) {
						if(graduacao[i].equals("Professor")) {
							teste_user = 1;
							i = userqnt;
						}
						else {
							i = userqnt;
						}
					}
					else {
						teste_user = 1;
						i = userqnt;
					}
				}
				else {
					i++;
				}
			}while(i < userqnt);
			
			if(teste_user == 1) {
				data[aloc] = curr_data;
				inicio[aloc] = curr_inicio;
				termino[aloc] = curr_termino;
				alocacao[aloc] = curr_alocacao;
				responsavel[aloc] = curr_responsavel;
				descricao[aloc] = curr_descricao;
				aloc++;
			}
			else {
				System.out.println("Cadastro nao permitido.\n");
			}
			break;
		case 2:
			System.out.println("Selecione o modo de consulta:\n[1] - Consulta por Usuario\n[2] - Consulta por Recurso");
			int innerindex = iscanner.nextInt();
			switch(innerindex) {
			case 1:
				System.out.println("Informe o nome do usuario:\t");
				String curr_nome = sscanner.nextLine();
				int q = 0;
				int teste_userhist = 0;
				do {
					if(curr_nome.equals(nome[q])){
						teste_userhist = 1;
						System.out.println("Nome:\t"+nome[q]+"\nEmail:\t"+email[q]+"\n\nHistorico de Atividades\n\n");
						for(int r = 0; r <= aloc; r++) {
							if(nome[q].equals(responsavel[r])) {
								System.out.println("Recurso:\t"+alocacao[r]+"\nAtividade:\t"+descricao[r]+"\n");
							}
						}
						System.out.println("Fim do Historico do Usuario\n");
						q = aloc+1;
					}
				}while(q <= aloc);
				if(teste_userhist == 0) {
					System.out.println("Usuario nao encontrado");
				}
				
				break;
			case 2:
				System.out.println("Informe o nome do Recurso:\t");
				String curr_recurso = sscanner.nextLine();
				int p = 0;
				do{
					if(curr_recurso.equals(alocacao[p])) {
						System.out.println("Usuario:\t"+responsavel[p]+"\nAtividade:\t"+descricao[p]+"\n");
					}
				}while(p <= aloc);
				break;
			}
			break;
		case 3:
			System.out.println("Numero de Usuarios: "+userqnt+"\n");
			System.out.println("Numero de Alocacoes: "+aloc+"\n");
			break;
		}
		}while(index == 1 || index == 2 || index == 3);
	}

}
