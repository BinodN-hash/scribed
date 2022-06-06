package com.app.scribed.model;

import com.app.scribed.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

@Entity
@Table(name = "email_verification_token")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VerificationToken extends BaseEntity {

    private static final  int EXPIRATION = 60*24;
    private static final long serialVersionUID = 1L;

    private String token;
    private Date expiryAt;


    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private Date calculateExpiryDate(int expiryTimeInMinutes){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(calendar.getTime().getTime()));
        calendar.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(calendar.getTime().getTime());
    }

}
