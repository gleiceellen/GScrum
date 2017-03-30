package gleice.gscrum.modelo;

public class Projeto {

        Long idProjeto;
        String nomeProjeto;
        String descricaoProjeto;

        public Long getIdProjeto() {
                return idProjeto;
        }

        public void setIdProjeto(Long idProjeto) {
                this.idProjeto = idProjeto;
        }

        public String getNomeProjeto() {
                return nomeProjeto;
        }

        public void setNomeProjeto(String nomeProjeto) {
                this.nomeProjeto = nomeProjeto;
        }

        public String getDescricaoProjeto() {
                return descricaoProjeto;
        }

        public void setDescricaoProjeto(String descricaoProjeto) {
                this.descricaoProjeto = descricaoProjeto;
        }

}
