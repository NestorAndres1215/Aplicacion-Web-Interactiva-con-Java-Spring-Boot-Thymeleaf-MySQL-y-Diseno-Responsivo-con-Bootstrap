package evaluacioncontinua.service;

import java.util.List;

import evaluacioncontinua.entity.Empleado;

public interface IEmpleadoService {
	public List<Empleado>listarEmpleados();
	public void crearEmpleados(Empleado empleado);
	public Empleado editarEmpleado(Long id);
	public void eliminarEmpleado(Long id);
	
	
}
