package com.app.scribed.model;

import com.app.scribed.entity.BaseEntity;
import com.app.scribed.model.converter.PermissionCategoryConverter;
import com.app.scribed.model.enums.PermissionCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "permission")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(length = 50, unique = true, nullable = false)
    private String code;
    @Column(length = 50, nullable = false)
    private String name;
    private boolean active;

    @Column(nullable = false)
    @Convert(converter = PermissionCategoryConverter.class)
    private PermissionCategory category;
}
