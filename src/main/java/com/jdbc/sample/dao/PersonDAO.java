package com.jdbc.sample.dao;

import com.jdbc.sample.connection.JdbcConnection;
import com.jdbc.sample.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE person SET name = ?, cpf = ? WHERE person_id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getCpf());
            preparedStatement.setLong(3, entity.getPersonId());

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
    public void delete(Person entity) {
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM person WHERE person_id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getPersonId());

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
    public Person findById(Long entityId) {
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM person WHERE person_id = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, entityId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Person person = new Person();
                person.setPersonId(resultSet.getLong("person_id"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));
                return person;
            }

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
        return null;
    }

    @Override
    public List<Person> findAll() {
        Connection conn = JdbcConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM person";
            preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Person> personList = new ArrayList<Person>();
            while(resultSet.next()) {
                Person person = new Person();
                person.setPersonId(resultSet.getLong("person_id"));
                person.setName(resultSet.getString("name"));
                person.setCpf(resultSet.getString("cpf"));
                personList.add(person);
            }
            return personList;
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
        return null;
    }

}
