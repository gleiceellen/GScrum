package gleice.gscrum.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gleice.gscrum.modelo.Pessoa;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PessoaDao {

        @Autowired
        private DataSource datasource;
        
        public void adicionarOuAlterar(Pessoa pessoa){
                if(pessoa.getIdPessoa() == null){
                        this.adiciona(pessoa);
                }else{
                        this.altera(pessoa);
                }
        }

        private void adiciona(Pessoa pessoa) {
                String sql = "insert into pessoa (nomePessoa, emailPessoa, telefonePessoa, qualificacaoPessoa) values (?,?,?,?)";
                PreparedStatement stmt;
                try {
                        stmt = this.datasource.getConnection().prepareStatement(sql);
                        stmt.setString(1, pessoa.getNomePessoa());
                        stmt.setString(2, pessoa.getEmailPessoa());
                        stmt.setString(3, pessoa.getTelefonePessoa());
                        stmt.setString(4, pessoa.getQualificacaoPessoa());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public List<Pessoa> getLista() {
                try {
                        List<Pessoa> pessoas = new ArrayList<>();
                        PreparedStatement stmt = this.datasource.getConnection().prepareStatement("select * from pessoa");

                        ResultSet rs = stmt.executeQuery();

                        while (rs.next()) {
                                // adiciona a pessoa na lista
                                pessoas.add(populaPessoa(rs));
                        }

                        rs.close();
                        stmt.close();

                        return pessoas;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Pessoa populaPessoa(ResultSet rs) throws SQLException {
                Pessoa pessoa = new Pessoa();

                // popula o objeto pessoa
                pessoa.setIdPessoa(rs.getLong("idPessoa"));
                pessoa.setNomePessoa(rs.getString("nomePessoa"));
                pessoa.setEmailPessoa(rs.getString("emailPessoa"));
                pessoa.setTelefonePessoa(rs.getString("telefonePessoa"));
                pessoa.setQualificacaoPessoa(rs.getString("qualificacaoPessoa"));

                return pessoa;
        }

        public Pessoa buscaPorId(Long idPessoa) {

                if (idPessoa == null) {
                        throw new IllegalStateException("Id da pessoa nao deve ser nulo.");
                }

                try {
                        PreparedStatement stmt = this.datasource.getConnection().prepareStatement("select * from pessoa where idPessoa = ?");
                        stmt.setLong(1, idPessoa);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                                return populaPessoa(rs);
                        }

                        rs.close();
                        stmt.close();

                        return null;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        public Pessoa buscaPorNome(String nomePessoa) {

                List<Pessoa> pessoasPorNome = this.getLista();
                Long id = (long) 0;

                for (Pessoa p : pessoasPorNome) {
                        if (nomePessoa.equals(p.getNomePessoa())) {
                                id = p.getIdPessoa();
                        }

                }
                Pessoa pessoa = buscaPorId(id);
                return pessoa;

        }

        public void remove(Pessoa pessoa) {

                if (pessoa.getIdPessoa() == null) {
                        throw new IllegalStateException("Pessoa nao existe, o id esta nulo!");
                }

                String sql = "delete from pessoa where idPessoa = ?";
                PreparedStatement stmt;
                try {
                        stmt = this.datasource.getConnection().prepareStatement(sql);
                        stmt.setLong(1, pessoa.getIdPessoa());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

        private void altera(Pessoa pessoa) {
                String sql = "update pessoa set nomePessoa = ?, telefonePessoa = ?, emailPessoa = ?, qualificacaoPessoa = ? where idPessoa = ?";
                PreparedStatement stmt;
                try {
                        stmt = this.datasource.getConnection().prepareStatement(sql);
                        stmt.setString(1, pessoa.getNomePessoa());
                        stmt.setString(2, pessoa.getTelefonePessoa());
                        stmt.setString(3, pessoa.getEmailPessoa());
                        stmt.setString(4, pessoa.getQualificacaoPessoa());
                        stmt.setLong(5, pessoa.getIdPessoa());
                        stmt.execute();
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }
}
