package gleice.gscrum.web;

import gleice.gscrum.dao.ProjetoDao;
import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.SprintDao;
import gleice.gscrum.modelo.Sprint;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SprintController extends GScrumController {

        @Autowired
        private SprintDao dao;

        @Autowired
        private ProjetoDao daoProjeto;

        @RequestMapping("/listaSprints")
        public String lista(Model model) {
                dao.getLista();
                model.addAttribute("todasSprints", dao.getLista());
                model.addAttribute("projetos", daoProjeto.getLista());
                return "listaSprint";
        }

        @RequestMapping("/adicionaSprint")
        public String adiciona(Sprint sprint) {
                dao.adicionarOuAlterar(sprint);
                return "redirect:listaSprints";
        }

        @RequestMapping("/removeSprint")
        public String remove(Sprint spt) {
                dao.remove(spt);
                return "redirect:listaSprints";
        }

        @RequestMapping("/mostraSprint")
        public String mostra(Long idSprint, Model model) {
                model.addAttribute("sprint", dao.buscaPorId(idSprint));
                return this.lista(model);
        }
}
