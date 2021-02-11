/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.factory.UserFactory;

import com.mycompany.models.Student;
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
public class StudentDao implements Dao<Student> {

    UserFactory uf = new UserFactory();

    @Override
    public Student get(Integer id) {
        Student employee = (Student) uf.createUser("STUDENT");
        String pa = "{call getStudent(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    employee.setIdEmployee(rs.getInt("id"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
                    employee.setPassword(rs.getString("password"));
                    employee.setEmail(rs.getString("email"));
                    employee.setAge(rs.getInt("age"));
                    employee.setGenre(rs.getString("genre"));
                    employee.setHealthCondition(rs.getString("healthCondition"));
                    employee.setDni(rs.getInt("dni"));
                    employee.setDireccion(rs.getString("direccion"));
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return employee;
    }

    @Override
    public List<Student> getAll() {
        ArrayList<Student> lista = new ArrayList<>();
        String pa = "{CALL getAllStudents()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Student employee = (Student) uf.createUser("EMPLOYEE");
                    System.out.println(rs.getInt("id"));
                    employee.setIdEmployee(rs.getInt("id"));
                    employee.setFirstname(rs.getString("firstname"));
                    employee.setLastname(rs.getString("lastname"));
                    employee.setPassword(rs.getString("password"));
                    employee.setEmail(rs.getString("email"));
                    employee.setDni(rs.getInt("dni"));
                    employee.setDireccion(rs.getString("direccion"));
                    lista.add(employee);
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
    public void save(Student t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call saveStudent(?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setString(1, t.getFirstname());
                cs.setString(2, t.getLastname());
                cs.setString(3, t.getPassword());
                cs.setString(4, t.getEmail());
                cs.setString(5, String.valueOf(t.getDni()));
                cs.setString(6, t.getDireccion());
                cs.executeUpdate();
            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void update(Student t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{Call updateStudent(?,?,?,?,?,?,?,?,?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, t.getIdEmployee());
                cs.setString(2, t.getFirstname());
                cs.setString(3, t.getLastname());
                cs.setString(4, t.getPassword());
                cs.setString(5, t.getEmail());
                cs.setInt(6, t.getAge());
                cs.setString(7, t.getGenre());
                cs.setString(8, t.getHealthCondition());
                cs.setString(9, String.valueOf(t.getDni()));
                cs.setString(10, t.getDireccion());
                cs.executeUpdate();
            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call deleteStudent(?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                cs.executeUpdate();

            } catch (SQLException e) {

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
