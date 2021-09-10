package hw.d10092021.view;

import hw.d10092021.view.model.Period;
import hw.d10092021.view.model.VTask;

public interface User {
    void buildTask(VTask task);
    void updateTask(VTask task);
    void deleteTask(int index);
    void showGroup();
    void showAll();
    void showSort();
    void showAllInPeriod(Period period);
    void showLevel(int level, int index);
    void showTasksGroup(int index);
}
