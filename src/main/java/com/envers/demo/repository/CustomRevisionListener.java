package com.envers.demo.repository;

import com.envers.demo.entity.CustomRevision;
import org.hibernate.envers.RevisionListener;

public class CustomRevisionListener implements RevisionListener {

    public void newRevision(Object revisionEntity) {
        CustomRevision customRevision = (CustomRevision) revisionEntity;

        customRevision.setUsername("kirshi");
        customRevision.setEmail("kirshi@kirshi.com");
    }
}