package hw.d06092021_p2.GoF.creational.Builder.builder;

import java.util.Set;

public class PersonSimpleInner {
    private String name;
    private String surname;
    private int age;
    private int weight;
    private Set<PersonSimpleInner> parents;

    private PersonSimpleInner() {}

    public static class Builder {
        private PersonSimpleInner person;

        public Builder() {
            person = new PersonSimpleInner();
        }

        public Builder withName(String name) {
            person.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            person.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            person.age = age;
            return this;
        }

        public Builder withWeight(int weight) {
            person.weight = weight;
            return this;
        }

        public Builder withParents(Set<PersonSimpleInner> parents) {
            person.parents = parents;
            return this;
        }

        PersonSimpleInner build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person: " + name + " " + surname + ", age: " + age + ", weight: " + weight
                + "\nParents: " + parents.iterator().next().name;
    }
}
