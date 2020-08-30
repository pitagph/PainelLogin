/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classe.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import DAO.ConexaoDAO;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Usuário
 */
public class UsuarioDAO {
    
    private final String LOGIN = "SELECT login, senha "
            + "FROM conta WHERE login = ? "
            + "AND senha = ?";
    
    public Usuario login(String login, String senha) {
    Usuario u = new Usuario();
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
    con = new ConexaoDAO().getConnection();
    stmt = (PreparedStatement) con.prepareStatement(LOGIN);
    stmt.setString(1, login);
    stmt.setString(2, senha);
    rs = stmt.executeQuery();
    if(rs.next()) {
    u.setLogin(rs.getString(1));
    u.setSenha(rs.getString(2));
    
    }
    
    } catch (SQLException | ClassNotFoundException | IOException  ex) {    System.out.println(ex);
        } finally{
            try{
                if(con!=null) con.close();
                if(stmt!=null) stmt.close();
                if(rs!=null) rs.close();
            } catch(Exception ex){
                System.out.println("ERROR (Efetuar Login) - Ao fechar a conexão, prepared statement ou result set");
            }
        }
    
    return u;
    }
    
}
