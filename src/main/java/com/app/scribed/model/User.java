package com.app.scribed.model;

import com.app.scribed.entity.BaseEntity;
import com.app.scribed.model.converter.StatusConverter;
import com.app.scribed.model.enums.GroupType;
import com.app.scribed.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "user", indexes = {@Index(name = "ix_email", columnList = "email")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(length = 20)
    private String username;
    @Column(length = 100)
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    private Calendar passwordBlockedUntil;
    @Column(length = 1)
    @Convert(converter = StatusConverter.class)
    private Status status = Status.ACTIVE;
    private boolean enabled;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public boolean isSuperAdmin(){
        return group.getCode().SUPER_ADMIN.equals(GroupType.SUPER_ADMIN);
    }
}
