package hw.d10092021.view.model;

import java.util.Date;

public class VTask {
    private Date date;
    private String description;
    private long category_id;

    public VTask(long time, String description, long category_id) {
        this.date = new Date(time);
        this.description = description;
        this.category_id = category_id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public long getCategory_id() {
        return category_id;
    }

    @Override
    public String toString() {

        return date +" "+ description;
    }
}
