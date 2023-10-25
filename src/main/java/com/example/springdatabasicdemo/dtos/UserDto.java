package com.example.springdatabasicdemo.dtos;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public  class UserDto {
    private UUID id;
    private  String username;
    private  String password;
    private  String firstName;
    private  String lastName;
    private  boolean isActive;
    private  String imageUrl;
    private  Date created;
    private  Date modified;
    private  UserRoleDto role;

    public UserDto(
            UUID id,
            String username,
            String password,
            String firstName,
            String lastName,
            boolean isActive,
            String imageUrl,
            Date created,
            Date modified,
            UserRoleDto role
    ) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.created = created;
        this.modified = modified;
        this.role = role;
    }

    public UserDto(String username, String password, String firstName, String lastName, boolean isActive, String imageUrl, Date created, Date modified, UserRoleDto role) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.imageUrl = imageUrl;
        this.created = created;
        this.modified = modified;
        this.role = role;
    }

    public UserDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public UserRoleDto getRole() {
        return role;
    }

    public void setRole(UserRoleDto role) {
        this.role = role;
    }

    public UUID id() {
        return id;
    }

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public String imageUrl() {
        return imageUrl;
    }

    public Date created() {
        return created;
    }

    public Date modified() {
        return modified;
    }

    public UserRoleDto role() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (UserDto) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.username, that.username) &&
                Objects.equals(this.password, that.password) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                this.isActive == that.isActive &&
                Objects.equals(this.imageUrl, that.imageUrl) &&
                Objects.equals(this.created, that.created) &&
                Objects.equals(this.modified, that.modified) &&
                Objects.equals(this.role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, isActive, imageUrl, created, modified, role);
    }

    @Override
    public String toString() {
        return "UserDto[" +
                "id=" + id + ", " +
                "username=" + username + ", " +
                "password=" + password + ", " +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "isActive=" + isActive + ", " +
                "imageUrl=" + imageUrl + ", " +
                "created=" + created + ", " +
                "modified=" + modified + ", " +
                "role=" + role + ']';
    }

}
