package org.example.data;

import org.example.dao.PeopleDaoImpl;
import org.example.dao.TodoItemsImpl;


public class AppManager { // Using this class to manage both implementations from one place

    public PeopleDaoImpl people = new PeopleDaoImpl();
    public TodoItemsImpl todoitems = new TodoItemsImpl();

    public AppManager() {
    }
}
