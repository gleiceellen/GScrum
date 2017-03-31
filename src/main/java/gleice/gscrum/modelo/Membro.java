package gleice.gscrum.modelo;

public class Membro {

        private Long idMembro;
        private Pessoa pessoa;
        private Projeto projeto;

        public Long getIdMembro() {
                return idMembro;
        }

        public void setIdMembro(Long idMembro) {
                this.idMembro = idMembro;
        }

        public Pessoa getPessoa() {
                return pessoa;
        }

        public void setPessoa(Pessoa pessoa) {
                this.pessoa = pessoa;
        }

        public Projeto getProjeto() {
                return projeto;
        }

        public void setProjeto(Projeto projeto) {
                this.projeto = projeto;
        }

}
