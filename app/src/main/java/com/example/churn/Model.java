package com.example.churn;

public class Model {
    String name;
    String ID;

    public Model(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String tostring(){
        return this.ID+" : "+this.name;
    }
}
