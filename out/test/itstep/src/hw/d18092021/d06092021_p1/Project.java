package hw.d18092021.d06092021_p1;

import hw.d18092021.json.JsonConstructor;
import hw.d18092021.json.JsonCursor;
import hw.d18092021.json.JsonItem;
import hw.d18092021.json.JsonParse;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

@CopyConstructor
public class Project implements Cloneable, Serializable, Comparable<Project>, JsonParse {
    private String projectName;
    Developer developer;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Project(String projectName, Developer developer) {
        this.projectName = projectName;
        this.developer = developer;
    }

    @CopyConstructor
    public Project(Project that) throws ConstructorException {
        try {
            if (!that.getClass().isAnnotationPresent(CopyConstructor.class)) {
                throw new ConstructorException("Copy constructor not found!");
            }
            this.projectName = that.projectName;
            this.developer = new Developer(that.developer);
        } catch (Exception e) {
            throw new ConstructorException(e.getMessage());
        }

    }

    @JsonConstructor
    private Project(JsonCursor jsonCursor) {
        Class cl = this.getClass();
        Field[] fl = cl.getDeclaredFields();
        int i = -1;

        JsonItem ji = jsonCursor.getWithUnclouded();
        if (ji != null && !jsonCursor.isError() && jsonCursor.getCursor() && jsonCursor.checkFieldRule(ji) && fl[++i].getName().equals(ji.getFieldName())) {
            this.projectName = ji.getValue();

            ji = jsonCursor.getWithUnclouded();
            if (ji != null && !jsonCursor.isError() && jsonCursor.getCursor() && jsonCursor.checkFieldRule(ji) && fl[++i].getName().equals(ji.getFieldName())) {
                if (ji.getValue().equals("object")) {

                    Constructor constructor = null;
                    try {
                        constructor = Developer.class.getDeclaredConstructor(JsonCursor.class);
                        constructor.setAccessible(true);
                        this.developer = (Developer) constructor.newInstance(jsonCursor);
                    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                        jsonCursor.setError(true);
                    }
                } else {
                    jsonCursor.setError(true);
                }
            } else {
                jsonCursor.setError(true);
            }
        } else {
            jsonCursor.setError(true);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName) && developer.equals(project.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, developer);
    }

    @Override
    protected Project clone() throws CloneNotSupportedException {
        return new Project(this.projectName, this.developer.clone());
    }

    public Project getSerializeCopy() throws ConstructorException {
        try {
            Project _new = new MemorySerializer<Project>().serialize(this);
            return _new;
        } catch (IOException | ClassNotFoundException e) {
            throw new ConstructorException(e.getMessage());
        }
    }

    @Override
    public int compareTo(Project o) {
        if (this.equals(o)) return 0;
        int i = this.projectName.length() - o.projectName.length();
        if (i == 0) {
            i = this.projectName.compareTo(projectName);
            if (i == 0) {
                i = this.developer.compareTo(o.developer);
            }
        }
        return i;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", developer=" + developer +
                '}';
    }
    public String toJson() {
        StringBuilder sb = new StringBuilder();
        Class cl = this.getClass();
        Field[] fl = cl.getDeclaredFields();
        int i = -1;
        sb.append("{\"" + fl[++i].getName() + "\":\"" + projectName + "\",");
        sb.append("\"" + fl[++i].getName() + "\":"  + developer.toJson());
        sb.append("}");
        return sb.toString();
    }
}
