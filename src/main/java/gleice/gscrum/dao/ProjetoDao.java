package gleice.gscrum.dao;

import gleice.gscrum.modelo.Projeto;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDao {

        private final Connection connection;

        public ProjetoDao() throws SQLException {
                this.connection = new ConnectionFactory().getConnection();
        }

        public void adiciona(Projeto projeto) {
                String sql = "insert into projeto (nomeProjeto, descricaoProjeto) values (?,?)";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, projeto.getNomeProjeto());
                        stmt.setString(2, projeto.getDescricaoProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public List<Projeto> getLista() {
                try {
                        List<Projeto> projetos = new ArrayList<Projeto>();
                        PreparedStatement stmt = this.connection
                                .prepareStatement("select * from projeto");

                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                                // adiciona a Projeto na lista
                                projetos.add(populaProjeto(rs));
                        }

                        rs.close();
                        stmt.close();

                        return projetos;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private Projeto populaProjeto(ResultSet rs) throws SQLException {
                Projeto projeto = new Projeto();

                // popula o objeto projeto
                projeto.setIdProjeto(rs.getLong("idProjeto"));
                projeto.setDescricaoProjeto(rs.getString("descricaoProjeto"));
                projeto.setNomeProjeto(rs.getString("nomeProjeto"));

                return projeto;
        }

        public void remove(Projeto projeto) {

                if (projeto.getIdProjeto() == null) {
                        throw new IllegalStateException("Id da projeto não deve ser nula.");
                }

                String sql = "delete from projeto where idProjeto = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setLong(1, projeto.getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public void altera(Projeto projeto) {
                String sql = "update projeto set nomeProjeto = ?, descricaoProjeto = ? where idProjeto = ?";
                PreparedStatement stmt;
                try {
                        stmt = connection.prepareStatement(sql);
                        stmt.setString(1, projeto.getNomeProjeto());
                        stmt.setString(2, projeto.getDescricaoProjeto());
                        stmt.setLong(3, projeto.getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Projeto buscaPorId(Long idProjeto) {

                if (idProjeto == null) {
                        throw new IllegalStateException("Id da projeto não deve ser nula.");
                }

                try {
                        PreparedStatement stmt = this.connection
                                .prepareStatement("select * from projeto where idProjeto = ?");
                        stmt.setLong(1, idProjeto);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                return populaProjeto(rs);
                        }

                        rs.close();
                        stmt.close();

                        return null;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

}
