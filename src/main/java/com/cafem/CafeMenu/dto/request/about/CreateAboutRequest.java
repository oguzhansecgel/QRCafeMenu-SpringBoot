package com.cafem.CafeMenu.dto.request.about;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAboutRequest {
    private String title;
    private String content;
}
