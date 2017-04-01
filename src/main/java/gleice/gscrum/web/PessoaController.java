package gleice.gscrum.web;

import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.PessoaDao;
import gleice.gscrum.modelo.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PessoaController extends GScrumController {

        @Autowired
        private PessoaDao dao;

        @RequestMapping("/listaPessoas")
        public String lista(Model model) {
                model.addAttribute("todasPessoas", dao.getLista());
                return "listaPessoa";
        }

        @RequestMapping("/adicionaPessoa")
        public String adiciona(Pessoa pessoa) {
                dao.adicionarOuAlterar(pessoa);
                return "redirect:listaPessoas";
        }

        @RequestMapping("/removePessoa")
        public String remove(Pessoa pessoa) {
                dao.remove(pessoa);
                return "redirect:listaPessoas";
        }

        @RequestMapping("/mostraPessoa")
        public String mostra(Long idPessoa, Model model) {
                model.addAttribute("pessoa", dao.buscaPorId(idPessoa));

                //nao faz redirect para nao perder os dados de pessoa. Redirect limpa os dados da request.
                return this.lista(model);
        }

}
