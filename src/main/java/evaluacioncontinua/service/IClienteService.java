package evaluacioncontinua.service;

import java.util.List;

import evaluacioncontinua.entity.Cliente;



public interface IClienteService {
		//Método 1: Listar los clientes:
		public List<Cliente> listarClientes();
		
		//Método 2: Crear un cliente:
		public void crearCliente(Cliente cliente);
		
		//Método 3: Editar un cliente:
		public Cliente editarCliente(Long id);
		
		//Método 4: Eliminar un cliente:
		public void eliminarCliente(Long id);
}
