package gleice.gscrum.modelo;

import java.util.Calendar;
import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {

        private Long idTarefa;
        private String descricao;
        private boolean finalizado;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        private Calendar dataFinalizacao;
        private Sprint sprint;
        private Pessoa pessoa;

        public Long getIdTarefa() {
                return idTarefa;
        }

        public void setIdTarefa(Long idTarefa) {
                this.idTarefa = idTarefa;
        }

        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public boolean isFinalizado() {
                return finalizado;
        }

        public void setFinalizado(boolean finalizado) {
                this.finalizado = finalizado;
        }

        public Calendar getDataFinalizacao() {
                return dataFinalizacao;
        }

        public void setDataFinalizacao(Calendar dataFinalizacao) {
                this.dataFinalizacao = dataFinalizacao;
        }

        public Sprint getSprint() {
                return sprint;
        }

        public void setsSprint(Sprint sprint) {
                this.sprint = sprint;
        }

        public Pessoa getPessoa() {
                return pessoa;
        }

        public void setPessoa(Pessoa pessoa) {
                this.pessoa = pessoa;
        }

}
