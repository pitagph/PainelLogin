/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.UsuarioDAO;
import classe.Usuario;

/**
 *
 * @author Usuário
 */
public class UsuarioControle {
    
    UsuarioDAO udao = new UsuarioDAO();
    
    public Usuario login(String login, String senha) {
    return udao.login(login, senha);
    }
    
}
