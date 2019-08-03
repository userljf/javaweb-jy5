package com.itdr.pojo;

public class Users {
    private  Integer id;
    private  String name;
    private  String  password;
    private  String tel;
    private  Integer type=0;
    private Integer stats=0;

    public Integer getId () {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String getTel () {
        return tel;
    }

    public void setTel ( String tel ) {
        this.tel = tel;
    }

    public Integer getType () {
        return type;
    }

    public void setType ( Integer type ) {
        this.type = type;
    }

    public Integer getStats () {
        return stats;
    }

    public void setStats ( Integer stats ) {
        this.stats = stats;
    }

    @Override
    public String toString () {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", stats=" + stats +
                '}';
    }
}
