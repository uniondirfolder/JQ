package hw.d10092021.view;

import hw.d10092021.controller.Actions;
import hw.d10092021.model.Task;
import hw.d10092021.utils.DateCalculate;
import hw.d10092021.utils.Transfer;
import hw.d10092021.view.model.Period;
import hw.d10092021.view.model.VCategory;
import hw.d10092021.view.model.VTask;
;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Users implements User {
    private List<VCategory> groups = new ArrayList<>();
    private List<VTask> tasks = new ArrayList<>();
    private List<VTask> colTask = new ArrayList<>();
    private Actions actions;

    public Users(Actions actions) {
        this.actions = actions;
        Transfer.groupsToVCategories(actions.getCategories(), groups);
        Transfer.tasksToVTasks(actions.getTasks(), tasks);
    }

    @Override
    public void buildTask(VTask task) {
        long group_id = groups.get((int) task.getCategory_id() - 1).getId();
        task.setCategory_id(group_id);
        actions.addTask(new Task(task));
        Transfer.tasksToVTasks(actions.getTasks(), tasks);

    }

    @Override
    public void updateTask(VTask task) {
        VTask t = tasks.get((int) (task.getCategory_id()-1));
        t.setDescription(task.getDescription());
        actions.updateTask(new Task(t));
        Transfer.tasksToVTasks(actions.getTasks(), tasks);
    }

    @Override
    public void deleteTask(int count) {
        VTask t = tasks.get(count - 1);
        actions.removeTask(new Task(t));
        Transfer.tasksToVTasks(actions.getTasks(), tasks);
    }

    @Override
    public void showGroup() {
        for (int i = 0; i < groups.size(); i++) {
            System.out.println(String.format("%-2d", (i + 1)) + ") " + groups.get(i));
        }
    }

    @Override
    public void showAll() {
        for (int i = 0; i < tasks.size(); i++) {
            VTask t = tasks.get(i);
            System.out.println(
                    String.format("%-2d", (i + 1)) + ") " + t + " >" + getCategory(t.getCategory_id()));
        }
        System.out.println("add/edit/delete/sort -> -add, -edit , -del, -sort");
        System.out.println("go main -> -main");
    }

    @Override
    public void showSort() {
        System.out.println("""
                1) За сегодня
                2) За вчера
                3) За неделю(текущую)
                4) За месяц(текущую)
                """);
    }

    @Override
    public void showAllInPeriod(Period period) {
        long currentTime = new Date().getTime();
        long currentTimeDay = currentTime -(new Date().getTime()- DateCalculate.getMillisByPattern("yyyy.MM.dd"));
        switch (period) {
            case TODAY -> {
                long finalL = currentTimeDay;
                tasks.stream().filter(f -> f.getDate().getTime() >= finalL).forEach(System.out::println);
            }
            case LAST_DAY -> {
                long r = currentTimeDay - (24 * 60 * 60  * 1000);
                long finalL1 = currentTimeDay;
                tasks.stream().filter(f -> f.getDate().getTime() <= finalL1 && f.getDate().getTime() >= r).forEach(System.out::println);
            }
            case CURRENT_WEEK -> {
                long finalL2 = currentTimeDay - DateCalculate.getMillisByPattern("EEE") * (24 * 60 * 60 * 1000);
                tasks.stream().filter(f -> f.getDate().getTime() >= finalL2).forEach(System.out::println);
            }
            case CURRENT_MONTH -> {
                long finalL3 = currentTimeDay - DateCalculate.getMillisByPattern("d") * (24 * 60 * 60 * 1000);
                tasks.stream().filter(f -> f.getDate().getTime() >= finalL3).forEach(System.out::println);
            }
        }

    }

    @Override
    public void showLevel(int level, int index) {
        switch (level) {
            case 0 -> {
                showGroup();
                System.out.println("show all/exit -> -all , -exit");
            }
            case 1 -> {
                showTasksGroup(index);
            }
            case 4 -> {
                showAll();
            }
            case 5 -> {
                System.out.println("go main -> -main");
            }
        }
    }

    @Override
    public void showTasksGroup(int index) {
        VCategory c = groups.get(index - 1);
        colTask = tasks.stream().filter(x -> x.getCategory_id() == c.getId()).toList();
        System.out.println(c.toString());
        for (int i = 0; i < colTask.size(); i++) {
            System.out.println(String.format("%-2d", (i + 1)) + colTask.get(i).toString());
        }
        System.out.println("go main -> -main");
    }


    private String getCategory(long id) {
        for (VCategory group : groups) {
            if (group.getId() == id) return group.getName();
        }
        return null;
    }
}
