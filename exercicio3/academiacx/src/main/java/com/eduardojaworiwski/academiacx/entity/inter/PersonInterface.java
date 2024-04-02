package com.eduardojaworiwski.academiacx.entity.inter;

import java.util.Date;

public interface PersonInterface {
    Long getId();
    String getName();
    Date getBirthdate();
    String getNationality();
    void setId(Long id);
    void setName(String name);
    void setBirthdate(Date birthdate);
    void setNationality(String nationality);
}
