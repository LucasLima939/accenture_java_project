package aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import aplicacao.model.Cadastro;
import aplicacao.model.Endereco;
import aplicacao.model.ViaCepModel;
import aplicacao.repository.CadastroLivroRepositorio;
import aplicacao.repository.CadastroRepositorio;
import aplicacao.repository.LocacaoRepositorio;

public class CadastroService {
	
	@Autowired
	private CadastroRepositorio cadastroRepository;
	
	@Autowired
	private ViaCepService viaCepService;
	
	public Cadastro criarUsuario(Cadastro usuario, String cep, String numero) {
		ViaCepModel model = null;
		if(cep != null && !cep.isEmpty()) {
			model = viaCepService.getModelByCep(cep);
			}
		if(model != null) {
			usuario.setEndereco(new Endereco(model, numero));
			return cadastroRepository.save(usuario);
        } else {
        	return null;
        }
	}
	
	public Cadastro recuperarUsuario(Integer id){
		return cadastroRepository.findById(id).orElse(null);
	}
	
	public List<Cadastro> recuperarTodosUsuarios() {
		List<Cadastro> todosUsuarios = new ArrayList<Cadastro>();
		cadastroRepository.findAll().forEach(todosUsuarios::add);
		return todosUsuarios;
	}
	
	public List<Cadastro> recuperarUsuariosPorListaId(List<Integer> ids){
		List<Cadastro> todosUsuarios = new ArrayList<Cadastro>();
		cadastroRepository.findAllById(ids).forEach(todosUsuarios::add);
		return todosUsuarios;
	}
	
	public Cadastro editarUsuario(Cadastro cadastro){
		return cadastroRepository.save(cadastro);
	}
	
	public Boolean deletarUsuario(Integer id) {
		try {
		cadastroRepository.deleteById(id);
		return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
	
}
