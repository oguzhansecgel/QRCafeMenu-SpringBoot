package com.cafem.CafeMenu.controller;

import com.cafem.CafeMenu.dto.request.about.CreateAboutRequest;
import com.cafem.CafeMenu.dto.request.about.UpdateAboutRequest;
import com.cafem.CafeMenu.dto.response.about.CreateAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetAllAboutResponse;
import com.cafem.CafeMenu.dto.response.about.GetByIdAboutResponse;
import com.cafem.CafeMenu.dto.response.about.UpdateAboutResponse;
import com.cafem.CafeMenu.service.abstracts.AboutService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/about")
public class AboutController {

    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @GetMapping("/getByIdAbout/{id}")
    public Optional<GetByIdAboutResponse> getAboutById(@PathVariable int id)
    {
        return aboutService.getByIdAbout(id);
    }
    @GetMapping("/getAllAbout")
    public List<GetAllAboutResponse> getAllAbout()
    {
        return aboutService.getAllAbout();
    }
    @DeleteMapping("/deletedAbout/{id}")
    public void deletedAbout(@PathVariable int id)
    {
        aboutService.deleteAbout(id);
    }
    @PostMapping("/createdAbout")
    public CreateAboutResponse createAbout(@RequestBody CreateAboutRequest createAboutRequest)
    {
        return aboutService.createAbout(createAboutRequest);
    }
    @PutMapping("/updateAbout/{id}")
    public UpdateAboutResponse updateAbout(@PathVariable int id, @RequestBody UpdateAboutRequest updateAboutRequest)
    {
        return aboutService.updateAbout(updateAboutRequest,id);
    }
}
