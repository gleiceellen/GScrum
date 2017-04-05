package gleice.gscrum.web;

import gleice.gscrum.dao.MembroDao;
import gleice.gscrum.dao.PessoaDao;
import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.ProjetoDao;
import gleice.gscrum.modelo.Membro;
import gleice.gscrum.modelo.Projeto;
import java.util.List;
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

        @Autowired
        private MembroDao daoMembro;
        
        @RequestMapping("/listaProjetos")
        public String lista(Model model) {
                model.addAttribute("todosProjetos", dao.getLista());
                model.addAttribute("pessoas", daoPessoa.getLista());
                return "listaProjetos";
        }
        
        @RequestMapping("/adicionaProjeto")
        public String adiciona(Projeto projeto) {
                Long idProjetoGerado = dao.adicionarOuAlterar(projeto);
                this.vincular(idProjetoGerado, projeto.getMembrosAssociados());
                return "redirect:listaProjetos";
        }

        @RequestMapping("/removeProjeto")
        public String remove(Projeto projeto) {
                dao.remove(projeto);
                return "redirect:listaProjetos";
        }

        @RequestMapping("/mostraProjeto")
        public String mostra(Long idProjeto, Model model) {
                model.addAttribute("projeto", dao.buscaPorId(idProjeto, true));
                
                //nao faz redirect para nao perder os dados de pessoa. Redirect limpa os dados da request.
                return this.lista(model);
        }
        
        private void vincular(Long idProjeto, List<Membro> pessoas){
                for(Membro pessoaTela : pessoas){
                        if(pessoaTela.getPessoa()!=null){
                                Membro m = new Membro();
                                m.setPessoa( this.daoPessoa.buscaPorId(pessoaTela.getPessoa().getIdPessoa()) );
                                m.setProjeto( this.dao.buscaPorId(idProjeto, true) );
                                this.daoMembro.adicionarOuAlterar(m);
                        }
                }
        }
}
