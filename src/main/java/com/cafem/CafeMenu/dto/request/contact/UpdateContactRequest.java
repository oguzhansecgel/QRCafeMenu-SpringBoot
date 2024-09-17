package com.cafem.CafeMenu.dto.request.contact;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateContactRequest {
    private String title;
    private String description;
    private String facebook;
    private String instagram;
}
