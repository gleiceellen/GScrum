package gleice.gscrum.modelo;

public class Pessoa {

        private Long idPessoa;
        private String nomePessoa;
        private String emailPessoa;
        private String telefonePessoa;
        private String qualificacaoPessoa;

        public Long getIdPessoa() {
                return idPessoa;
        }

        public void setIdPessoa(Long idPessoa) {
                this.idPessoa = idPessoa;
        }

        public String getNomePessoa() {
                return nomePessoa;
        }

        public void setNomePessoa(String nomePessoa) {
                this.nomePessoa = nomePessoa;
        }

        public String getEmailPessoa() {
                return emailPessoa;
        }

        public void setEmailPessoa(String emailPessoa) {
                this.emailPessoa = emailPessoa;
        }

        public String getTelefonePessoa() {
                return telefonePessoa;
        }

        public void setTelefonePessoa(String telefonePessoa) {
                this.telefonePessoa = telefonePessoa;
        }

        public String getQualificacaoPessoa() {
                return qualificacaoPessoa;
        }

        public void setQualificacaoPessoa(String qualificacaoPessoa) {
                this.qualificacaoPessoa = qualificacaoPessoa;
        }

}
