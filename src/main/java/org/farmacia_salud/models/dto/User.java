package org.farmacia_salud.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public User() {
    }
}
