package com.lagou.edu.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "cardNo")
    private String cardNo;

    @Column(name = "name")
    private String name;

    @Column(name = "money")
    private Integer money;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;
}
