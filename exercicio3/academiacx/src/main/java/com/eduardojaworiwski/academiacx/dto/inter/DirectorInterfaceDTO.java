package com.eduardojaworiwski.academiacx.dto.inter;

import java.util.Date;

public interface DirectorInterfaceDTO {
    Long getId();
    String getName();
    Date getBirthdate();
    String getNationality();

    void setId(Long id);
    void setName(String name);
    void setBirthdate(Date birthdate);
    void setNationality(String nationality);
}
