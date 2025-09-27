class student{
    double rollno;
    String name;
    String course;
    student(double r,String n,String c){
        rollno=r;
        name=n;
        course=c;
        
    }
}
class marks extends student {
    int sub1,sub2,sub3;
    public marks(double rollNo, String name, String course, int sub1, int sub2, int sub3) {
        super(rollNo, name, course);
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;

    }
}
class result extends marks{
    int total_marks ;
    float percentage;
    String grade;
    public result(double rollno, String name,String course,int sub1,int sub2,int sub3){
        super(rollno,name,course,sub1,sub2,sub3);
        calculate();
    }
    void calculate(){
        total_marks=sub1+sub2+sub3;
        percentage=total_marks/3.0f;
        if(percentage>=90){
            grade="A";
        }
        else if(percentage<=89 && percentage >=75){
            grade="B";
        }
        else if(percentage<=74 && percentage >=45){
            grade="B+";
        }
        else{
            grade="c+";
        }
    }
    public void displayInfo(){
        System.out.println("Roll No: "+rollno);
        System.out.println("Name: "+name);
        System.out.println("Course: "+course);
        System.out.println("Subject 1: "+sub1);
        System.out.println("Subject 2: "+sub2);
        System.out.println("Subject 3: "+sub3);
        System.out.println("Total Marks: "+total_marks);
        System.out.println("Percentage: "+percentage);
        System.out.println("Grade: "+grade);
    }
}
public class student_inheritance_lab{
    public static void main(String[] args) {
        result r=new result(101.0,"Alice","BSc",99,99,95);
        r.displayInfo();
    }
    
}