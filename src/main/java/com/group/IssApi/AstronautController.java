package com.group.IssApi;

import java.util.List;



import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;






@RestController
class AstronautController{

    private final AstronautRepository repository;

    AstronautController(AstronautRepository repository) {
        this.repository = repository;
    }
    
   
    @GetMapping("/astronauts") 
    List<Astronaut> all() {
        return repository.findAll();
    }

    @PostMapping("/astronauts")
    Astronaut newAstronaut(@RequestBody Astronaut newAstronaut){
        return repository.save(newAstronaut);
    }

    //Single item

    @GetMapping("/astronauts/{id}")
    EntityModel<Astronaut> one(@PathVariable Long id) {

        Astronaut astronaut = repository.findById(id)
           .orElseThrow(() -> new AstronautNotFoundException(id));
        
        return EntityModel.of(astronaut, 
        linkTo(methodOn(AstronautController.class).one(id)).withSelfRel(),
        linkTo(methodOn(AstronautController.class).all()).withRel("astronauts"));
    }

    @PutMapping("/astronauts/{id}")
    Astronaut replaceAstronaut(@RequestBody Astronaut newAstronaut, @PathVariable Long id) {

        return repository.findById(id)
          .map(astronaut -> {
            astronaut.setName(newAstronaut.getName());
            astronaut.setRole(newAstronaut.getRole());
            astronaut.setNationality(newAstronaut.getNationality());
            return repository.save(astronaut);
          })
          .orElseGet(() -> {
            newAstronaut.setId(id);
            return repository.save(newAstronaut);
          });
    }

    @DeleteMapping("/astronauts/{id}")
    void deleteAstronaut(@PathVariable Long id) {
        repository.deleteById(id);
    }











}