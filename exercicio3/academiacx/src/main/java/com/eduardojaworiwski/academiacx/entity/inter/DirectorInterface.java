package com.eduardojaworiwski.academiacx.entity.inter;

import java.util.Date;

public interface DirectorInterface {
    Long getId();
    String getName();
    Date getBirthdate();
    String getNationality();

    void setName(String name);
    void setBirthdate(Date birthdate);
    void setNationality(String nationality);
}
