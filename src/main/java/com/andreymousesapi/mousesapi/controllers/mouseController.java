package com.andreymousesapi.mousesapi.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andreymousesapi.mousesapi.models.Mouse;
import com.andreymousesapi.mousesapi.repository.MousesRepository;

@RestController
@RequestMapping("/mouses")
public class mouseController {

@Autowired
private MousesRepository repository;

@GetMapping
public List<Mouse> getRequest() {
    return repository.findAll();
}

@GetMapping("/{id}")
public ResponseEntity<Mouse> getMouseById(@PathVariable String id) {
    Mouse mouse = repository.findById(id).orElse(null);

    if (mouse != null) {
        return new ResponseEntity<>(mouse, HttpStatus.FOUND);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@PostMapping
public ResponseEntity<Mouse> addMouse(@RequestBody Mouse mouse) {
    repository.save(mouse);
    return new ResponseEntity<Mouse>(mouse, HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<Mouse> updateMouse(@PathVariable String id,
@RequestBody Mouse newMouse) {
    Mouse mouse = repository.findById(id).orElse(null);

    if (mouse != null) {
        mouse.setBrand(newMouse.getBrand());
        mouse.setModel(newMouse.getModel());
        mouse.setPrice(newMouse.getPrice());
        repository.save(mouse);

        return new ResponseEntity<Mouse>(mouse, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteMouse(@PathVariable String id) {
    repository.deleteById(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}



}
