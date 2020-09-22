package org.example.model;

import java.util.Objects;

public class Person {
    private int person_id;
    private String first_Name;
    private String last_Name;

    public Person() {
    }

    public Person(int id, String first_Name, String last_Name) {
        this.person_id = id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + person_id +
                ", first_name='" + first_Name + '\'' +
                ", last_name='" + last_Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return person_id == person.person_id &&
                Objects.equals(first_Name, person.first_Name) &&
                Objects.equals(last_Name, person.last_Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, first_Name, last_Name);
    }

    public int getId() {
        return person_id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
}
