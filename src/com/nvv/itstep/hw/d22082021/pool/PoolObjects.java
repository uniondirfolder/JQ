package com.nvv.itstep.hw.d22082021.pool;


import com.nvv.itstep.hw.d22082021.abstracts.Developer;
import com.nvv.itstep.hw.d22082021.abstracts.Universal;

import java.util.ArrayList;

@Developer
public final class PoolObjects implements PoolInterface, Universal {
    private ArrayList<Object> pool = new ArrayList<>();

    private boolean contains(Object obj) {
        if (obj != null) {
            ProgramObject objR = (ProgramObject) obj;
            for (Object o : pool) {
                ProgramObject objL = (ProgramObject) o;
                if (objL.id == objR.id) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(Object obj) {
        if (!contains(obj)) {
            pool.add(obj);
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        if (obj != null) {
            ProgramObject oL = (ProgramObject) obj;
            ProgramObject oR = (ProgramObject) obj;
            for (int i = 0; i < pool.size(); i++) {
                oR = (ProgramObject) pool.get(i);
                if (oL.id == oR.id) {
                    pool.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(long id) {
        for (int i = 0; i < pool.size(); i++) {
            ProgramObject po = (ProgramObject) pool.get(i);
            if (po.id == id) {
                return po;
            }
        }
        return null;
    }
}
