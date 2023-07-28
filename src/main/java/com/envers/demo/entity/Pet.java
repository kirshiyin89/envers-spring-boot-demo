package com.envers.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Audited
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pet {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    //@NotAudited
    private int age;

    @Column
    private double donation;
}