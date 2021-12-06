package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profiles")
public class Profile extends ObjectWithID
{
    @Column(name = "userID")
    public String UserID;

    @Column(name = "age")
    public String Age;

    @Column(name = "height")
    public String Heigh;

}