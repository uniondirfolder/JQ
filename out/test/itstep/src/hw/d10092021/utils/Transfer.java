package hw.d10092021.utils;

import hw.d10092021.model.Group;
import hw.d10092021.model.Task;
import hw.d10092021.view.model.VCategory;
import hw.d10092021.view.model.VTask;

import java.util.List;

public class Transfer {
    public static void tasksToVTasks(final List<Task> from, final List<VTask> to) {
        if (to.size() > 0) to.clear();
        if (from != null) {
            for (Task task : from) {
                to.add(new VTask(task.getId(), task.getCreatedDate(), task.getDescription(), task.getGroup_id()));
            }
            from.clear();
        }
    }

    public static void groupsToVCategories(final List<Group> from, final List<VCategory> to) {
        if (to.size() > 0) to.clear();
        if (from != null) {
            for (Group group : from) {
                to.add(new VCategory(group.getId(), group.getName()));
            }
            from.clear();
        }
    }
}
