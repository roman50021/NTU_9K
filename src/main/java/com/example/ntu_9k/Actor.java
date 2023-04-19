package com.example.ntu_9k;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Actor extends Cinema{
    private int actorId;
    private String firstName;
    private String lastName;

    // Геттеры и сеттеры для полей
    public Actor(){}

    public Actor(int actorId, String firstName, String lastName){
        this.actorId = actorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
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

    private Actor extractActorFromResultSet(ResultSet rs)throws SQLException {
        Actor actor = new Actor();
        actor.setActorId(rs.getInt("actor_id"));
        actor.setFirstName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));

        return actor;
    }
}
