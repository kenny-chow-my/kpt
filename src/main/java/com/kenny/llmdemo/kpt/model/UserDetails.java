package com.kenny.llmdemo.kpt.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;

}