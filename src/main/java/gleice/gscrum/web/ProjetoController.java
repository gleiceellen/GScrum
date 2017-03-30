package gleice.gscrum.web;

import gleice.gscrum.dao.ProjetoDao;
import gleice.gscrum.modelo.Projeto;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjetoController {

        @RequestMapping("/novoProject")
        public String form() {
                return "addprojeto";
        }

        @RequestMapping("/adicionaProject")
        public String adiciona(Projeto projeto) {

                try {

                        ProjetoDao dao = new ProjetoDao();
                        dao.adiciona(projeto);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "projetoAdicionado";
        }

        @RequestMapping("/listaProjetos")
        public ModelAndView lista() throws SQLException {

                ProjetoDao dao = new ProjetoDao();

                List<Projeto> projetos = dao.getLista();

                ModelAndView mv = new ModelAndView("listaProjetos");
                mv.addObject("todosProjetos", projetos);

                return mv;

        }

        @RequestMapping("/removeProjeto")
        public String remove(Projeto projeto) {

                try {

                        ProjetoDao dao = new ProjetoDao();
                        dao.remove(projeto);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "redirect:listaTarefas";
        }

        @RequestMapping("/mostraProjeto")
        public String mostra(Long idProjeto, Model model) {

                try {

                        ProjetoDao dao = new ProjetoDao();
                        model.addAttribute("projeto", dao.buscaPorId(idProjeto));

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return "exibeprojeto";
        }

        @RequestMapping("/alteraProjeto")
        public String altera(Projeto projeto) {
                try {

                        ProjetoDao dao = new ProjetoDao();
                        dao.altera(projeto);

                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return "redirect:listaProjetos";
        }
}
