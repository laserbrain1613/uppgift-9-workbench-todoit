package org.example;

import org.example.data.AppManager;
import org.example.model.Person;
import org.example.model.Todo;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        AppManager appManager = new AppManager();

        Person testPerson1 = new Person(80, "Nils", "Karlsson");
        Person testPerson2 = new Person(443, "Karl", "Nilsson");
        Person testPerson3 = new Person(5, "Nils-Karlsson", "Karlsson-Nils");
        Person updatePerson = new Person(3, "¨Katja", "Karlsson");
        Person updatePerson2 = new Person(3, "Pricken", "Kattsson");
        Person addPerson = appManager.people.findById(1);
        Todo todo1 = new Todo(0, "test1", "test description1", LocalDate.now(), false, updatePerson2);
        Todo todo2 = new Todo(0, "test1", "test description1", LocalDate.now(), false, addPerson);
        Todo todo3 = new Todo(10, "test2", "test description2", LocalDate.now(), false, testPerson3);
        Todo updateTodo = new Todo(21, "update", "update description1", LocalDate.now(), true, testPerson3);

//        Person addPerson = appManager.people.findById(1);
//        Todo createTodo = appManager.todoitems.create(todo2);
//        System.out.println(createTodo);
//
//        Todo createTodo2 = appManager.todoitems.create(todo3);
//        System.out.println(createTodo2);
//        Collection<Todo> stuff = appManager.todoitems.findAll();
//        stuff.forEach(System.out::println);
//
//        8, 21, 22

//        Todo findId1 = appManager.todoitems.findById(25);
//        Todo findId2 = appManager.todoitems.findById(26);
//        Todo findId3 = appManager.todoitems.findById(27);
//
//        System.out.println(findId1 + "\n" + findId2 + "\n" + findId3);
//        Collection<Todo> unassignedTodoItems = appManager.todoitems.findByUnassignedTodoItems();
//        unassignedTodoItems.forEach(System.out::println);

//        Todo update = appManager.todoitems.update(updateTodo);
//        System.out.println(update);

//        boolean result = appManager.todoitems.deleteById(22);
//        boolean result2 = appManager.todoitems.deleteById(25);
//        boolean result3 = appManager.todoitems.deleteById(500);
//        System.out.println(result + "\n" + result2 + "\n" + result3);

//        appManager.people.findAll().forEach(System.out::println);

//        System.out.println(appManager.todoitems.create(todo1));
//        System.out.println(appManager.todoitems.create(todo2));
//        System.out.println(appManager.todoitems.create(todo3));
//        appManager.todoitems.findAll().forEach(System.out::println);


//        System.out.println(appManager.people.findById(1));

//        Person returnPerson = appManager.people.findById(5000);
//        System.out.println(returnPerson);

//        appManager.people.findById(1);


//        System.out.println(appManager.people.findById(5000));


//        //Testing create
//        peopleDao.create(testPerson1);
//        peopleDao.create(testPerson2);
//        peopleDao.create(testPerson3);

//        //Testing findAll
//        peopleDao.findAll().forEach(System.out::println);
//
//        //Testing findById
//        System.out.println(peopleDao.findById(1));
//        System.out.println(peopleDao.findById(2));
//        System.out.println(peopleDao.findById(5));

//        System.out.println(peopleDao.update(updatePerson));
//        peopleDao.update((updatePerson));

//        peopleDao.findAll().forEach(System.out::println);

//        System.out.println(peopleDao.update(updatePerson2));
//        System.out.println(peopleDao.deleteById(20));

//        Person blank = new Person();
//        System.out.println(blank);

    }

}
