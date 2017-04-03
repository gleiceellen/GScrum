package gleice.gscrum.web;

import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.TarefaDao;
import gleice.gscrum.modelo.Tarefa;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TarefaController extends GScrumController{

    @Autowired
    private TarefaDao dao;
    
    @RequestMapping("/listaTarefas")
    public String lista(Model model){
        model.addAttribute("todasTarefas", dao.getLista());
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

    @RequestMapping("/alteraTarefa")
    public String altera(Tarefa tarefa) {
        dao.altera(tarefa);
        return "redirect:listaTarefas";
    }

    @RequestMapping("/finalizaTarefa")
    public void finaliza(Long idTarefa) {
        dao.finaliza(idTarefa);
    }

}
