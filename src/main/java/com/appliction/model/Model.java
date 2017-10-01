package com.appliction.model;
import io.datafx.controller.injection.scopes.FlowScoped;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.inject.Scope;

/**
 * Created by guru on 9/25/2017.
 */
@FlowScoped
public class Model
{

    private StringProperty name;

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Model()
    {
        name=new SimpleStringProperty();
        name.set("model");
    }
}
