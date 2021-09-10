package hw.d10092021.view;

import hw.d10092021.controller.Actions;
import hw.d10092021.model.Task;
import hw.d10092021.sql.exeptions.SQLExceptionFieldLength;
import hw.d10092021.sql.exeptions.SQLExceptionForeignKey;
import hw.d10092021.utils.Transfer;
import hw.d10092021.view.model.Period;
import hw.d10092021.view.model.VCategory;
import hw.d10092021.view.model.VTask;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
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
    public void buildTask(int index, VTask task) {

        try {
            actions.addTask(new Task(task.getDescription(), task.getDate(), groups.get(index).getId()));
        } catch (SQLExceptionFieldLength e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLExceptionForeignKey e) {
            e.printStackTrace();
        }
        Transfer.tasksToVTasks(actions.getTasks(), tasks);

    }

    @Override
    public void updateTask(int index, VTask task) {
        try {
            actions.updateTask(new Task(task.getDescription(), task.getDate(), groups.get(index).getId()));
            Transfer.tasksToVTasks(actions.getTasks(), tasks);
        } catch (SQLExceptionFieldLength e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLExceptionForeignKey e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTask(int index) {
        VTask t = tasks.get(index);
        try {
            actions.removeTask(new Task(t.getDescription(), t.getDate(), t.getCategory_id()));
            Transfer.tasksToVTasks(actions.getTasks(), tasks);
        } catch (SQLExceptionFieldLength sqlExceptionFieldLength) {
            sqlExceptionFieldLength.printStackTrace();
        } catch (SQLExceptionForeignKey sqlExceptionForeignKey) {
            sqlExceptionForeignKey.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tasks.remove(index);
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
                    String.format("%-2d", (i + 1)) +
                            String.format("%-2s", getCategory(t.getCategory_id()))+ " " + t);
        }
        System.out.println("add/edit/delete -> -add, -edit , -del");
        System.out.println("go main -> -main");
    }

    @Override
    public void showAllInPeriod(Period period) {
        LocalDateTime now = LocalDateTime.now();
        int dow = now.getDayOfWeek().getValue();
        int dom = now.getDayOfMonth();
        int cmo = now.getMonth().getValue();
        int cy = now.getYear();
        int ch = now.getHour();
        int cmi = now.getMinute();
        int csec = now.getSecond();

        switch (period) {
            case TODAY -> {
                long l = LocalDateTime.of(cy, dom - 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
                tasks.stream().filter(f -> f.getDate().getTime() >= l).forEach(System.out::println);
            }
            case LAST_DAY -> {
                long l = LocalDateTime.of(cy, dom - 1, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
                long r = LocalDateTime.of(cy, dom - 2, 0, 0, 0).toEpochSecond(ZoneOffset.UTC);
                tasks.stream().filter(f -> f.getDate().getTime() <= l && f.getDate().getTime() >= r).forEach(System.out::println);
            }
            case CURRENT_WEEK -> {
                int o = 0;
            }
            case CURRENT_MONTH -> {
                int p = 0;
            }
        }

    }

    @Override
    public void showLevel(int level, int index) {
        switch (level) {
            case 0 -> {
                showGroup();
                System.out.println("show all -> -all");
            }
            case 1 -> {
                showTasksGroup(index);
            }
            case 4 -> {
                showAll();
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
        System.out.println("add/edit/delete -> -add, -edit , -del");
        System.out.println("go main -> -main");
    }


    private String getCategory(long id) {
        return groups.stream().filter(x -> x.getId() == id).findFirst().get().toString();
    }
}
