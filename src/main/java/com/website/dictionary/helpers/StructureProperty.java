package com.website.dictionary.helpers;

public class StructureProperty {
    private String Name;
    private String Value;
    private String Type;

    public StructureProperty(String Name, String Value, String Type){
        this.setName(Name);
        this.setValue(Value);
        this.setType(Type);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
