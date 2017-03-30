package gleice.gscrum.dao;

import gleice.gscrum.modelo.Tarefa;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TarefaDao {

        private final Connection connection;

        public TarefaDao() throws SQLException {
                this.connection = new ConnectionFactory().getConnection();
        }

        public void adiciona(Tarefa tarefa) {
                String sql = "insert into tarefa (descricao, finalizado, idSprint, idPessoa) values (?,?,?,?)";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, tarefa.getDescricao());
                        stmt.setBoolean(2, tarefa.isFinalizado());
                        stmt.setLong(3, tarefa.getIdSprint());
                        stmt.setLong(4, tarefa.getIdPessoa());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public List<Tarefa> getLista() {
                try {
                        List<Tarefa> tarefas = new ArrayList<Tarefa>();
                        PreparedStatement stmt = this.connection
                                .prepareStatement("select * from tarefa");

                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                                // adiciona a tarefa na lista
                                tarefas.add(populaTarefa(rs));
                        }

                        rs.close();
                        stmt.close();

                        return tarefas;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private Tarefa populaTarefa(ResultSet rs) throws SQLException {
                Tarefa tarefa = new Tarefa();

                // popula o objeto tarefa
                tarefa.setIdTarefa(rs.getLong("idTarefa"));
                tarefa.setDescricao(rs.getString("descricao"));
                tarefa.setFinalizado(rs.getBoolean("finalizado"));
                tarefa.setIdSprint(rs.getLong("idSprint"));
                tarefa.setIdPessoa(rs.getLong("idPessoa"));

                // popula a data de finalizacao da tarefa, fazendo a conversao
                Date data = rs.getDate("dataFinalizacao");
                if (data != null) {
                        Calendar dataFinalizacao = Calendar.getInstance();
                        dataFinalizacao.setTime(data);
                        tarefa.setDataFinalizacao(dataFinalizacao);
                }
                return tarefa;
        }

        public void remove(Tarefa tarefa) {

                if (tarefa.getIdTarefa() == null) {
                        throw new IllegalStateException("Id da tarefa não deve ser nula.");
                }

                String sql = "delete from tarefa where idTarefa = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setLong(1, tarefa.getIdTarefa());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public void altera(Tarefa tarefa) {
                String sql = "update tarefa set descricao = ?, finalizado = ?, dataFinalizacao = ?, idSprint = ?, idPessoa = ? where idTarefa = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, tarefa.getDescricao());
                        stmt.setBoolean(2, tarefa.isFinalizado());
                        stmt.setDate(3, tarefa.getDataFinalizacao() != null ? new Date(
                                tarefa.getDataFinalizacao().getTimeInMillis()) : null);
                        stmt.setLong(4, tarefa.getIdSprint());
                        stmt.setLong(5, tarefa.getIdPessoa());
                        stmt.setLong(6, tarefa.getIdTarefa());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Tarefa buscaPorId(Long idTarefa) {

                if (idTarefa == null) {
                        throw new IllegalStateException("Id da tarefa não deve ser nula.");
                }

                try {
                        PreparedStatement stmt = this.connection
                                .prepareStatement("select * from tarefa where idTarefa = ?");
                        stmt.setLong(1, idTarefa);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                return populaTarefa(rs);
                        }

                        rs.close();
                        stmt.close();

                        return null;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public void finaliza(Long idTarefa) {

                if (idTarefa == null) {
                        throw new IllegalStateException("Id da tarefa nao deve ser nula.");
                }

                String sql = "update tarefa set finalizado = ?, dataFinalizacao = ? where idTarefa = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setBoolean(1, true);
                        stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
                        stmt.setLong(3, idTarefa);
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

}
