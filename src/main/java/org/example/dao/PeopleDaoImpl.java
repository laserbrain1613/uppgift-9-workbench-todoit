package org.example.dao;

import org.example.db.MySQLConnection;
import org.example.exception.MySQLConnectionException;
import org.example.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PeopleDaoImpl implements PeopleDao {

    @Override
    public Person create(Person person) {
        final String CREATE = "INSERT INTO person (first_name, last_name) VALUES (?,?)";
        Person result = new Person();

        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, person.getFirst_Name());
            preparedStatement.setString(2, person.getLast_Name());
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                result = new Person(
                        rs.getInt(1), // auto-incremented value fetched from RETURN_GENERATED_KEYS
                        person.getFirst_Name(),
                        person.getFirst_Name());
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result; // Empty person (rs failed) or whatever rs added to result
    }

    @Override
    public Collection<Person> findAll() {
        final String FIND_ALL = "SELECT * FROM person";
        List<Person> result = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.mysqlConnection();
            Statement statement = connection.createStatement(); // Statement: HK-47 is ready to serve, master.
            ResultSet rs = statement.executeQuery(FIND_ALL); // Query: Can I kill him now, master?

            while (rs.next()) {
                result.add(new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result; // Returns empty arraylist if rs failed
    }

    @Override
    public Person findById(int id) {
        final String FIND_BY_ID = "SELECT * FROM person WHERE person_id = ?";
        Person result = new Person();
        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) { // Only expecting one row because ID is unique
                result = new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<Person> findByName(String name) {
        final String FIND_BY_NAME = "SELECT * FROM person WHERE first_name LIKE ? OR last_name LIKE ?";
        List<Person> result = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                result.add(new Person(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Person update(Person person) {
        final String UPDATE = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";

        if (findById(person.getId()).equals(new Person())) { // (0, null, null)
            throw new IllegalArgumentException("ID does not exist in database");
        }

        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, person.getFirst_Name());
            preparedStatement.setString(2, person.getLast_Name());
            preparedStatement.setInt(3, person.getId());
            preparedStatement.execute();
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return findById(person.getId());
    }

    @Override
    public boolean deleteById(int id) {
        final String DELETE = "DELETE FROM person WHERE person_id = ?";
        boolean result = false;

        if (findById(id).equals(new Person())) { // (0, null, null)
            throw new IllegalArgumentException("ID does not exist in database");
        }

        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() == 1) {
                result = true;
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }


}


