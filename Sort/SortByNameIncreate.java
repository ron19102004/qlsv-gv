package GK.Sort;

import GK.Person;

import java.util.Comparator;

public class SortByNameIncreate implements Comparator<Person> {
    @Override
    public int compare(Person ps1, Person ps2)
    {
        String nameObj1[]=ps1.getName().split("\\s");
        String nameObj2[]=ps2.getName().split("\\s");
        return nameObj1[nameObj1.length-1].compareTo(nameObj2[nameObj2.length-1]);
    }
}
