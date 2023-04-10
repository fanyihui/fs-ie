package com.fs.hc.core.model.bundle;

import com.fs.hc.core.model.encounter.Encounter;
import com.fs.hc.core.model.id.Identifier;
import com.fs.hc.core.model.patient.Patient;
import com.fs.hc.core.model.provider.Practitioner;
import com.fs.hc.core.model.service.ServiceEvent;
import com.fs.hc.core.model.termnology.Code;

import java.io.Serializable;
import java.util.Date;

public class FsDocument implements Serializable {
    private static final long serialVersionUid = 1L;

    private Identifier identifier;
    private Code documentType;
    private Patient patient;
    private Encounter encounter;
    private Date creationTime;
    private ServiceEvent serviceEvent;
    private String title;
    private Practitioner author;
}
