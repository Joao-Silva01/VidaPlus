package com.RobDev.VidaPlus.dto.administrator;


import com.RobDev.VidaPlus.entities.enums.UserRole;


public class AdminResponse {

    private long id;
    private String name;
    private String email;
    private String password;
    private UserRole role;

    //private List<Report> reports = new ArrayList<>();

    public AdminResponse(){

    }

    public AdminResponse(long id, String name, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
