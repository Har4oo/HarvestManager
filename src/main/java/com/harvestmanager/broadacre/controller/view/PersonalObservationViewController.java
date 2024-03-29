package com.harvestmanager.broadacre.controller.view;

import com.harvestmanager.broadacre.entity.Crop;
import com.harvestmanager.broadacre.entity.Harvest;
import com.harvestmanager.broadacre.entity.Location;
import com.harvestmanager.broadacre.entity.PersonalObservation;
import com.harvestmanager.broadacre.service.CropService;
import com.harvestmanager.broadacre.service.HarvestService;
import com.harvestmanager.broadacre.service.PersonalObservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personalObservation")
@AllArgsConstructor
public class PersonalObservationViewController {
    private PersonalObservationService personalObservationService;
    private CropService cropService;

    @GetMapping
    public String harvestView(Model model) {
        System.out.println(personalObservationService.getPersonalObservations().toString());
        model.addAttribute("personalObservations", personalObservationService.getPersonalObservations());
        model.addAttribute("crops", cropService.getCrops());
        return "/personalobservation/personalObservation";
    }

    @GetMapping("/createPersonalObservation/{id}")
    public String createPersonalObservation(Model model, @PathVariable long id) {
        System.out.println("Attempt to create new Personal Observation");
        PersonalObservation personalObservation = new PersonalObservation();
        Crop crop = cropService.getCrop(id);

        personalObservation.setCrop(crop);

        System.out.println("Creating personal observation with values: " + personalObservation.toString());
        model.addAttribute("personalObservation", personalObservation);
        model.addAttribute("crop",crop);
        return "/personalobservation/createPersonalObservation";
    }

    @PostMapping("/post/createPersonalObservation")
    public String createPersonalObservation(@ModelAttribute PersonalObservation personalObservation) {
        System.out.println("Creating new Personal Observation with values: " + personalObservation.toString());
        personalObservationService.createPersonalObservation(personalObservation);
        return "redirect:/crop/cropDescription/" + personalObservation.getCrop().getCropId();
    }

    @GetMapping("/editPersonalObservation/{id}")
    public String editPersonalObservation(Model model, @PathVariable long id) {
        System.out.println("Editing Personal Observation with values: " + personalObservationService.getPersonalObservation(id));
        PersonalObservation personalObservation = personalObservationService.getPersonalObservation(id);
        Crop crop = cropService.getCrop(personalObservation.getCrop().getCropId());

        personalObservation.setCrop(crop);

        model.addAttribute("personalObservation", personalObservation);
        model.addAttribute("crop", crop);
        return "/personalobservation/editPersonalObservation";
    }

    @PostMapping("/put/updatePersonalObservation/{id}")
    public String updatePersonalObservation(@PathVariable long id, @ModelAttribute PersonalObservation personalObservation) {
        personalObservationService.updatePersonalObservation(personalObservation, id);
        System.out.println("updating value " + personalObservationService.getPersonalObservation(id).toString());
        return "redirect:/personalObservation";
    }

    @GetMapping("/deletePersonalObservation/{id}")
    public String deletePersonalObservation(@PathVariable long id) {
        System.out.println("Deleting personal observation with values: "+personalObservationService.getPersonalObservation(id).toString());
        long cropId = personalObservationService.getPersonalObservation(id).getCrop().getCropId();
        personalObservationService.deletePersonalObservation(id);
        return "redirect:/crop/cropDescription/" + cropId;
    }

    @GetMapping("/viewPersonalObservation/{id}")
    public String viewPersonalObservation(@PathVariable long id, Model model) {
        personalObservationService.getPersonalObservation(id);
        model.addAttribute("personalObservation", personalObservationService.getPersonalObservation(id));
        return "/personalobservation/viewPersonalObservation";
    }
}
