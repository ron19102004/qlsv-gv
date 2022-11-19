package GK.Sort;

import GK.Person;
import GK.Student;
import GK.Teacher;

import java.util.Comparator;

public class SortByObj implements Comparator<Person> {
    @Override
    public int compare(Person ps1, Person ps2){
        if(ps1 instanceof Teacher && ps2 instanceof Student){
            return -1;
        }
        else if(ps1 instanceof Teacher && ps2 instanceof Teacher)
        {
            if(((Teacher) ps1).getExperience() > ((Teacher) ps2).getExperience()) return 1;
            else return -1;
        } else if (ps1 instanceof Student && ps2 instanceof Student)
        {
            if (((Student) ps1).getAvgScore() > ((Student) ps2).getAvgScore()) return 1;
            else return -1;
        } else return 1;
    }
}
