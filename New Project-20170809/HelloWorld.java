class Person{
    String name;
    int age;
    
    public Person(){
        this.name="Default";
        this.age = 50;
    }
    
    public Person(String name){
        this.name = name+"Clone";
        this.age = 100;
    }
    
    void introduce(){
        System.out.println("Person:intro----My name is :"+name+" age= "+age);
    }
    
    String getName(){
        return this.name;
    }
    
    void wantSomeBody(Person pr){
        System.out.println("Person:wantSomeBody");
        pr.introduce();
        System.out.println("Person:wantSomeBody-- acceess attr ---My name is :"+name+" age= "+age);
    }
}

class Student extends Person{
    String name;
    String address;
    
    public Student(String name, String addr, int age){
        this.name = name;
        this.age = age;
        this.address = addr;
        super.name = "Person";
    }
    
    void introduce(){
        System.out.println("Student:intro ----My name is :"+name+" age= "+age + " addr= "+address);        
    }
    
    String getName(){
        return this.name;
    }
    
    void wantSomeBody(Student st){
        System.out.println("Student:wantSomeBody");        
        st.introduce();
        System.out.println("Student:wantSomeBody-- access attr ---My name is :"+name+" age= "+age + " addr= "+address);   
    }
}

public class HelloWorld{

    static Student functionTestStudent(Student st){
        st.introduce();
        Student cloneStudent = new Student(st.name, st.address, st.age);
        return cloneStudent;
    }
    
    static Person functionTestStudent(Person pr){
        pr.introduce();
        Person clonePerson = new Person(pr.name);
        return clonePerson;
    }
    
    
    public static void main(String []args){
        Student t = new Student("Student","Taipei",20);
        Person p = t;
        System.out.println("----"); 
        t.introduce();
        System.out.println("----"); 
        p.introduce();
        System.out.println("----"); 
        System.out.println(t.name+","+p.name); 
        System.out.println("----"); 
        System.out.println(t.getName()+","+p.getName()); 
        System.out.println("----p.wantSomeBody(p)"); 
        p.wantSomeBody(p);
        System.out.println("----p.wantSomeBody(t)"); 
        p.wantSomeBody(t);
        System.out.println("----t.wantSomeBody(t)");
        t.wantSomeBody(t);
        System.out.println("----t.wantSomeBody(p)"); 
        t.wantSomeBody(p);
        System.out.println("----st1=functionTestStudent(t), st1.name"); 
        Student st1 = functionTestStudent(t);
        System.out.println(st1.name); 
        System.out.println("----pr1 = functionTestStudent(t);pr1.name"); 
        Person pr1 = functionTestStudent(t);
        System.out.println(pr1.name); 
        System.out.println("----pr2 = functionTestStudent(p);pr2.name"); 
        //Student st2 = functionTestStudent(p);
        Person pr2 = functionTestStudent(p);
        System.out.println(pr2.name); 
        
        
     }
}