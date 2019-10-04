package toDo;

public class Main {

	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario p = new Usuario();
		p.setNome_usuario("Bruno");
		p.setEmail("ooo@ooo.ooo");
		p.setSenha("uuuuu");
		p.setStatus(1);
		
		dao.insert(p);
		dao.update(p);
		dao.delete(p);
		dao.getAll();
				
		for(Usuario usuario : dao.getAll()) {
			System.out.println(usuario);
		}
		
		//
		
		TarefaDAO tdao = new TarefaDAO();

		Tarefa t = new Tarefa();
		t.setDescricao("Comprar Pão");
		t.setConfere(0);
		t.setUsuario(2);
		
		tdao.insert(t);
		tdao.update(t);
		tdao.delete(t); 
		tdao.getAll();
	}

}
