package gleice.gscrum.dao;

import gleice.gscrum.modelo.Sprint;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SprintDao {

        @Autowired
        private ProjetoDao daoProjeto;

        public void adicionarOuAlterar(Sprint sprint) {
                if (sprint.getIdSprint() == null) {
                        this.adiciona(sprint);
                } else {
                        this.altera(sprint);
                }
        }

        private void adiciona(Sprint sprint) {
                String sql = "insert into sprints (dtInicioSprint, dtFimSprint, productBacklog, estadoSprint, idProjeto) values (?,?,?,?,?)";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setDate(1, new Date(sprint.getDtInicioSprint().getTimeInMillis()));
                        stmt.setDate(2, new Date(sprint.getDtFimSprint().getTimeInMillis()));
                        stmt.setString(3, sprint.getProductBacklog());
                        stmt.setString(4, sprint.getEstadoSprint());
                        stmt.setLong(5, sprint.getProjeto().getIdProjeto());
                        stmt.execute();

                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public List<Sprint> getLista() {
                try {
                        List<Sprint> sprints = new ArrayList<Sprint>();
                        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement("select * from sprints");

                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                                // adiciona a  na lista
                                sprints.add(populaSprint(rs));
                        }

                        rs.close();
                        stmt.close();

                        return sprints;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Sprint populaSprint(ResultSet rs) throws SQLException {
                Sprint spt = new Sprint();

                java.sql.Date dtIniSQL = rs.getDate("dtInicioSprint");
                if(dtIniSQL!=null){
                        Calendar dtInicio = new GregorianCalendar();
                        dtInicio.setTimeInMillis(dtIniSQL.getTime());
                        spt.setDtInicioSprint(dtInicio);
                }
                
                java.sql.Date dtFimSQL = rs.getDate("DtFimSprint");
                if(dtFimSQL!=null){
                        Calendar dtFim = new GregorianCalendar();
                        dtFim.setTimeInMillis(dtFimSQL.getTime());
                        spt.setDtFimSprint(dtFim);
                }
                
                // popula o objeto projeto
                spt.setIdSprint(rs.getLong("idSprint"));
                spt.setProductBacklog(rs.getString("productBacklog"));
                spt.setEstadoSprint(rs.getString("estadoSprint"));
                spt.setProjeto(daoProjeto.buscaPorId(rs.getLong("idProjeto"), false));
                
                return spt;
        }

        public void remove(Sprint spt) {

                if (spt.getIdSprint() == null) {
                        throw new IllegalStateException("Id da tarefa não deve ser nula.");
                }

                String sql = "delete from sprints where idSprint = ?";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setLong(1, spt.getIdSprint());
                        stmt.execute();

                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private void altera(Sprint spt) {
                String sql = "update sprints set dtInicioSprint = ?, dtFimSprint = ?, productBacklog = ?, estadoSprint = ?, idProjeto = ? where idSprint = ?";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setDate(1, spt.getDtInicioSprint() != null ? new Date(
                                spt.getDtInicioSprint().getTimeInMillis()) : null);
                        stmt.setDate(2, spt.getDtFimSprint() != null ? new Date(
                                spt.getDtFimSprint().getTimeInMillis()) : null);
                        stmt.setString(3, spt.getProductBacklog());
                        stmt.setString(4, spt.getEstadoSprint());
                        stmt.setLong(5, spt.getProjeto().getIdProjeto());
                        stmt.execute();

                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Sprint buscaPorId(Long idSprint) {

                if (idSprint == null) {
                        throw new IllegalStateException("Id da tarefa não deve ser nula.");
                }

                try {
                        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement("select * from sprints where idSprint = ?");
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
