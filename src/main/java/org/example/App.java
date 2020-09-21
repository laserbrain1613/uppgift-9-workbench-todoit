package org.example;

import org.example.dao.PeopleDaoImpl;
import org.example.model.Person;

public class App
{
    public static void main( String[] args ) {

        PeopleDaoImpl peopleDao = new PeopleDaoImpl();
        Person testPerson1 = new Person(80, "Nils", "Karlsson");
        Person testPerson2 = new Person(443, "Karl", "Nilsson");
        Person testPerson3 = new Person(21, "Nils-Karlsson", "Karlsson-Nils");

        //Testing create
        peopleDao.create(testPerson1);
        peopleDao.create(testPerson2);
        peopleDao.create(testPerson3);

        //Testing findAll
        peopleDao.findAll().forEach(System.out::println);

        //Testing findById
        System.out.println(peopleDao.findById(1));
        System.out.println(peopleDao.findById(2));
        System.out.println(peopleDao.findById(3));


    }

}
