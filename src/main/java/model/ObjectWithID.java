package model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ObjectWithID
{
    @Id
    @Column(name = "ID")
    public String ID;
}
