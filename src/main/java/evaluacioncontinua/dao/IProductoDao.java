package evaluacioncontinua.dao;

import org.springframework.data.repository.CrudRepository;


import evaluacioncontinua.entity.Producto;

public interface IProductoDao  extends CrudRepository <Producto,Long>{

}
