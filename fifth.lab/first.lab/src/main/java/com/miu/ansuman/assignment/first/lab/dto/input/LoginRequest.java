package com.miu.ansuman.assignment.first.lab.dto.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequest {
    public String email;
    public String password;
}
