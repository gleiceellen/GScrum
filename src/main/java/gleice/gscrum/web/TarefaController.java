package gleice.gscrum.web;

import gleice.gscrum.dao.TarefaDao;
import gleice.gscrum.modelo.Tarefa;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefaController {

        @RequestMapping("/novaTarefa")
        public String form() {
                return "addtarefa";
        }

        @RequestMapping("/verTarefasDisponiveis")
        public String ver() {
                try {
                        TarefaDao dao = new TarefaDao();
                        List<Tarefa> tarefas = dao.getLista();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return "TarefasToSprint";
        }

        @RequestMapping("/adicionaTarefa")
        public String adiciona(Tarefa tarefa) {

                try {

                        TarefaDao dao = new TarefaDao();
                        dao.adiciona(tarefa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "redirect:listaTarefas";
        }

        @RequestMapping("/listaTarefas")
        public ModelAndView lista() throws SQLException {

                TarefaDao dao = new TarefaDao();

                List<Tarefa> tarefas = dao.getLista();

                ModelAndView mv = new ModelAndView("listaTarefas");
                mv.addObject("todasTarefas", tarefas);
                return mv;
        }

        @RequestMapping("/removeTarefa")
        public String remove(Tarefa tarefa) {

                try {

                        TarefaDao dao = new TarefaDao();
                        dao.remove(tarefa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "redirect:listaTarefas";
        }

        @RequestMapping("/mostraTarefa")
        public String mostra(Long idTarefa, Model model) {

                try {

                        TarefaDao dao = new TarefaDao();
                        model.addAttribute("tarefa", dao.buscaPorId(idTarefa));

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return "exibetarefa";
        }

        @RequestMapping("/alteraTarefa")
        public String altera(Tarefa tarefa) {
                try {

                        TarefaDao dao = new TarefaDao();
                        dao.altera(tarefa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return "redirect:listaTarefas";
        }

        @RequestMapping("/finalizaTarefa")
        public void finaliza(Long idTarefa) {
                try {

                        TarefaDao dao = new TarefaDao();
                        dao.finaliza(idTarefa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

        }

}
