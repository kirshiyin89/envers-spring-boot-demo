package com.envers.demo.entity;

import com.envers.demo.repository.CustomRevisionListener;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CUSTOM_REV_INFO")
@RevisionEntity(CustomRevisionListener.class)
@Data
public class CustomRevision extends DefaultRevisionEntity {

    private String username;
    private String email;
}