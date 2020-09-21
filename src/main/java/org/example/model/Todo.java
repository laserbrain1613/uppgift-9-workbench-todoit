package org.example.model;

import java.util.Date;
import java.util.Objects;

public class Todo {
    private int todo_Id;
    private String title;
    private String description;
    private Date deadline;
    private boolean done;
    private int assignee_Id;

    public Todo() {
    }

    public Todo(String title, String description, Date deadline, boolean done, int assignee_Id) {
        this.todo_Id = todo_Id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee_Id = assignee_Id;
    }

    public int getTodo_Id() {
        return todo_Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getAssignee_Id() {
        return assignee_Id;
    }

    public void setAssignee_Id(int assignee_Id) {
        this.assignee_Id = assignee_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return todo_Id == todo.todo_Id &&
                done == todo.done &&
                assignee_Id == todo.assignee_Id &&
                Objects.equals(title, todo.title) &&
                Objects.equals(description, todo.description) &&
                Objects.equals(deadline, todo.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_Id, title, description, deadline, done, assignee_Id);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todo_Id=" + todo_Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assignee_Id=" + assignee_Id +
                '}';
    }
}
