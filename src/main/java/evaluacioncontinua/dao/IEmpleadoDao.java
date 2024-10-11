package evaluacioncontinua.dao;

import org.springframework.data.repository.CrudRepository;

import evaluacioncontinua.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository <Empleado,Long> {

}
