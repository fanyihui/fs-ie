package com.fs.hc.core.model.person;

import com.fs.hc.core.model.termnology.valueset.GenderCode;

import java.util.Date;

public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String fullName;
    private String prefix;
    private String suffix;
    private Date birthDatetime;
    private GenderCode gender;
}
