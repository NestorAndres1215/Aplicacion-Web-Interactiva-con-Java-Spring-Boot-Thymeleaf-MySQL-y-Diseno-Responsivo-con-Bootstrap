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
		// TODO Auto-generated method stub
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	@Transactional
	public void crearProducto(Producto producto) {
		// TODO Auto-generated method stub
		productoDao.save(producto);
	}

	@Override
	public Producto editarProducto(Long id) {
		// TODO Auto-generated method stub
		return productoDao .findById(id).orElse(null);
	}

	@Override
	public void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		productoDao .deleteById(id);
	}

}
