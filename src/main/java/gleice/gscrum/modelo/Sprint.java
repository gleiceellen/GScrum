package gleice.gscrum.modelo;

import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

public class Sprint {

        private Long idSprint;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        private Calendar dtInicioSprint;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        private Calendar dtFimSprint;
        private String productBacklog;
        private String estadoSprint;
        private Projeto projeto;

        public Long getIdSprint() {
                return idSprint;
        }

        public void setIdSprint(Long idSprint) {
                this.idSprint = idSprint;
        }

        public Calendar getDtInicioSprint() {
                return dtInicioSprint;
        }

        public void setDtInicioSprint(Calendar dtInicioSprint) {
                this.dtInicioSprint = dtInicioSprint;
        }

        public Calendar getDtFimSprint() {
                return dtFimSprint;
        }

        public void setDtFimSprint(Calendar dtFimSprint) {
                this.dtFimSprint = dtFimSprint;
        }

        public String getProductBacklog() {
                return productBacklog;
        }

        public void setProductBacklog(String productBacklog) {
                this.productBacklog = productBacklog;
        }

        public String getEstadoSprint() {
                return estadoSprint;
        }

        public void setEstadoSprint(String estadoSprint) {
                this.estadoSprint = estadoSprint;
        }

        public Projeto getProjeto() {
                return projeto;
        }

        public void setProjeto(Projeto projeto) {
                this.projeto = projeto;
        }

}
