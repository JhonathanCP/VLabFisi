/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.models.Course;
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
public class CourseDao implements Dao<Course>{

    @Override
    public Course get(Integer id) {
        Course course = new Course();
        String pa = "{call getCourse(?)}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setInt(1, id);
                ResultSet rs = cs.executeQuery();
                if (rs.next()) {
                    course.setIdCourse(rs.getInt("id"));
                    course.setName(rs.getString("courseName"));
                }
            } catch (SQLException ex) {
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return course;
    }

    @Override
    public List<Course> getAll() {
        ArrayList<Course> lista = new ArrayList<>();
        String pa = "{CALL getAllCourses()}";
        Connection cn = DBAccess.getInstance().getConnection();
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                ResultSet rs = cs.executeQuery();
                while (rs.next()) {
                    Course course = new Course();
                    course.setIdCourse(rs.getInt("id"));
                    course.setName(rs.getString("courseName"));                    
                    lista.add(course);
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
    public void save(Course t) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call saveCourse(?)}";
        if (cn != null) {
            try {
                CallableStatement cs = cn.prepareCall(pa);
                cs.setString(1, t.getName());
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
    public void update(Course t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        Connection cn = DBAccess.getInstance().getConnection();
        String pa = "{call deleteCourse(?)}";
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
