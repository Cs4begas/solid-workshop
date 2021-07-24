public class DemoLSP {
    public static void main(String[] args) {
        PersonGroup1 personGroup1 = new PersonGroup1(1, "A");
    }
}
//แบบนี้ไม่ Composition แบบ Inheritance
    class PersonGroup1 extends Person {

        public PersonGroup1(int id, String name, int group_id) {
            super(id, name, group_id);
        }
        public PersonGroup1(int id, String name {
            super(id, name, 1);
        }
    }
class Person{
    int id;
    String name;
    int group_id;

    public Person(int id, String name, int group_id) {
        this.id = id;
        this.name = name;
        this.group_id = group_id;
    }
}