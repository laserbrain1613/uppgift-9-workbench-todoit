package org.example;

import org.example.dao.PeopleDaoImpl;
import org.example.data.AppManager;
import org.example.model.Person;
import org.example.model.Todo;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AppManager appManager = new AppManager();

//        PeopleDaoImpl peopleDao = new PeopleDaoImpl();
        Person testPerson1 = new Person(80, "Nils", "Karlsson");
        Person testPerson2 = new Person(443, "Karl", "Nilsson");
        Person testPerson3 = new Person(21, "Nils-Karlsson", "Karlsson-Nils");
        Person updatePerson = new Person(3, "¨Katja", "Karlsson");
        Person updatePerson2 = new Person(3, "Pricken", "Kattsson");
        Person addPerson = appManager.people.findById(1);
        Todo todo1 = new Todo(0, "test1", "test description1", LocalDate.now(), false, updatePerson2);
        Todo todo2 = new Todo(0, "test1", "test description1", LocalDate.now(), false, addPerson);
        Todo todo3 = new Todo(0, "test1", "test description1", LocalDate.now(), false, null);

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

        Todo findId1 = appManager.todoitems.findById(25);
        Todo findId2 = appManager.todoitems.findById(26);
        Todo findId3 = appManager.todoitems.findById(27);

        System.out.println(findId1 + "\n" + findId2 + "\n" + findId3);






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
