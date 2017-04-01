package gleice.gscrum.dao;

import gleice.gscrum.modelo.Projeto;
import gleice.gscrum.modelo.Sprint;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class SprintDao {

        private Connection connection;

        public SprintDao() throws SQLException {
                this.connection = new ConnectionFactory().getConnection();
        }

        public void adiciona(Sprint sprint) {
                String sql = "insert into sprints (dtInicioSprint, dtFimSprint, productBacklog, estadoSprint, idProjeto) values (?,?,?,?,?)";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setDate(1, new Date(Calendar.getInstance().getTimeInMillis()));
                        stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
                        stmt.setString(3, sprint.getProductBacklog());
                        stmt.setString(4, sprint.getEstadoSprint());
                        stmt.setLong(5, sprint.getProjeto().getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
        
         private Sprint populaSprint(ResultSet rs) throws SQLException {
                Sprint spt = new Sprint();

                // popula o objeto projeto
                spt.setIdSprint(rs.getLong("idSprint"));
                spt.setProductBacklog(rs.getString("productBacklog"));
                spt.setEstadoSprint(rs.getString("estadoSprint"));

                //Pega id do banco
                Long idProjetoBD = rs.getLong("idProjeto");
                
                //monta a sprint
                PreparedStatement stmt = this.connection
                                .prepareStatement("select * from projeto where idProjeto = ?");
                Projeto p = new Projeto();
                p.setIdProjeto(idProjetoBD);
                p.setNomeProjeto("nomeProjeto");
                p.setDescricaoProjeto("descricaoProjeto");
                
                spt.setProjeto(p);
               
                return spt;
        }
         
         public void remove(Sprint spt) {

                if (spt.getIdSprint() == null) {
                        throw new IllegalStateException("Id da tarefa não deve ser nula.");
                }

                String sql = "delete from sprints where idSprint = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setLong(1, spt.getIdSprint());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
        
        public void altera(Sprint spt) {
                String sql = "update sprints set dtInicioSprint = ?, dtFimSprint = ?, productBacklog = ?, estadoSprint = ?, idProjeto = ? where idSprint = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setDate(1, spt.getDtInicioSprint()!= null ? new Date(
                                spt.getDtInicioSprint().getTimeInMillis()) : null);
                        stmt.setDate(2, spt.getDtFimSprint()!= null ? new Date(
                                spt.getDtFimSprint().getTimeInMillis()) : null);
                        stmt.setString(3, spt.getProductBacklog());
                        stmt.setString(4, spt.getEstadoSprint());
                        stmt.setLong(5, spt.getProjeto().getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Sprint buscaPorId(Long idSprint) {

                if (idSprint == null) {
                        throw new IllegalStateException("Id da tarefa não deve ser nula.");
                }

                try {
                        PreparedStatement stmt = this.connection
                                .prepareStatement("select * from sprints where idSprint = ?");
                        stmt.setLong(1, idSprint);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                return populaSprint(rs);
                        }

                        rs.close();
                        stmt.close();

                        return null;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

              

}
