package fh.kufstein.Entity;

import javax.persistence.EntityListeners;
import java.util.Date;

/**
 * Created by bioharz on 11/04/17.
 */

public  class Student {

    private String pkz;
    private String firstname;
    private String surName;
    private Date birthday;

    public Student() {}

    public Student(String pkz, String firstname, String surname, Date birthday) {
        this.pkz = pkz;
        this.firstname = firstname;
        this.surName = surname;
        this.birthday = birthday;
    }


    public String getPkz() {
        return pkz;
    }

    public void setPkz(String pkz) {
        this.pkz = pkz;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setDate(Date gbDate) {
        this.birthday = gbDate;
    }


    @Override
    public String toString() {
        return "Student{" +
                "pkz='" + pkz + '\'' +
                ", firstname='" + firstname + '\'' +
                ", surName='" + surName + '\'' +
                ", date=" + birthday +
                '}';
    }
}
