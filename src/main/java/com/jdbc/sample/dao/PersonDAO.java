package com.jdbc.sample.dao;

import com.jdbc.sample.connection.JdbcConnection;
import com.jdbc.sample.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonDAO implements DAO<Person> {

    @Override
    public void save(Person entity) {
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO person (name, cpf) VALUES (? , ?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getCpf());

            preparedStatement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

    }

    @Override
    public void update(Person entity) {

    }

    @Override
    public void delete(Person entity) {

    }

    @Override
    public Person findById() {
        return null;
    }

    @Override
    public List<Person> findAll() {
        return null;
    }

}
