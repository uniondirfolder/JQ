package itstep.hw.d20072021.data.container;

import itstep.hw.d20072021.data.capsula.Developer;

@Developer
public abstract class AbstractContainer{
    private Object[] data;
    private int size;
    private int count;
    private int step;

    protected AbstractContainer() {
        this.size = 8;
        this.count = 1;
        this.step = this.size;
        this.data = new Object[this.size];
    }

    private void checkSize() {
        if (this.count + 1 == this.size) {
            resize();
        }
    }

    private void resize() {
        this.size += this.step;
        Object[] array = new Object[this.size];
        int a = 0;
        int z = this.data.length;
        while (a < z) {
            array[a] = this.data[a];
            ++a;
        }
        this.data = array;
    }

    protected boolean isContain(Object objRef) {
        boolean result = false;
        int a = 1;
        while (this.data[a] != null) {
            if (objRef.hashCode() == this.data[a].hashCode()) {
                result = true;
            }
            ++a;
        }
        return result;
    }

    protected void setStep(int step) {
        if (step > 0) {
            this.step = step;
        }
    }

    protected int getSize() {
        return size;
    }

    protected int getStep() {
        return step;
    }

    public int getCount() {
        return count - 1;
    }

    public void add(Object obj) {
        checkSize();
        if (isContain(obj) == false) {
            this.data[this.count] = obj;
            ++this.count;
        }
    }

    protected void add(Object[] obj) {
        for (int i = 0; i < obj.length; i++) {
            checkSize();
            if (isContain(obj) == false) {
                this.data[this.count] = obj;
                ++this.count;
            }
        }

    }

    protected Object getRef(int index) {
        if (index >= 0) {
            if (++index < count) {
                return this.data[index];
            }
        }
        return null;
    }

    protected Object getLastRef() {
        if (count > 1) {
            return this.data[this.count - 1];
        }
        return null;
    }

    protected Object getFirstRef() {
        if (count > 1) {
            return this.data[1];
        }
        return null;
    }

    protected Object[] getArrayRef(){
        if(count > 1){
            Object[] tmp = new Object[count];
            int i = 1;
            while (i < count){tmp[i] = data[i]; ++i;}
            return tmp;
        }
        return null;
    }

    protected int getIndex(Object objRef) {
        int i = 1;
        while (data[i] != null) {
            if (this.data[i].hashCode() == objRef.hashCode()) {
                break;
            }
            i++;
        }
        return i - 1;
    }

    protected void insert(Object obj, int index) {
        if (0 <= index) {
            if (isContain(obj) == false) { // if try insert with method getIndex, unique check
                checkSize();
                if (++index < count) {
                    for (int i = count; i > index  ; i--) {
                        data[i] = data[i - 1];
                    }
                    count++;
                    data[index] = obj;
                }
            }
        }
    }

    protected void update(Object obj, int index) {
        if (0 <= index) {
            if (++index < this.count) {
                this.data[index] = obj;
            }
        }
    }

    protected void delete(int index) {
        if (0 <= index) {
            if (++index < this.count) {
                for (int i = index ; i < count - 1; i++) {
                    data[i] = data[i+1];
                }
            }
            data[count-1] = null;
            count--;
        }
    }
    protected void deleteLast(){
        if(count==1)return;
        data[count-1] = null;
        count--;
    }

}
