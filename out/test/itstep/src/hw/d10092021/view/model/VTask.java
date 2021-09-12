package hw.d10092021.view.model;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VTask {
    private long id;
    private Date date;
    private String description;
    private long category_id;

    public VTask(long id, long time, String description, long category_id) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        Format f = new SimpleDateFormat("MM/dd/yy");
        return f.format(date) +" "+ description;

    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
