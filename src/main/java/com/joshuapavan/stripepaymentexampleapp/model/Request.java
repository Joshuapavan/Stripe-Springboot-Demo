package com.joshuapavan.stripepaymentexampleapp.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @NotNull
    @Min(4)
    private Long amount;
    @Email
    private String email;
    @NotBlank
    @Size(min = 5, max = 200)
    private String productName;

}
