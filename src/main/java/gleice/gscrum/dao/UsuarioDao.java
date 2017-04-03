package gleice.gscrum.dao;

import gleice.gscrum.modelo.Usuario;
import gleice.gscrum.util.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;
@Repository
public class UsuarioDao {

    public boolean existeUsuario(Usuario usuario) {

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não deve ser nulo");
        }

        try {
            PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement("select * from usuarios where login = ? and senha = ?");
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getSenha());
            ResultSet rs = stmt.executeQuery();

            boolean encontrado = rs.next();
            rs.close();
            stmt.close();

            return encontrado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
