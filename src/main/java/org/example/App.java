package org.example;

import org.example.dao.PeopleDaoImpl;
import org.example.model.Person;

public class App {
    public static void main(String[] args) {

        PeopleDaoImpl peopleDao = new PeopleDaoImpl();
        Person testPerson1 = new Person(80, "Nils", "Karlsson");
        Person testPerson2 = new Person(443, "Karl", "Nilsson");
        Person testPerson3 = new Person(21, "Nils-Karlsson", "Karlsson-Nils");
        Person updatePerson = new Person(3, "¨Katja", "Karlsson");
        Person updatePerson2 = new Person(3, "Pricken", "Kattsson");

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
