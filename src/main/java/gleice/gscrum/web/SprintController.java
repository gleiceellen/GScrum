package gleice.gscrum.web;

import gleice.gscrum.dao.ProjetoDao;
import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.SprintDao;
import gleice.gscrum.modelo.Projeto;
import gleice.gscrum.modelo.Sprint;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SprintController extends GScrumController{

        @RequestMapping("/novoSprint")
        public String form() {
                return "addsprint";
        }

        @RequestMapping("/adicionaSprints")
        public String adiciona(Sprint sprint) {

                try {

                        SprintDao dao = new SprintDao();
                        dao.adiciona(sprint);
                        System.out.println(sprint);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "sprintAdicionado";

        }
        
        @RequestMapping("/listaSprints")
        public ModelAndView lista() throws SQLException {

                ProjetoDao dao = new ProjetoDao();

                List<Projeto> pessoas = dao.getLista();

                ModelAndView mv = new ModelAndView("listaSprints");
                mv.addObject("todosSprints", pessoas);

                return mv;

        }
        
        @RequestMapping("/removeSprint")
        public String remove(Sprint spt) {

                try {

                        SprintDao dao = new SprintDao();
                        dao.remove(spt);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "redirect:listaSprints";
        }

        @RequestMapping("/mostraSprint")
        public String mostra(Long idSprint, Model model) {

                try {

                        SprintDao dao = new SprintDao();
                        model.addAttribute("sprint", dao.buscaPorId(idSprint));

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return "exibesprint";
        }

        @RequestMapping("/alteraSprint")
        public String altera(Sprint spt) {
                try {

                        SprintDao dao = new SprintDao();
                        dao.altera(spt);

                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return "redirect:listaSprints";
        }
            
}
