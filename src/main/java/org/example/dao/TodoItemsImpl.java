package org.example.dao;

import org.example.db.MySQLConnection;
import org.example.exception.MySQLConnectionException;
import org.example.model.Person;
import org.example.model.Todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TodoItemsImpl implements TodoItemsDao {

    PeopleDaoImpl people = new PeopleDaoImpl();

    @Override
    public Todo create(Todo todo) {
        final String CREATE = "INSERT INTO todo_item (title, description, deadline, done, assignee_id) VALUES (?, ?, ?, ?, ?)"; // id is auto-incremented
        Todo result = new Todo();

        try (Connection connection = MySQLConnection.mysqlConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setDate(3, Date.valueOf(todo.getDeadline()));
            preparedStatement.setBoolean(4, todo.isDone());
            if (todo.getAssignee() != null) {
                preparedStatement.setInt(5, 5);
            } else {
                preparedStatement.setNull(5, 5);
            }
            preparedStatement.execute();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                result = new Todo(
                        rs.getInt(1), // auto-incremented value fetched from RETURN_GENERATED_KEYS
                        todo.getTitle(),
                        todo.getDescription(),
                        todo.getDeadline(),
                        todo.isDone(),
                        todo.getAssignee());
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<Todo> findAll() {
        final String FIND_ALL = "SELECT * FROM todo_item";
        List<Todo> result = new ArrayList<>();

        try (Connection connection = MySQLConnection.mysqlConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(FIND_ALL)
        ) {
            while (rs.next()) {
                result.add(new Todo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getBoolean(5),
                        people.findById(rs.getInt(6))));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Todo findById(int id) {
        final String FIND_BY_ID = "SELECT * FROM todo_item WHERE todo_id = ?";
        Todo result = new Todo();
        try (Connection connection = MySQLConnection.mysqlConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                result = new Todo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4).toLocalDate(),
                        rs.getBoolean(5),
                        people.findById(rs.getInt(6)));
            }
        } catch (SQLException | MySQLConnectionException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean status) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(int assignee) {
        return null;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        return null;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        return null;
    }

    @Override
    public Todo update(Todo todo) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}