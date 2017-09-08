import java.util.ArrayList;
import java.util.Scanner;
import activities.*;
import chainoResp.ResourceChain;
import resources.*;
import users.*;

public class Sistema {

	public Sistema() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Lista de Usuários
		ArrayList<AbstractUser> users = new ArrayList<AbstractUser>();
		
		users.add(new Admin("Ademir", "ademir@ic.ufal.br", 0));
		users.add(new Professor("Badu", "baldoino@ic.ufal.br", 1));
		users.add(new Researcher("Pedro Barros", "pedrobarros@ic.ufal.br", 2));
		users.add(new Student("Vangasse", "vangasse@ic.ufal.br", 3));
		
		//Cadeia de Auditórios
		Auditorium auditoriums = new Auditorium(1);
		
		Auditorium auditorium_aux = new Auditorium(2);
		auditoriums.setNext(auditorium_aux);
		
		//Cadeia de Salas de Aula
		ClassRoom class_rooms = new ClassRoom(1);
		
		ClassRoom class_room_aux = new ClassRoom(2);
		class_rooms.setNext(class_room_aux);
		
		class_room_aux = new ClassRoom(3);
		class_rooms.setNext(class_room_aux);
		class_room_aux = new ClassRoom(4);
		class_rooms.setNext(class_room_aux);
		
		//Cadeia de Laboratórios
		Laboratory laboratories = new Laboratory(1);
		
		Laboratory laboratory_aux = new Laboratory(2);
		laboratories.setNext(laboratory_aux);
		
		laboratory_aux = new Laboratory(3);
		laboratories.setNext(laboratory_aux);
		laboratory_aux = new Laboratory(4);
		laboratories.setNext(laboratory_aux);
		
		//Cadeia de Projector
		Projector projectors = new Projector(1);
		
		Projector projector_aux = new Projector(2);
		projectors.setNext(projector_aux);
		
		projector_aux = new Projector(3);
		projectors.setNext(projector_aux);
		projector_aux = new Projector(4);
		projectors.setNext(projector_aux);
		projector_aux = new Projector(5);
		projectors.setNext(projector_aux);
		projector_aux = new Projector(6);
		projectors.setNext(projector_aux);
		projector_aux = new Projector(7);
		projectors.setNext(projector_aux);
		projector_aux = new Projector(8);
		projectors.setNext(projector_aux);
		
		//Listas de Atividades finalizadas ou não
		ArrayList<AbstractActivity> finished_activities = new ArrayList<AbstractActivity>();
		ArrayList<AbstractActivity> activities = new ArrayList<AbstractActivity>();
		
		AbstractActivity activity = new Presentation(projectors, users.get(2), "Demontração", "Demonstração de funcionalidades",
				"Pedro e seus amigos", "Nenhum", 77, 77, 1200, 1250);
		
