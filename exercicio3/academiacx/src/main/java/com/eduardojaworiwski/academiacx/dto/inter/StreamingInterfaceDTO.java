package com.eduardojaworiwski.academiacx.dto.inter;

public interface StreamingInterfaceDTO {
    Long getId();
    String getName();
    String getPlatform();

    void setId(Long id);
    void setName(String name);
    void setPlatform(String platform);
}
