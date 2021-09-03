package com.nvv.itstep.hw.d06092021_p1;

public class Main {
    public static void main(String[] args) {
        String[] phoneNumbers = {"044 123-1234", "050 123-4567"};
        Address address = new Address("вул. Грушевського 14, кв.101","Київ","21000");
        try {
            Developer developer = new Developer("Іван","Коваленко",address,phoneNumbers);
            Project project = new Project("FaceBook", developer);

            Project c1 = new Project(project);
            c1.setProjectName("Sharaga");
            c1.getDeveloper().setFirstName("Vasya");
            c1.getDeveloper().setLastName("Anykeyshek");
            c1.getDeveloper().getAddress().setCity("Freelance");
            c1.getDeveloper().getAddress().setStreetAddress("WEB");
            c1.getDeveloper().getAddress().setPostalCode("8784");
            c1.getDeveloper().setPhoneNumbers("099 999-9999");

            Project c2 = c1.clone();
            c2.setProjectName("Amazon");
            c2.getDeveloper().setFirstName("Jon");
            c2.getDeveloper().setLastName("Vistas");
            c2.getDeveloper().getAddress().setCity("New York");
            c2.getDeveloper().getAddress().setStreetAddress("Broadway");
            c2.getDeveloper().getAddress().setPostalCode("F5879-965");
            c2.getDeveloper().setPhoneNumbers("088 000-111","033 111-4444");

            Project c3 = c2.getSerializeCopy();
            c3.setProjectName("Oracle");
            c3.getDeveloper().setFirstName("Anna");
            c3.getDeveloper().setLastName("Budz");
            c3.getDeveloper().getAddress().setCity("Japan");
            c3.getDeveloper().getAddress().setStreetAddress("Honagoromalovany 市区町村");
            c3.getDeveloper().getAddress().setPostalCode("郵便番号");
            c3.getDeveloper().setPhoneNumbers("港区六本木６丁目１０−１","D14-20-54789");

            System.out.println(project);
            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);

        } catch (ConstructorException | CloneNotSupportedException e) {
            e.printStackTrace();
        }


    }
}
