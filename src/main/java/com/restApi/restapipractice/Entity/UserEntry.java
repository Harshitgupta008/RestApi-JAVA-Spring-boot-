package com.restApi.restapipractice.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "UserDataSts")
public class UserEntry {
    @Id
    private ObjectId id;
    private String name;
    private int number;
    private String location;

    public UserEntry(ObjectId id, String name, int number, String location) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.location = location;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
