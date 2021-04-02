package aplicacao.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tab_locacao")
public class Locacao {
	
	public Locacao(Cadastro cadastro, Date dataAgendamento){
		this.cadastro = cadastro;
		this.dataAgendamento = dataAgendamento;
	}
	
	public Locacao(Date dataAgendamento){
		this.dataAgendamento = dataAgendamento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
    @JoinColumn(nullable = false)
    private Cadastro cadastro;
	
    @ManyToMany
    @Column(nullable = false)
    private List<CadastroLivro> livros;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataAgendamento = new Date(System.currentTimeMillis());
	
	@Temporal(TemporalType.DATE)
	private Date dataRetirada;
	
	@Temporal(TemporalType.DATE)
	private Date dataFinalizacao;
	
	private Double valorTotal = 0.0;

	@Enumerated(EnumType.STRING)
	private StatusLocacao status = StatusLocacao.RESERVADA;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<CadastroLivro> getLivros() {
		return livros;
	}

	public void setLivros(List<CadastroLivro> livros) {
		this.livros = livros;
	}
	
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
	public Date getDataRetirada() {
		return dataRetirada;
	}
	
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	
	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public Locacao()
	{}
	
	
}
