package GK.Sort;

import GK.Person;

import java.util.Comparator;

public class SortByAgeIncreate implements Comparator<Person> {
    @Override
    public int compare(Person ps1, Person ps2)
    {
        if(ps1.getAge() > ps2.getAge()) return 1;
        else return -1;
    }
}
