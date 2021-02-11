/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.models.Simulator;
import com.mycompany.singleton.DBAccess;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author centt
 */
public class SimulatorDao implements Dao<Simulator>{

    @Override
    public Simulator get(Integer id) {
        Simulator simulator = new Simulator();
        String pa = "{call getSimulator(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    simulator.setIdSimulator(rs.getInt("id"));
                    simulator.setActive(rs.getBoolean("active"));
                    simulator.setHtml(rs.getString("html"));
                    simulator.setName(rs.getString("name"));
                    simulator.setDescription(rs.getString("description"));
                    simulator.setIdCourse(rs.getInt("idCourse"));
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return simulator;
    }

    @Override
    public List<Simulator> getAll() {
        ArrayList<Simulator> lista = new ArrayList<>();
        String pa = "{CALL getAllSimulators()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Simulator simulator = new Simulator();
                    simulator.setIdSimulator(rs.getInt("id"));
                    simulator.setActive(rs.getBoolean("active"));
                    simulator.setName(rs.getString("name"));
                    simulator.setHtml(rs.getString("html"));
                    simulator.setDescription(rs.getString("description"));
                    simulator.setIdCourse(rs.getInt("idCourse"));
                    simulator.setCourseName(rs.getString("courseName"));
                    lista.add(simulator);
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

    public List<Simulator> getSimulatorByCourse(Integer idCourse) {
        ArrayList<Simulator> lista = new ArrayList<>();
        String pa = "{CALL getSimulatorByCourse(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, idCourse);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Simulator simulator = new Simulator();
                    simulator.setIdSimulator(rs.getInt("id"));
                    simulator.setActive(rs.getBoolean("active"));
                    simulator.setHtml(rs.getString("html"));
                    simulator.setName(rs.getString("name"));
                    simulator.setDescription(rs.getString("description"));
                    simulator.setIdCourse(rs.getInt("idCourse"));
                    lista.add(simulator);
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
    public void save(Simulator t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{CALL saveSimulator(?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                //cs.setBoolean(1, t.getActive());
                //cs.setString(2, t.getHtml());
                cs.setString(1, t.getName());
                //cs.setString(3, t.getDescription());
                //cs.setInt(5, t.getIdCourse());
                //cs.executeUpdate();
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
    public void update(Simulator t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{Call updateSimulator(?,?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, t.getIdSimulator());
                cs.setBoolean(2, t.getActive());
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
        String pa = "{call deleteSimulator(?)}";
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
