package com.cafem.CafeMenu.service.abstracts;

import com.cafem.CafeMenu.dto.request.about.CreateAboutRequest;
import com.cafem.CafeMenu.dto.request.about.UpdateAboutRequest;
import com.cafem.CafeMenu.dto.response.about.CreateAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetAllAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetByIdAboutResponse;
import com.cafem.CafeMenu.dto.response.about.UpdateAboutResponse;

import java.util.List;
import java.util.Optional;

public interface AboutService {

    List<GetAllAboutResponse> getAllAbout();
    Optional<GetByIdAboutResponse> getByIdAbout(int id);
    CreateAboutResponse createAbout(CreateAboutRequest request);
    UpdateAboutResponse updateAbout(UpdateAboutRequest request,int id);
    void deleteAbout(int id);
}
