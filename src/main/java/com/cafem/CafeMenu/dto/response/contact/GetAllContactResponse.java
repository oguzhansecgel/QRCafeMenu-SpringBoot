package com.cafem.CafeMenu.dto.response.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllContactResponse {
    private int id;
    private String title;
    private String description;
    private String facebook;
    private String instagram;
}
