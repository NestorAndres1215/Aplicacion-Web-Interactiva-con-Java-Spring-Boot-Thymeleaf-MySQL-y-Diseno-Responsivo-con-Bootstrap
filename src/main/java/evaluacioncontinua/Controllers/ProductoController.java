package evaluacioncontinua.Controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import evaluacioncontinua.entity.Producto;
import evaluacioncontinua.service.IProductoService;

@Controller
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	//Crear el método para retornar la vista:	
	@GetMapping(value = "listar2")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("producto", productoService.listarProducto());
		return "listar2";
	}
	//Crear los métodos para guardar:	
	@GetMapping(value = "/form2")
	public String crear(Model model) {
		model.addAttribute("titulo", "Formulario de Productos");
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		return "form2";
	}

	// post:
	@PostMapping(value = "/form2")
	public String guardar(Producto producto, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Productos");
			return "form2";
		}
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				producto.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		productoService.crearProducto(producto);
		return "redirect:listar2";
	}
	//Método para agregar la imagen:
	@GetMapping(value = "/ver2/{id}")
	public String ver2(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Producto producto = productoService.editarProducto(id);
		if (producto == null) {
			return "redirect:/listar2";
		}
		model.put("producto", producto);
		model.put("titulo", "Detalle Producto :" + producto.getNombre());
		return "ver2";
	}
	//Creando el método para Editar:
	@GetMapping(value = "/form2/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Producto producto = null;
		if (id > 0) {
			producto = productoService.editarProducto(id);
		} else {
			return "redirect:/listar2";
		}
		model.put("titulo", "Editar Producto");
		model.put("producto", producto);
		return "form2";
	}
	//Creando el método para Eliminar:
	@GetMapping(value="/eliminar2/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			productoService.eliminarProducto(id);
		}
		return "redirect:/listar2";
	}
	

	
}
