package com.cafem.CafeMenu.dto.response.about;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAboutResponse {
    private int id;
    private String title;
    private String content;
}
