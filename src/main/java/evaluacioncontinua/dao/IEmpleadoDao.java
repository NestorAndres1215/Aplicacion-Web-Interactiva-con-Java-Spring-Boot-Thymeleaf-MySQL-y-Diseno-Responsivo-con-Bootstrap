package evaluacioncontinua.dao;

import org.springframework.data.repository.CrudRepository;

import evaluacioncontinua.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpleadoDao extends JpaRepository<Empleado, Long> {

}
