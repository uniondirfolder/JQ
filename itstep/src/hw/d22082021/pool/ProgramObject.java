package hw.d22082021.pool;

import hw.d22082021.abstracts.Developer;

import java.util.Date;
@Developer
public abstract class ProgramObject {
    protected final long id;
    protected boolean isActive;
    protected ProgramObject() {
        this.id = new Date().getTime();
        this.isActive = false;
    }
}
