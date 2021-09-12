package hw.d06092021_p2.GoF.behavioral.Mediator;

public class Program {

    public static void main(String[] args) {
        TextChat chat = new TextChat();
        
        User admin = new Admin("Admin", chat);
        User user1 = new SimpleUser("User 1", chat);
        User user2 = new SimpleUser("User 2", chat);
        
        chat.setAdmin(admin);
        chat.addUserToChat(user1);
        chat.addUserToChat(user2);
        
        user1.sendMessage("Hello, I am User 1!");
        System.out.println("-----------------------");
        admin.sendMessage("Admin that. Stop shooting...");
    }
}
