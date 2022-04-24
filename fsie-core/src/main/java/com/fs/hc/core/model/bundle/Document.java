package com.fs.hc.core.model.bundle;

import com.fs.hc.core.model.encounter.Encounter;
import com.fs.hc.core.model.id.Identifier;
import com.fs.hc.core.model.patient.Patient;
import com.fs.hc.core.model.service.ServiceEvent;

import java.io.Serializable;

public class Document implements Serializable {
    private static final long serialVersionUid = 1L;

    private Identifier identifier;
    private Code documentType;
    private Patient patient;
    private Encounter encounter;
    private Date creationTime;
    private ServiceEvent serviceEvent;
    private String title;

}
