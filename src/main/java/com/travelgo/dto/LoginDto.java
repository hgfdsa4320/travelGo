package com.travelgo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank(message = "공백일 수 없습니다.")
    private String emailAddress;

    @NotBlank(message = "공백일 수 없습니다.")
    private String password;
}
