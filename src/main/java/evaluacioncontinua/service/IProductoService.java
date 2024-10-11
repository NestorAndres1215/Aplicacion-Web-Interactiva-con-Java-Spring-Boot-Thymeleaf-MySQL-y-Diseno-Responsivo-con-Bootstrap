package evaluacioncontinua.service;

import java.util.List;

import evaluacioncontinua.entity.Producto;

public interface IProductoService {
	public List<Producto>listarProducto();
	public void crearProducto(Producto producto);
	public Producto editarProducto(Long id);
	public void eliminarProducto(Long id);

}
