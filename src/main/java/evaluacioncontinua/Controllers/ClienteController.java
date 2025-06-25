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

import evaluacioncontinua.entity.Cliente;
import evaluacioncontinua.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	// Crear el método para retornar la vista:
	@GetMapping(value = "/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.listarClientes());
		return "listar";
	}

	// Crear los métodos para guardar:
	@GetMapping(value = "/form")
	public String crear(Model model) {
		model.addAttribute("titulo", "Formulario de Cliente");
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "form";
	}

	// Post:
	@PostMapping(value = "/form")
	public String guardar(Cliente cliente, BindingResult result,
			Model model, @RequestParam("file") MultipartFile foto) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Cliente");
			return "form";
		}

		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				cliente.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		clienteService.crearCliente(cliente);
		return "redirect:listar";
	}

	// Método para agregar la imagen:
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = clienteService.editarCliente(id);
		if (cliente == null) {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Detalle cliente:" + cliente.getNombre());
		return "ver";
	}

	// Creando el método para Editar:
	@GetMapping(value = "/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = null;
		if (id > 0) {
			cliente = clienteService.editarCliente(id);
		} else {
			return "redirect:/listar";
		}
		model.put("titulo", "Editar Cliente");
		model.put("cliente", cliente);
		return "form";
	}

	// Creando el método para Eliminar:
	@GetMapping(value = "/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id) {
		if (id > 0) {
			clienteService.eliminarCliente(id);
		}
		return "redirect:/listar";
	}
}