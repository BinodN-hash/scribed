package com.app.scribed.model;

import com.app.scribed.entity.BaseEntity;
import com.app.scribed.model.converter.GroupTypeConverter;
import com.app.scribed.model.enums.GroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "group")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group extends BaseEntity {

    private static final long serialVersionUID = 1L;
    @Column(length = 2)
    @Convert(converter = GroupTypeConverter.class)
    private GroupType code;
    @Column(length = 30, nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "group_permission", joinColumns = @JoinColumn(name = "group_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
    private Set<Permission> permissions = new HashSet<Permission>();

    public void addPermissions(List<Permission> permissions) {
        this.permissions.addAll(permissions);
    }

    public void removePermissions(Set<Permission> permissions) {
        this.permissions.removeAll(permissions);
    }



}
