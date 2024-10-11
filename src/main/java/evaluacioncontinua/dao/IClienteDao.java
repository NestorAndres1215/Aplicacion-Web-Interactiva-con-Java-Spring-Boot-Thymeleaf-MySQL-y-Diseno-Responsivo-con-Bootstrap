package evaluacioncontinua.dao;

import org.springframework.data.repository.CrudRepository;

import evaluacioncontinua.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
}
