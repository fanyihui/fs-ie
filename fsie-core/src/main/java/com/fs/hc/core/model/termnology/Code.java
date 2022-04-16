package com.fs.hc.core.model.termnology;

import java.io.Serializable;

public class Code implements Serializable {
    private static final long serialVersionUID = 3761109300749683742L;

    private String code;
    private CodeSystem codeSystem;
    private String description;
    private String version;

    public Code(String code, CodeSystem codeSystem, String codeDescription){
        this.code = code;
        this.codeSystem = codeSystem;
        this.description = codeDescription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CodeSystem getCodeSystem() {
        return codeSystem;
    }

    public void setCodeSystem(CodeSystem codeSystem) {
        this.codeSystem = codeSystem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
