package com.cafem.CafeMenu.service.concretes;

import com.cafem.CafeMenu.core.constant.AboutConstant;
import com.cafem.CafeMenu.core.exception.exceptionhandler.AboutNotFoundException;
import com.cafem.CafeMenu.dto.request.about.CreateAboutRequest;
import com.cafem.CafeMenu.dto.request.about.UpdateAboutRequest;
import com.cafem.CafeMenu.dto.response.about.CreateAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetAllAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetByIdAboutResponse;
import com.cafem.CafeMenu.dto.response.about.UpdateAboutResponse;
import com.cafem.CafeMenu.entities.About;
import com.cafem.CafeMenu.mapper.AboutMapping;
import com.cafem.CafeMenu.repositories.AboutRepositories;
import com.cafem.CafeMenu.service.abstracts.AboutService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AboutServiceImpl implements AboutService {

    private final AboutRepositories aboutRepositories;

    public AboutServiceImpl(AboutRepositories aboutRepositories) {
        this.aboutRepositories = aboutRepositories;
    }

    @Override
    public List<GetAllAboutResponse> getAllAbout() {
        List<About> aboutList = aboutRepositories.findAll();
        return AboutMapping.INSTANCE.aboutToListAboutResponse(aboutList);
    }

    @Override
    public Optional<GetByIdAboutResponse> getByIdAbout(int id) {
        Optional<About> about = aboutRepositories.findById(id);
        if (about.isEmpty())
        {
            throw new AboutNotFoundException(AboutConstant.ABOUT_NOT_FOUND_MESSAGE);
        }
        return about.map(AboutMapping.INSTANCE::getByIdAbout);
    }

    @Override
    public CreateAboutResponse createAbout(CreateAboutRequest request) {
        About about = AboutMapping.INSTANCE.createAbout(request);
        About savedAbout = aboutRepositories.save(about);
        return new CreateAboutResponse(savedAbout.getId(), savedAbout.getTitle(), savedAbout.getContent());
    }

    @Override
    public UpdateAboutResponse updateAbout(UpdateAboutRequest request, int id) {
        Optional<About> optionalAbout = aboutRepositories.findById(id);
        if (optionalAbout.isEmpty()) {
            throw new AboutNotFoundException(AboutConstant.ABOUT_NOT_FOUND_MESSAGE);
        }
        About existingAbout = optionalAbout.get();
        About about = AboutMapping.INSTANCE.updateAbout(request, existingAbout);
        About savedAbout = aboutRepositories.save(about);
        return new UpdateAboutResponse(savedAbout.getId(), savedAbout.getTitle(), savedAbout.getContent());
    }

    @Override
    public void deleteAbout(int id) {
        Optional<About> about =  aboutRepositories.findById(id);
        if(about.isEmpty())
            throw new AboutNotFoundException(AboutConstant.ABOUT_NOT_FOUND_MESSAGE);
        aboutRepositories.deleteById(id);
    }
}
