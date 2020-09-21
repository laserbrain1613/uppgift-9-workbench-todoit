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
        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO person VALUES (?, ?, ?)");
            preparedStatement.setInt(1, 0); // auto-incremented
            preparedStatement.setString(2, person.getFirst_Name());
            preparedStatement.setString(3, person.getLast_Name());
            preparedStatement.executeUpdate();
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        List<Person> result = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.mysqlConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");

            while (resultSet.next()) {
                result.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Person findById(int id) {
        try {
            Connection connection = MySQLConnection.mysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE person_id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return new Person(); // No match found
    }

    @Override
    public Collection<Person> findByName(String name) {
        return null;
    }

    @Override
    public Person update(Person person) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
