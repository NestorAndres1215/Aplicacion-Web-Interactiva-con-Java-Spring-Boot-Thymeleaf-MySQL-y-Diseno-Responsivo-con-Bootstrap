package evaluacioncontinua.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import evaluacioncontinua.dao.IProductoDao;
import evaluacioncontinua.entity.Producto;
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	
	@Override
	public List<Producto> listarProducto() {
		
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	@Transactional
	public void crearProducto(Producto producto) {
	
		productoDao.save(producto);
	}

	@Override
	public Producto editarProducto(Long id) {
	
		return productoDao .findById(id).orElse(null);
	}

	@Override
	public void eliminarProducto(Long id) {
	
		productoDao .deleteById(id);
	}

}
