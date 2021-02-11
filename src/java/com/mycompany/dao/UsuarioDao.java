/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.factory.UserFactory;
import com.mycompany.models.Administrator;
import com.mycompany.models.Student;
import com.mycompany.models.Usuario;
import com.mycompany.singleton.DBAccess;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author centti
 */
public class UsuarioDao implements Dao<Usuario> {

    public Usuario login(String email, String password) {
        Usuario user = new Usuario();
        String pa = "{call login(?,?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setString(1, email);
                cs.setString(2, password);
                System.out.println(email + " " + password);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    user.setIdUser(rs.getInt("id"));
                    System.out.println("respuesta" + rs.getInt("id"));
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    user.setDni(rs.getInt("dni"));
                    user.setDireccion(rs.getString("direccion"));
                    user.setTipo_cuenta(rs.getString("tipo_cuenta"));

                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return user;
    }

    public Integer getEmpleado(Integer id_usuario) {
        Integer id_empleado = 0;
        String pa = "{call getStudentUser(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id_usuario);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    id_empleado = rs.getInt("id");

                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
            
        }
        return id_empleado;

    }

    @Override
    public void save(Usuario t
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario t
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario get(Integer id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> getAll() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String pa = "{CALL getAllUser()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setIdUser(rs.getInt("id"));
                    user.setFirstname(rs.getString("firstname"));
                    user.setLastname(rs.getString("lastname"));
                    user.setEmail(rs.getString("email"));
                    user.setDni(rs.getInt("dni"));
                    user.setDireccion(rs.getString("direccion"));
                    user.setTipo_cuenta(rs.getString("tipo_cuenta"));
                    lista.add(user);

                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return lista;
    }

    @Override
    public void delete(Integer id
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
