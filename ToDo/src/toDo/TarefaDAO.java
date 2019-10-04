package toDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO extends BasicoDAO{

	public void insert(Tarefa tarefa) {

		String sql = " insert into tarefa(descricao, confere, usuario) values(?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, tarefa.getDescricao());
			statement.setInt(2, tarefa.getConfere());
			statement.setInt(3, tarefa.getUsuario());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete (Tarefa tarefa) {
		
		String sql = " delete from tarefa where cod_tarefa = ?";
	
		try(Connection conn = getConnection();
				PreparedStatement statement = conn.prepareStatement(sql)) {
				statement.setInt(1, tarefa.getCod_tarefa());
				statement.execute();
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void update (Tarefa tarefa) {
		String sql = " update tarefa set descricao = ?, confere = ?, usuario = ? where cod_tarefa = ?";
	

		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setString(1, tarefa.getDescricao());
			statement.setInt(2, tarefa.getConfere());
			statement.setInt(3, tarefa.getUsuario());
			statement.setInt(4, tarefa.getCod_tarefa());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Tarefa getById (int id) {
		Tarefa tarefa = null;
		String sql = " select cod_tarefa, nome_tarefa, descricao, confere, from tarefa where cod_usuario = ?";
	

		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				tarefa = new Tarefa();
				tarefa.setCod_tarefa(resultSet.getInt(1));
				tarefa.setDescricao(resultSet.getString(2));
				tarefa.setConfere(resultSet.getInt(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tarefa;
	}
	
	public List<Tarefa> getAll(){
		List<Tarefa> list = new ArrayList<>();
		String sql = " select cod_tarefa, descricao, confere from tarefa order by descricao";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Tarefa tarefa = new Tarefa();				
				tarefa.setCod_tarefa(resultSet.getInt(1));
				tarefa.setDescricao(resultSet.getString(2));
				tarefa.setConfere(resultSet.getInt(3));
				
				list.add(tarefa);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}