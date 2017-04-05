package gleice.gscrum.web;

import gleice.gscrum.dao.PessoaDao;
import gleice.gscrum.dao.SprintDao;
import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.TarefaDao;
import gleice.gscrum.modelo.Tarefa;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TarefaController extends GScrumController {

        @Autowired
        private TarefaDao dao;

        @Autowired
        private PessoaDao daoPessoa;

        @Autowired
        private SprintDao daoSprint;
        
        @RequestMapping("/listaTarefas")
        public String lista(Model model) {
                model.addAttribute("todasTarefas", dao.getLista());
                model.addAttribute("pessoas", daoPessoa.getLista());
                model.addAttribute("sprints", daoSprint.getLista());
                return "listaTarefas";
        }

        @RequestMapping("/adicionaTarefa")
        public String adiciona(Tarefa tarefa) {
                dao.adicionarOuAlterar(tarefa);
                return "redirect:listaTarefas";
        }

        @RequestMapping("/removeTarefa")
        public String remove(Tarefa tarefa) {
                dao.remove(tarefa);
                return "redirect:listaTarefas";
        }

        @RequestMapping("/mostraTarefa")
        public String mostra(Long idTarefa, Model model) {
                model.addAttribute("tarefa", dao.buscaPorId(idTarefa));
                return this.lista(model);
        }

        @ResponseBody
        @RequestMapping(value = "/finalizaTarefa", method = RequestMethod.POST)
        public String finaliza(Long idTarefa) {
                dao.finaliza(idTarefa);
                return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        }

}
