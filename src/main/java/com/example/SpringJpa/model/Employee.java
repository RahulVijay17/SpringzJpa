package com.example.SpringJpa.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "email_address")
    private String mailId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "off_fkey")
    private Office office;
}
