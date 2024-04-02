package com.eduardojaworiwski.academiacx.dto.inter;

public interface UserInterfaceDTO {
    Long getId();
    String getUsername();
    String getPassword();

    void setId(Long id);
    void setUsername(String username);
    void setPassword(String password);
}
