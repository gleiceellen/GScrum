package gleice.gscrum.web;

import gleice.gscrum.util.GScrumController;
import gleice.gscrum.dao.PessoaDao;
import gleice.gscrum.modelo.Pessoa;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PessoaController extends GScrumController{

        @RequestMapping("/novaPessoa")
        public String form() {
                return "addpessoa";
        }

        @RequestMapping("/adicionaPessoa")
        public String adiciona(Pessoa pessoa) {

                try {

                        PessoaDao dao = new PessoaDao();
                        dao.adiciona(pessoa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "redirect:listaPessoas";

        }

        @RequestMapping("/listaPessoas")
        public ModelAndView lista() throws SQLException {

                PessoaDao dao = new PessoaDao();

                List<Pessoa> pessoas = dao.getLista();

                ModelAndView mv = new ModelAndView("listaPessoa");
                mv.addObject("todasPessoas", pessoas);

                return mv;

        }

        @RequestMapping("mostraLista")
        public String mostraLista(Long id, Model model) {

                try {

                        PessoaDao dao = new PessoaDao();
                        model.addAttribute("pessoa", dao.getLista());

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "mostra";
        }

        @RequestMapping("/removePessoa")
        public String remove(Pessoa pessoa) {

                try {

                        PessoaDao dao = new PessoaDao();
                        dao.remove(pessoa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }

                return "redirect:listaPessoas";
        }

        @RequestMapping("/mostraPessoa")
        public String mostra(Long idPessoa, Model model) {

                try {

                        PessoaDao dao = new PessoaDao();
                        model.addAttribute("pessoa", dao.buscaPorId(idPessoa));

                } catch (Exception e) {
                        e.printStackTrace();
                }

                return "exibepessoa";
        }

        @RequestMapping("/alteraPessoa")
        public String altera(Pessoa pessoa) {
                try {

                        PessoaDao dao = new PessoaDao();
                        dao.altera(pessoa);

                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return "redirect:listaPessoas";
        }

}
