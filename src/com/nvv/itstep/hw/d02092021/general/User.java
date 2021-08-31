package com.nvv.itstep.hw.d02092021.general;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

public class User implements Serializable {
    private String name;
    private String identifier;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public User(String name) {
        this.name = name;
        this.identifier = UUID.randomUUID() + OffsetDateTime.now(ZoneOffset.UTC).toString();
    }


}
