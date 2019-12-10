package pe.edu.delfines.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
	}

}
