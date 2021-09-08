package hw.d06092021_p2.GoF.creational.Builder.builder;

import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        PersonSimpleInner parent = new PersonSimpleInner.Builder().withName("Natalia").build();
        Set<PersonSimpleInner> parents = new HashSet<>();
        parents.add(parent);
        PersonSimpleInner person = new PersonSimpleInner.Builder()
                .withName("Ihar")
                .withSurname("Lipko")
                .withAge(44)
                .withWeight(80)
                .withParents(parents)
                .build();
        System.out.println(person);
        BankAccountInner bankAccount =
                new BankAccountInner.AccountBuilder("New Account", "100214003")
                        .withEmail("ihar@mail.com")
                        .withStatus(true).build();
        System.out.println(bankAccount);
    }
}
