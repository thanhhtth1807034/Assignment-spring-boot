package com.assignment.assignmentspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "categoryid", insertable = false, updatable = false)
    private Integer categoryid;

     @Column(name = "quantity")
     private Integer quantity;
//
// //many to one: EAGER
// //one to one: EAGER
// //many to many: Lazy
// //one to many: Lazy

    @ManyToOne() //EAGER
    @JoinColumn(name = "categoryid")
    private Category category;
}
