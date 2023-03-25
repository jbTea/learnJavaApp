package vn.funix.fx16042.java.asm2.models;

import java.util.regex.Pattern;

public abstract class User {
    private String name;
    private String customerId;
    Pattern p = Pattern.compile("^[0-9]{12}$");

    public User(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        if (p.matcher(customerId).find()){
            this.customerId=customerId;
        } else {
            throw new IllegalArgumentException("SJHDJAS");

        }
    }
}
