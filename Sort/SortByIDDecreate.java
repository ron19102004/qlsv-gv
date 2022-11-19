package GK.Sort;

import GK.Person;

import java.util.Comparator;

public class SortByIDDecreate implements Comparator<Person> {
    @Override
    public int compare(Person ps1, Person ps2)
    {
        if(ps1.getID() > ps2.getID()){
            return -1;
        } else return 1;
    }
}