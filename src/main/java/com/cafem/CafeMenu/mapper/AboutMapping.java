package com.cafem.CafeMenu.mapper;

import com.cafem.CafeMenu.dto.request.about.CreateAboutRequest;
import com.cafem.CafeMenu.dto.request.about.UpdateAboutRequest;
import com.cafem.CafeMenu.dto.response.about.GetAllAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetByIdAboutResponse;
import com.cafem.CafeMenu.entities.About;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper
public interface AboutMapping {

    AboutMapping INSTANCE = Mappers.getMapper(AboutMapping.class);

    About createAbout(CreateAboutRequest request);

    About updateAbout(UpdateAboutRequest request,@MappingTarget About about);

    GetByIdAboutResponse getByIdAbout(About about);

    GetAllAboutResponse getAllAbout(About about);
    List<GetAllAboutResponse> aboutToListAboutResponse(List<About> abouts);

}
