package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends ObjectWithID
{
    @Column(name = "firstname")
    public String FirstName;

    @Column(name = "lastname")
    public String LastName;

    @Column(name = "username")
    public String UserName;

    @Column(name = "password")
    public String Password;

    @Column(name = "location")
    public String Location;

    @Column(name = "gender")
    public String Gender;
}