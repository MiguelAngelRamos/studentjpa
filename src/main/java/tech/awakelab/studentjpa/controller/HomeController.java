package tech.awakelab.studentjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    /**
     * Maneja las solicitudes que se le hacen a la raíz del sitio
     * @return un objeto {@link ModelAndView} con la respuesta al cliente
     */
  
  //http://localhost:8080
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView mostrarHome() {
        return new ModelAndView("home", "mensaje", "Hola (ed)Mundo!");
    }

}
