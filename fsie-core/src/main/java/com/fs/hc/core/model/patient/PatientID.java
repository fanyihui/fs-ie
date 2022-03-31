package com.fs.hc.core.model.patient;

import com.fs.hc.core.model.id.Identifier;
import com.fs.hc.core.model.id.IdentifierAssigningAuthority;


public class PatientID extends Identifier {
    @Override
    public IdentifierAssigningAuthority getIdentifierAssigningAuthority() {
        return identifierAssigningAuthority;
    }

    @Override
    public void setIdentifierAssigningAuthority(IdentifierAssigningAuthority identifierAssigningAuthority) {
        this.identifierAssigningAuthority = identifierAssigningAuthority;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
