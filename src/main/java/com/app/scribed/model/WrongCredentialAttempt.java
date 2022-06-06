package com.app.scribed.model;

import com.app.scribed.entity.BaseEntity;
import com.app.scribed.model.converter.CredentialsConverter;
import com.app.scribed.model.enums.Credentials;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "wrong_credential_attempts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WrongCredentialAttempt extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar date;

    @Column(length = 2)
    @Convert(converter = CredentialsConverter.class)
    private Credentials credentialsType;

}
