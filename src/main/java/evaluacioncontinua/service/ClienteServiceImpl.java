package evaluacioncontinua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import evaluacioncontinua.dao.IClienteDao;
import evaluacioncontinua.entity.Cliente;



@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public List<Cliente> listarClientes() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void crearCliente(Cliente cliente) {		
		clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public Cliente editarCliente(Long id) {		
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminarCliente(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	public boolean correoExiste(String correo) {
		return clienteDao.existsByEmail(correo);
	}

}
