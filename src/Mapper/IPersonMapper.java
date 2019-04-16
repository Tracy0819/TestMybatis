package Mapper;

import domain.Person;

import java.util.List;

public interface IPersonMapper {


    Person selectByName(String name);

    void insert(Person person);

    void updateByName(Person person);

    void deleteByName(String xxx);

    List<Person> selectAll();

}
