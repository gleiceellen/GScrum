package gleice.gscrum.web;

import gleice.gscrum.dao.PessoaDao;
import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.ProjetoDao;
import gleice.gscrum.modelo.Projeto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjetoController extends GScrumController{

        @Autowired
        private ProjetoDao dao;

        @Autowired
        private PessoaDao daoPessoa;
        
        @RequestMapping("/adicionaProjeto")
        public String adiciona(Projeto projeto) {
                dao.adiciona(projeto);
                return "redirect:listaProjetos";
        }

        @RequestMapping("/listaProjetos")
        public String lista(Model model) {
                model.addAttribute("todosProjetos", dao.getLista());
                model.addAttribute("pessoas", daoPessoa.getLista());
                return "listaProjetos";
        }

        @RequestMapping("/removeProjeto")
        public String remove(Projeto projeto) {
                dao.remove(projeto);
                return "redirect:listaTarefas";
        }

        @RequestMapping("/mostraProjeto")
        public String mostra(Long idProjeto, Model model) {
                model.addAttribute("projeto", dao.buscaPorId(idProjeto));
                
                //nao faz redirect para nao perder os dados de pessoa. Redirect limpa os dados da request.
                return this.lista(model);
        }
}