		try {
			activities = projectors.schedule(activities, activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner iscanner = new Scanner(System.in);
		Scanner sscanner = new Scanner(System.in);
		System.out.println("Inicio\n\nCadastrar Usuarios\nInforme o numero de usuarios a serem cadastrados:\t");
		int index = iscanner.nextInt();
		int userqnt = index;
		String nome = new String();
		String graduacao = new String();
		String email = new String();
		
		for(int i = 0; i < index; i++) {
			int d=i+1;
			System.out.println("Informe o nome do usuário de numero "+ d +":\t");
			nome = sscanner.nextLine();
			System.out.println("Informe as credenciais do usuário de numero "+ d +":\t");
			graduacao = sscanner.nextLine();
			System.out.println("Informe o endereco de email do usuário de numero "+ d +":\t");
			email = sscanner.nextLine();
			if(graduacao.equals("Professor")) {
				Professor professor = new Professor(nome, email, d+3);
				users.add(professor);
			}
			else if(graduacao.equals("Pesquisador")) {
				Researcher researcher = new Researcher(nome, email, d+3);
				users.add(researcher);
			}
			else if(graduacao.equals("Estudante")) {
				Student student = new Student(nome, email, d+3);
				users.add(student);
			}
			
		}
		
		System.out.println("\nCadastrar Recursos\nInforme o numero de Auditórios a cadastrar:\t");
		index = iscanner.nextInt();
		for(int i = 0; i < index; i++) {
			auditorium_aux = new Auditorium(i+3);
			auditoriums.setNext(auditorium_aux);
		}
		System.out.println("\nCadastrar Recursos\nInforme o numero de Salas de Aula a cadastrar:\t");
		index = iscanner.nextInt();
		for(int i = 0; i < index; i++) {
			class_room_aux = new ClassRoom(i+5);
			class_rooms.setNext(class_room_aux);
		}
		System.out.println("\nCadastrar Recursos\nInforme o numero de Laboratórios a cadastrar:\t");
		index = iscanner.nextInt();
		for(int i = 0; i < index; i++) {
			laboratory_aux = new Laboratory(i+5);
			laboratories.setNext(laboratory_aux);
		}
		System.out.println("\nCadastrar Recursos\nInforme o numero de Projetores a cadastrar:\t");
		index = iscanner.nextInt();
		for(int i = 0; i < index; i++) {
			projector_aux = new Projector(i+9);
			projectors.setNext(projector_aux);
		}
		int data_inicio;
		int data_fim;
		int hora_inicio;
		int hora_fim;
		String alocacao;
		String responsavel;
		String descricao;
		int userindex;
		do {
		System.out.println("\n\nNavegacao\n[1] - Realizar Alocacao\n[2] - Realizar Consulta\n[3] - Exibir Relatorios\n[4] - Confirmar Alocacao\n[5] - Concluir Alocacao\n");
		index = iscanner.nextInt();
		switch(index) {
		case 1:
			System.out.println("Informe a data de início da atividade:\t");
			int curr_data_ini = iscanner.nextInt();
			System.out.println("Informe a data de término da atividade:\t");
			int curr_data_fim = iscanner.nextInt();
			System.out.println("Informe a hora de inicio da atividade:\t");
			int curr_inicio = iscanner.nextInt();
			System.out.println("Informe a hora de termino da atividade:\t");
			int curr_termino = iscanner.nextInt();
			System.out.println("Informe o tipo de recurso necessario para a execucao da atividade:\t");
			String curr_alocacao = sscanner.nextLine();
			System.out.println("Informe o nome do responsavel pela atividade:\t");
			String curr_responsavel = sscanner.nextLine();
			System.out.println("Informe o tipo de atividade:\t");
			String curr_atividade = sscanner.nextLine();
			System.out.println("Informe o título da atividade:\t");
			String curr_titulo = sscanner.nextLine();
			System.out.println("Descreva a atividade:\t");
			String curr_descricao = sscanner.nextLine();
			System.out.println("Informe os participantes da atividade:\t");
			String curr_parts = sscanner.nextLine();
			System.out.println("Informe se há material de apoio:\t");
			String curr_material = sscanner.nextLine();
			
			ResourceChain chain;
			
			for(int i = 0; i < users.size(); i++) {
				if(curr_responsavel.equals(users.get(i).getName())) {
					//ATENÇÃO: Palavras-Chavem não acentuadas.
					if(curr_alocacao.equals("Auditorio")) {
						chain = auditoriums;
					}
					else if(curr_alocacao.equals("Sala de Aula")) {
						chain = class_rooms;
					}
					else if(curr_alocacao.equals("Laboratorio")) {
						chain = laboratories;
					}
					else if(curr_alocacao.equals("Projetor")) {
						chain = projectors;
					}
					
					if(curr_atividade.equals("Laboratorio")) {
						activity = new LaboratoryClass(chain, users.get(i), curr_titulo, curr_descricao,
								curr_parts, curr_material, curr_data_ini, curr_data_fim, curr_inicio, curr_termino);
						
						try {
							activities = chain.schedule(activities, activity);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(curr_alocacao.equals("Apresentacao")) {
						activity = new Presentation(chain, users.get(i), curr_titulo, curr_descricao,
								curr_parts, curr_material, curr_data_ini, curr_data_fim, curr_inicio, curr_termino);
						
						try {
							activities = chain.schedule(activities, activity);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else if(curr_alocacao.equals("Aula") && users.get(i).getPermission() > 1) {
						activity = new TraditionalClass(chain, users.get(i), curr_titulo, curr_descricao,
								curr_parts, curr_material, curr_data_ini, curr_data_fim, curr_inicio, curr_termino);
						
						try {
							activities = chain.schedule(activities, activity);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			break;
		case 2:
			System.out.println("Selecione o modo de consulta:\n[1] - Consulta por Usuario\n[2] - Consulta por Recurso");
			int innerindex = iscanner.nextInt();
			switch(innerindex) {
			case 1:
				System.out.println("Informe o nome do usuario:\t");
				String curr_nome = sscanner.nextLine();
				
				for(int i = 0; i < finished_activities.size(); i++) {
					if(finished_activities.get(i).getUser().getName().equals(curr_nome)) {
						System.out.println(finished_activities.get(i).toString());
					}
				}
				for(int i = 0; i < activities.size(); i++) {
					if(activities.get(i).getUser().getName().equals(curr_nome)) {
						System.out.println(activities.get(i).toString());
					}
				}
				
				break;
			case 2:
				System.out.println("Informe o tipo de Recurso:\t");
				String curr_recurso = sscanner.nextLine();
				System.out.println("Informe o id do Recurso:\t");
				int curr_id = iscanner.nextInt();
				
				for(int i = 0; i < finished_activities.size(); i++) {
					//ATENÇÃO: Palavras-Chavem não acentuadas.
					if(curr_recurso.equals("Auditorio") && finished_activities.get(i).getResource() instanceof Auditorium && curr_id == finished_activities.get(i).getResource().getId()) {
						System.out.println(finished_activities.get(i).toString());
					}
					else if(curr_recurso.equals("Sala de Aula") && finished_activities.get(i).getResource() instanceof ClassRoom && curr_id == finished_activities.get(i).getResource().getId()) {
						System.out.println(finished_activities.get(i).toString());
					}
					else if(curr_recurso.equals("Laboratorio") && finished_activities.get(i).getResource() instanceof Laboratory && curr_id == finished_activities.get(i).getResource().getId()) {
						System.out.println(finished_activities.get(i).toString());
					}
					else if(curr_recurso.equals("Projetor") && finished_activities.get(i).getResource() instanceof Projector && curr_id == finished_activities.get(i).getResource().getId()) {
						System.out.println(finished_activities.get(i).toString());
					}
				}
				for(int i = 0; i < activities.size(); i++) {
					//ATENÇÃO: Palavras-Chavem não acentuadas.
					if(curr_recurso.equals("Auditorio") && activities.get(i).getResource() instanceof Auditorium && curr_id == activities.get(i).getResource().getId()) {
						System.out.println(activities.get(i).toString());
					}
					else if(curr_recurso.equals("Sala de Aula") && activities.get(i).getResource() instanceof ClassRoom && curr_id == activities.get(i).getResource().getId()) {
						System.out.println(activities.get(i).toString());
					}
					else if(curr_recurso.equals("Laboratorio") && activities.get(i).getResource() instanceof Laboratory && curr_id == activities.get(i).getResource().getId()) {
						System.out.println(activities.get(i).toString());
					}
					else if(curr_recurso.equals("Projetor") && activities.get(i).getResource() instanceof Projector && curr_id == activities.get(i).getResource().getId()) {
						System.out.println(activities.get(i).toString());
					}
				}
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
			activities.get(index).updateStatus();//EM ANDAMENTO OU CONFIRMADO
			break;
		case 5:
			System.out.println("Informe o indice da Atividade:\t");
			indice = iscanner.nextInt();
			activities.get(index).updateStatus();//CONCLUÍDO
			break;
		}
		
		}while(index == 1 || index == 2 || index == 3);
	}

}
