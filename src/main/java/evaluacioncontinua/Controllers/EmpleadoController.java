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

import evaluacioncontinua.entity.Empleado;
import evaluacioncontinua.service.IEmpleadoService;

@Controller
public class EmpleadoController {
	@Autowired
	private IEmpleadoService empleadoService;

	@GetMapping(value = "listar1")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Empleados");
		model.addAttribute("empleados", empleadoService.listarEmpleados());
		return "listar1";
	}

	@GetMapping(value = "/form1")
	public String crear(Model model) {
		model.addAttribute("titulo", "Formulario de Empleados");
		Empleado empleado = new Empleado();
		model.addAttribute("empleado", empleado);
		return "form1";
	}

	// post:
	@PostMapping(value = "/form1")
	public String guardar(Empleado empleado, BindingResult result, Model model,
			@RequestParam("file") MultipartFile foto) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario del Empleados");
			return "form1";
		}
		if (!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				empleado.setFoto(foto.getOriginalFilename());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		empleadoService.crearEmpleados(empleado);
		return "redirect:listar1";
	}

	@GetMapping(value = "/ver1/{id}")
	public String ver1(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Empleado empleado = empleadoService.editarEmpleado(id);
		if (empleado == null) {
			return "redirect:/listar1";
		}
		model.put("empleado", empleado);
		model.put("titulo", "Detalle Empleado :" + empleado.getNombre());
		return "ver1";
	}

	@GetMapping(value = "/form1/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Empleado empleado = null;
		if (id > 0) {
			empleado = empleadoService.editarEmpleado(id);
		} else {
			return "redirect:/listar1";
		}
		model.put("titulo", "Editar Empleado");
		model.put("empleado", empleado);
		return "form1";
	}
	@GetMapping(value="/eliminar1/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id>0) {
			empleadoService.eliminarEmpleado(id);
		}
		return "redirect:/listar1";
	}
	
}
