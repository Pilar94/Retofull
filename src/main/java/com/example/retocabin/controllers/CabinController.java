package com.example.retocabin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retocabin.entities.Cabin;
import com.example.retocabin.services.CabinService;

@Service
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Cabin")
public class CabinController {    

    @Autowired
    CabinService cabinService;

    public CabinController(CabinService cabinService) {
        this.cabinService = cabinService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cabin>> getCabin(){
        return new ResponseEntity<List<Cabin>>(this.cabinService.getListCabin(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cabin> getCabin(@PathVariable("id") int id){
        return new ResponseEntity<Cabin>(this.cabinService.getCabin(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearCabin(@RequestBody Cabin cabin){
        this.cabinService.crearCabin(cabin);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  eliminarCabin(@PathVariable("id") int id){
        this.cabinService.eliminarCabin(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void>  actualizarCabin(@RequestBody Cabin cabin){
        this.cabinService.actualizarCabin(cabin.getId(), cabin);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    

}
