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
		int[] data = new int[10];
		int[] inicio = new int[10];
		int[] termino = new int[10];
		String[] alocacao = new String[10];
		String[] responsavel = new String[10];
		String[] descricao = new String[10];
		int[] userindex = new int[10];
		int aloc = 0;
		do {
		System.out.println("\n\nNavegacao\n[1] - Realizar Alocacao\n[2] - Realizar Consulta\n[3] - Exibir Relatorios\n[4] - Confirmar Alocacao\n[5] - Concluir Alocacao\n");
		index = iscanner.nextInt();
		switch(index) {
		case 1:
			System.out.println("Informe a data da atividade:\t");
			int curr_data = iscanner.nextInt();
			System.out.println("Informe a hora de inicio da atividade:\t");
			int curr_inicio = iscanner.nextInt();
			System.out.println("Informe a hora de termino da atividade:\t");
			int curr_termino = iscanner.nextInt();
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
				int teste_time = 1;
				for(i = 0; i <= aloc; i++) {
					if(curr_alocacao.equals(alocacao[i])) {
						if(curr_data == data[i]) {
							if(inicio[i] < curr_inicio && termino[i] > curr_inicio) {
								teste_time = 0;
							}
							else if(inicio[i] < curr_termino && termino[i] > curr_termino) {
								teste_time = 0;
							}
						}
					}
				}
				if(teste_time == 1) {
					for(i = 0; i < recqnt; i++) {
						if(curr_alocacao.equals(recurso[i])) {
							estado[i] = "Alocado";
						}
					}
					data[aloc] = curr_data;
					inicio[aloc] = curr_inicio;
					termino[aloc] = curr_termino;
					alocacao[aloc] = curr_alocacao;
					responsavel[aloc] = curr_responsavel;
					descricao[aloc] = curr_descricao;
					aloc++;
				}
				else {
					System.out.println("Choque de Horario.\n");
				}
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
					q++;
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
					p++;
				}while(p <= aloc);
				break;
			}
			break;
		case 3:
			System.out.println("Numero de Usuarios: "+userqnt+"\n");
			int proc_cont = 0;
			int alo_cont = 0;
			int and_cont = 0;
			int conc_cont = 0;
			for(int rec_cont = 0; rec_cont < recqnt; rec_cont++) {
				if(estado[rec_cont].equals("Em processo de alocacao")) {
					proc_cont++;
				}
				else if(estado[rec_cont].equals("Alocado")) {
					alo_cont++;
				}
				else if(estado[rec_cont].equals("Em andamento")) {
					and_cont++;
				}
				else if(estado[rec_cont].equals("Concluido")) {
					conc_cont++;
				}
			}
			System.out.println("Numero de Recursos em Processo de Alocacao: "+proc_cont+"\n");
			System.out.println("Numero de Recursos em Estado Alocado: "+alo_cont+"\n");
			System.out.println("Numero de Recursos em Andamento: "+and_cont+"\n");
			System.out.println("Numero de Recursos Concluidos: "+conc_cont+"\n");
			
			System.out.println("Numero de Alocacoes: "+aloc+"\n");
			int aula_cont=0;
			int lab_cont=0;
			int diversos_cont=0;
			for(int aloc_cont = 0; aloc_cont < aloc; aloc_cont++) {
				if(descricao[aloc_cont].equals("Aula Tradicional")) {
					aula_cont++;
				}
				else if(descricao[aloc_cont].equals("Laboratorio")) {
					lab_cont++;
				}
				else {
					diversos_cont++;
				}
			}
			System.out.println("Numero de Aulas Tradicionais: "+aula_cont+"\n");
			System.out.println("Numero de Laboratorios: "+lab_cont+"\n");
			System.out.println("Numero das demais Atividades: "+diversos_cont+"\n");
			
			break;
		case 4:
			System.out.println("Informe o indice da Atividade:\t");
			int indice = iscanner.nextInt();
			estado[indice] = "Em andamento";
			break;
		case 5:
			System.out.println("Informe o indice da Atividade:\t");
			indice = iscanner.nextInt();
			estado[indice] = "Concluido";
			break;
		}
		
		}while(index == 1 || index == 2 || index == 3);
	}

}
