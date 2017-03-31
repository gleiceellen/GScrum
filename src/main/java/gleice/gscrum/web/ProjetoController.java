package gleice.gscrum.web;

import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.ProjetoDao;
import gleice.gscrum.modelo.Projeto;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjetoController extends GScrumController{

        @Autowired
        private ProjetoDao dao;

        @RequestMapping("/novoProject")
        public String form() {
                return "addprojeto";
        }

        @RequestMapping("/adicionaProject")
        public String adiciona(Projeto projeto) {
                dao.adiciona(projeto);
                return "projetoAdicionado";
        }

        @RequestMapping("/listaProjetos")
        public ModelAndView lista() throws SQLException {
                List<Projeto> projetos = dao.getLista();

                ModelAndView mv = new ModelAndView("listaProjetos");
                mv.addObject("todosProjetos", projetos);

                return mv;
        }

        @RequestMapping("/removeProjeto")
        public String remove(Projeto projeto) {
                dao.remove(projeto);
                return "redirect:listaTarefas";
        }

        @RequestMapping("/mostraProjeto")
        public String mostra(Long idProjeto, Model model) {
                model.addAttribute("projeto", dao.buscaPorId(idProjeto));
                return "exibeprojeto";
        }

        @RequestMapping("/alteraProjeto")
        public String altera(Projeto projeto) {
                dao.altera(projeto);
                return "redirect:listaProjetos";
        }
}
