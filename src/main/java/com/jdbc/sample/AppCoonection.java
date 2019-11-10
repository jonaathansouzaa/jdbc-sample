package com.jdbc.sample;

import com.jdbc.sample.connection.JdbcConnection;
import com.jdbc.sample.dao.DAO;
import com.jdbc.sample.dao.PersonDAO;
import com.jdbc.sample.model.Person;

public class AppCoonection {

    public static void main(String[] args) {
        System.out.println("My connection: ".concat(JdbcConnection.getConnection().toString()));

        PersonDAO dao = new PersonDAO();
        dao.findAll().forEach(person -> System.out.println(person.getName()));
    }

}
