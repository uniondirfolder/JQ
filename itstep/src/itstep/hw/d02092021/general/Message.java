package itstep.hw.d02092021.general;

import java.io.Serializable;

import java.util.Date;

public class Message implements Serializable {
    private String owner = "x";
    private String body = "x";
    private String time = "x";

    public Message(String owner, String body, String time) {
        this.owner = owner;
        this.body = body;
        this.time = time;
    }

    public boolean isEmpty() {
        return time.equals("x");
    }

    public Message(String msg) {
        try {
            String[] arr = msg.split("%");
            if (arr.length == 3) {
                owner = arr[0];
                body = arr[1];
                time = arr[2];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message(Message message) {
        this.owner = message.owner;
        this.body = message.body;
        this.time = message.time;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String print() {
        long time = Long.parseLong(this.time);
        Date date = new Date(time);
        return date.toString() + " < " + owner + " > " + body;
    }

    @Override
    public String toString() {
        return owner + "%" + body + "%" + time;
    }
}
