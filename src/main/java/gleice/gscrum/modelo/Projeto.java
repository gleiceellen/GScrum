package gleice.gscrum.modelo;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

        private Long idProjeto;
        private String nomeProjeto;
        private String descricaoProjeto;
        
        //dado que vem da tela, nao ha relacao com banco de dados.
        private List<Membro> membrosAssociados = new ArrayList<>();

        public void addMembro(Membro membro) {
                membrosAssociados.add(membro);
        }
        
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

        public List<Membro> getMembrosAssociados() {
                return membrosAssociados;
        }

        public void setMembrosAssociados(List<Membro> membrosAssociados) {
                this.membrosAssociados = membrosAssociados;
        }

}
