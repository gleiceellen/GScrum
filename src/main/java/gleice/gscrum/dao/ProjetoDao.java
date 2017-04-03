package gleice.gscrum.dao;

import gleice.gscrum.modelo.Projeto;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjetoDao {

        @Autowired
        private MembroDao daoMembro;
        
        public Long adicionarOuAlterar(Projeto projeto){
                if(projeto.getIdProjeto() == null){
                        return this.adiciona(projeto);
                }else{
                        return this.altera(projeto);
                }
        }

        public Long adiciona(Projeto projeto) {
                String sql = "insert into projeto (nomeProjeto, descricaoProjeto) values (?,?)";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                        stmt.setString(1, projeto.getNomeProjeto());
                        stmt.setString(2, projeto.getDescricaoProjeto());
                        stmt.execute();
                        
                        ResultSet rs = stmt.getGeneratedKeys();
                        if(rs.next()){
                                return rs.getLong(1);
                        }
                        
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
                return null;
        }

        public List<Projeto> getLista() {
                try {
                        List<Projeto> projetos = new ArrayList<Projeto>();
                        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement("select * from projeto");

                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                                // adiciona a Projeto na lista
                                projetos.add(populaProjeto(rs, true));
                        }

                        rs.close();
                        stmt.close();
                        return projetos;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Projeto populaProjeto(ResultSet rs, boolean carregarMembros) throws SQLException {
                Projeto projeto = new Projeto();

                // popula o objeto projeto
                projeto.setIdProjeto(rs.getLong("idProjeto"));
                projeto.setDescricaoProjeto(rs.getString("descricaoProjeto"));
                projeto.setNomeProjeto(rs.getString("nomeProjeto"));
                
                if(carregarMembros){
                        this.daoMembro.popularMembrosNoProjeto(projeto);
                }
                return projeto;
        }

        public void remove(Projeto projeto) {

                if (projeto.getIdProjeto() == null) {
                        throw new IllegalStateException("Id da projeto não deve ser nula.");
                }

                String sql = "delete from projeto where idProjeto = ?";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setLong(1, projeto.getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Long altera(Projeto projeto) {
                String sql = "update projeto set nomeProjeto = ?, descricaoProjeto = ? where idProjeto = ?";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setString(1, projeto.getNomeProjeto());
                        stmt.setString(2, projeto.getDescricaoProjeto());
                        stmt.setLong(3, projeto.getIdProjeto());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
                return projeto.getIdProjeto();
        }

        public Projeto buscaPorId(Long idProjeto, boolean carregarMembros) {
                if (idProjeto == null) {
                        throw new IllegalStateException("Id da projeto não deve ser nula.");
                }

                try {
                        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement("select * from projeto where idProjeto = ?");
                        stmt.setLong(1, idProjeto);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                return populaProjeto(rs, carregarMembros);
                        }

                        rs.close();
                        stmt.close();

                        return null;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

}
