class Student
{ 
    int id;//data member (also instance variable) 
    String name; //data member (also instance variable) 
 
    public static void main(String args[])
    { 
        Student s1=new Student();//creating an object of Student 
        System.out.println(s1.id); 
        System.out.println(s1.name); 

        //zmiana 11
        System.out.println(s1.name); 
        System.out.println(s1.name); 
        System.out.println(s1.name); 
        System.out.println(s1.name); 
        System.out.println(s1.name); 

        //zmiana 21
        System.out.println(s1.id); 
        System.out.println(s1.id); 
        System.out.println(s1.id); 
        System.out.println(s1.id); 
        System.out.println(s1.id); 
        System.out.println(s1.id); 

     } 
} 