package gleice.gscrum.web;

import gleice.gscrum.util.GScrumController;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class AppController extends GScrumController {

        @ResponseBody
        @RequestMapping(value = "/teste", method = RequestMethod.GET)
        public String teste(HttpServletResponse resp) {
                return "Requisicao OK! :)";
        }

        @RequestMapping("/home")
        public String abrirHome() {
                return "home";
        }
        
}
