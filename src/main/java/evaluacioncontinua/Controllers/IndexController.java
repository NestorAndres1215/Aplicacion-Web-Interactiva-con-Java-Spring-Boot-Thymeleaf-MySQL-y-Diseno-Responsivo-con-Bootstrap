package evaluacioncontinua.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/app", "/" })
public class IndexController {
	@RequestMapping(value = { "/index", "/" }, method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("titulo", "BIENVENIDO A LA ACADEMIA DEPORTIVA ANDRES");
		model.addAttribute("parrafo",
				"Lorem, ipsum dolor sit amet consectetur adipisicing elit. Molestiae explicabo sit illo. \r\n"
						+ "                Et distinctio odit nihil totam quibusdam? Accusamus veniam blanditiis cum nulla neque! Voluptatibus sit atque perspiciatis \r\n"
						+ "                quibusdam voluptates.\r\n"
						+ "            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Minus, eos ab perferendis, sunt dicta optio adipisci \r\n"
						+ "            quae suscipit tempora inventore explicabo in quos, deserunt ad magnam qui excepturi libero. Exercitationem.");
		model.addAttribute("subtitulo", "Lo mejores profesores");
		return "index"; // index.html (Templates)
	}
	@GetMapping(value="/consultar")
	public String consultar(ModelMap model) {
		return "consultar"; // index.html (Templates)
	}

}
