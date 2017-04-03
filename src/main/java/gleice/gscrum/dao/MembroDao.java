package gleice.gscrum.dao;

import gleice.gscrum.modelo.Membro;
import gleice.gscrum.modelo.Projeto;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MembroDao {

        @Autowired
        private PessoaDao daoPessoa;
        
        @Autowired
        private ProjetoDao daoProjeto;
        
        public void adicionarOuAlterar(Membro membro){
                if(membro.getIdMembro() == null){
                        this.adiciona(membro);
                }else{
                        this.altera(membro);
                }
        }

        private void adiciona(Membro membro) {
                String sql = "insert into membros (idpessoa, idprojeto) values (?,?)";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setLong(1, membro.getPessoa().getIdPessoa());
                        stmt.setLong(2, membro.getProjeto().getIdProjeto());
                        stmt.execute();
                        
                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public void remove(Membro membro) {
                if (membro.getIdMembro() == null) {
                        throw new IllegalStateException("Membro nao existe, o id esta nulo!");
                }

                String sql = "delete from membros where idMembro = ?";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setLong(1, membro.getIdMembro());
                        stmt.execute();
                        
                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private void altera(Membro membro) {
                String sql = "update membros set idpessoa = ?, idprojeto where idMembro = ?";
                PreparedStatement stmt;
                try {
                        stmt = ConnectionFactory.getConnection().prepareStatement(sql);
                        stmt.setLong(1, membro.getPessoa().getIdPessoa());
                        stmt.setLong(2, membro.getProjeto().getIdProjeto());
                        stmt.setLong(3, membro.getIdMembro());
                        stmt.execute();
                        
                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public void popularMembrosNoProjeto(Projeto projeto) {
                if (projeto == null) {
                        throw new IllegalStateException("Erro ao vincular membro. Projeto não deve ser nulo.");
                }

                try {
                        PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement("select * from membros where idProjeto = ?");
                        stmt.setLong(1, projeto.getIdProjeto());

                        ResultSet rs = stmt.executeQuery();
                        if (rs.next()) {
                                projeto.addMembro( this.populaMembro(rs) );
                        }

                        rs.close();
                        stmt.close();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                
                }
        }

        private Membro populaMembro(ResultSet rs) throws SQLException {
                Membro m = new Membro();
                m.setIdMembro(rs.getLong("idMembro"));
                m.setPessoa( this.daoPessoa.buscaPorId(rs.getLong("idPessoa")) );
                m.setProjeto( this.daoProjeto.buscaPorId(rs.getLong("idProjeto"), false) );
                
                return m;
        }
}
