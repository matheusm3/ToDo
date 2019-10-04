package toDo;
import java.util.Date;

public class Tarefa {

	private int cod_tarefa;
	private String descricao;
	private int confere;
	private int usuario;
	
	public int getCod_tarefa() {
		return cod_tarefa;
	}
	public void setCod_tarefa(int cod_tarefa) {
		this.cod_tarefa = cod_tarefa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getConfere() {
		return confere;
	}
	public void setConfere(int check) {
		this.confere = check;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return "Tarefa [cod_tarefa=" + cod_tarefa + ", descricao=" + descricao + ", check=" + confere + ", usuario=" + usuario + "]";
	}
}
