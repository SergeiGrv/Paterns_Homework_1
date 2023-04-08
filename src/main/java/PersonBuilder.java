public class PersonBuilder {
    protected String name;

    protected String surname;

    protected int age = -1;

    protected String city;

    public String getName() {
        return name;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException(
                    "Введите корректный возраст от 0 до 120!"
            );
        }
        this.age = age;
        return this;
    }

    public String getCity() {
        return city;
    }


    public Person build() {
        if (name == null) {
            throw new IllegalStateException(
                    "Введите имя!"
            );

        }

        if (surname == null) {
            throw new IllegalStateException(
                    "Введите фамилию!"
            );
        }
        Person person = age != -1 ? new Person(name, surname, age) : new Person(name, surname);
        if (city != null) {
            person.setCity(city);
        }
        return person;
    }

}
