package gleice.gscrum.dao;

import gleice.gscrum.modelo.Sprint;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
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
                        stmt.setLong(5, sprint.getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

}
