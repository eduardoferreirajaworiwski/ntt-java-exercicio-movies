package com.eduardojaworiwski.academiacx.entity.inter;

public interface UserInterface {
    Long getId();
    String getUsername();
    String getPassword();
    void setId(Long id);
    void setUsername(String username);
    void setPassword(String password);
}
