package evaluacioncontinua.dao;

import org.springframework.data.repository.CrudRepository;

import evaluacioncontinua.entity.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface IClienteDao extends JpaRepository<Cliente, Long> {
 
    boolean existsByEmail(String email);
    // Puedes agregar otros métodos personalizados aquí si lo necesitas
}
