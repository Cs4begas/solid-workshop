package DemoLSP_Composition;

public class DemoLSP_Composition {
    public static void main(String[] args) {
        PersonGroup1 personGroup1 = new PersonGroup1(1, "A",1);
    }
}
//แบบนี้ Composition ไม่ใช่แบบ Inheritance
class PersonGroup1  {
    Person person;
    int group;
    public PersonGroup1(int id, String name, int group) {
        this.person = new Person(id,name);
        this.group = group;
    }
}
class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}