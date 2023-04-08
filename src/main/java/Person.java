import java.util.OptionalInt;

public class Person {
    protected String name;

    protected String surname;

    protected int age = -1;

    protected String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean hasAge() {
        return age != -1;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.of(age) : OptionalInt.empty();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean hasCity() {
        return city != null;
    }


    public void happyBirthday() {
        if (hasAge() && getAge().isPresent()) {
            age = getAge().getAsInt() + 1;
        } else {
            System.out.println("Возраст не известен!");
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + ", " + getAge().getAsInt() + ", " + this.city;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.surname = getSurname();
        personBuilder.age = 11;
        personBuilder.city = getCity();

        return personBuilder;
    }
}
