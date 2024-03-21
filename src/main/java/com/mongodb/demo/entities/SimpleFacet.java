package com.mongodb.demo.entities;

import org.springframework.data.mongodb.core.mapping.Field;

public class SimpleFacet {
    @Field("_id")
    String id;
    long count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
