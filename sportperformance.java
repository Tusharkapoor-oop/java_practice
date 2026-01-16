import java.util.*;
class student{
    long rollno;
    String name;
    public void displayStudentInfo(){
        System.out.println("Roll No: "+rollno+" Name: "+name);
    }
};
class marks extends student {
    int sub1,sub2,sub3;
    public void displayMarks(){
        System.out.println("Subject 1: "+sub1+" Subject 2: "+sub2+" Subject 3: "+sub3);
        System.out.println("Total Marks before adding sports marks: "+(sub1+sub2+sub3));
    }
};
interface sport{
    int sportmarks=20;
    public abstract double displaySportMarks();

    
};
class result extends marks implements sport{ 
    public double displaySportMarks(){
        return sportmarks;
    }
    public void displayResult(){
        displayStudentInfo();
        displayMarks();
        System.out.println("Sport Marks: "+displaySportMarks());
        System.out.println("Overall Total: "+(sub1+sub2+sub3+displaySportMarks()));
        System.out.println("average Total: "+((sub1+sub2+sub3+displaySportMarks())/4));
    }
};
public class sportperformance{
    public static void main(String[] args) {
        result r=new result();
        r.rollno=198;
        r.name="monu";
        r.sub1=95;
        r.sub2=90;
        r.sub3=95;
        r.displayResult();
    }
}