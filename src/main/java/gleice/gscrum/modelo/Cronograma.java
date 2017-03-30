package gleice.gscrum.modelo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Cronograma {

        Long idCronograma;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date inicioCronograma;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fimCronograma;
        Sprint sprint;
        String estadoCronograma;

        public Long getIdCronograma() {
                return idCronograma;
        }

        public void setIdCronograma(Long idCronograma) {
                this.idCronograma = idCronograma;
        }

        public Date getInicioCronograma() {
                return inicioCronograma;
        }

        public void setInicioCronograma(Date inicioCronograma) {
                this.inicioCronograma = inicioCronograma;
        }

        public Date getFimCronograma() {
                return fimCronograma;
        }

        public void setFimCronograma(Date fimCronograma) {
                this.fimCronograma = fimCronograma;
        }

        public Sprint getSprint() {
                return sprint;
        }

        public void setSprint(Sprint sprint) {
                this.sprint = sprint;
        }

        public String getEstadoCronograma() {
                return estadoCronograma;
        }

        public void setEstadoCronograma(String estadoCronograma) {
                this.estadoCronograma = estadoCronograma;
        }

}
