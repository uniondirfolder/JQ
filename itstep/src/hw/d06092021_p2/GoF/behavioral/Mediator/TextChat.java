package hw.d06092021_p2.GoF.behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

public class TextChat implements Chat {
    private User admin;
    private List<User> users = new ArrayList<>();
    
    public void setAdmin(User admin) {
        this.admin = admin;
    }
    
    public void addUserToChat(User user) {
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for (User u : users) {
            if (u != user) {
                u.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}
