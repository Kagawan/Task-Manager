package hexlet.code.dto;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthRequest {
    @Email
    private String username;
    private String password;
}
