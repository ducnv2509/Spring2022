public class Person {
    private final  String name;
    private final  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        if(age <= 0 || age >= 130){
            throw  new IllegalArgumentException("Invalid age: " + age);
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
