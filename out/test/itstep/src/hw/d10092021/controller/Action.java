package hw.d10092021.controller;

import hw.d10092021.model.Group;
import hw.d10092021.model.Task;
import java.util.List;

public interface Action{
    void createTable();
    void addCategory(Group grp);
    void addTask(Task task);
    void renameGroup(Group grp);
    void updateTask(Task task);
    void removeTask(Task task);
    List<Group> getCategories();
    List<Task> getTasks();
}
