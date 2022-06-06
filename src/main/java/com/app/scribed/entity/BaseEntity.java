package com.app.scribed.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId(){
        return id;
    }

    public int hashCode() {
        Long id = getId();
        return (id == null) ? super.hashCode() : id.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseEntity))
            return false;
        Long id = getId();
        if (id != null){
            BaseEntity other = (BaseEntity) obj;
            return id.equals(other.getId());
        }
        return false;
    }

    @JsonIgnore
    public boolean isPersistent() {
        return (getId() !=  null);
    }

    @JsonIgnore
    public boolean isTransient() {
        return (getId() !=  null);
    }

    public void setId(Long id) throws IllegalStateException{
        this.id = id;
    }


}
