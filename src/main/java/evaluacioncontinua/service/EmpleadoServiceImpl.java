package evaluacioncontinua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import evaluacioncontinua.dao.IEmpleadoDao;
import evaluacioncontinua.entity.Empleado;


@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	
	@Override
	public List<Empleado> listarEmpleados() {
	
		return (List<Empleado>)empleadoDao.findAll();
	}

	@Override
	@Transactional
	public void crearEmpleados(Empleado empleado) {
		empleadoDao.save(empleado);
	}

	@Override
	public Empleado editarEmpleado(Long id) {
		return empleadoDao .findById(id).orElse(null);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		empleadoDao .deleteById(id);
	}

}
