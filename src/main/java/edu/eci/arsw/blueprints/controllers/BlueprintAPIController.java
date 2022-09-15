/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.controllers;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.services.BlueprintsServices;

/**
 *
 * @author hcadavid
 */
@RestController
public class BlueprintAPIController {

    @Autowired
    BlueprintsServices service;

    /**
     * Get all the blueprints
     * 
     * @return
     */
    @RequestMapping(value = "/blueprints", method = RequestMethod.GET)
    public ResponseEntity<?> controllerGetBlueprints() {
        Set<Blueprint> blueprints = null;
        try {
            blueprints = service.getAllBlueprints();
            service.applyFilter(blueprints);
            return new ResponseEntity<>(blueprints, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error" + ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get the blueprint of the given name created by the given author
     * 
     * @param author
     * @param name
     * @return
     */
    @RequestMapping(value = "/blueprints/{author}", method = RequestMethod.GET)
    public ResponseEntity<?> controllerGetBluePrintsByAuthor(@PathVariable String author) {
        Set<Blueprint> blueprints = null;
        try {
            blueprints = service.getBlueprintsByAuthor(author);
            service.applyFilterByAuthor(blueprints, author);
            return new ResponseEntity<>(blueprints, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error" + ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Get the blueprint of the given name created by the given author
     * 
     * @param author
     * @param name
     * @return
     */
    @RequestMapping(value = "/blueprints/{author}/{bpname}", method = RequestMethod.GET)
    public ResponseEntity<?> controllerGetBluePrintsByName(@PathVariable String author, @PathVariable String bpname) {
        Blueprint blueprint = null;
        try {
            blueprint = service.getBlueprint(author, bpname);
            service.applyFilter(blueprint);
            return new ResponseEntity<>(blueprint, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error" + ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Add a new blueprint
     * 
     * @param bp
     * @return
     */
    @RequestMapping(value = "/blueprints/addBlueprint", method = RequestMethod.POST)
    public ResponseEntity<?> controllerNewBluePrint(@RequestBody Blueprint bp) {
        try {
            service.addNewBlueprint(bp);
            return new ResponseEntity<>("Se ha agregado Correctamente", HttpStatus.CREATED);
        } catch (Exception e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error" + e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /**
     * Update a blueprint
     * 
     * @param bp
     * @return
     */
    @PutMapping(value = "/blueprints/{author}/{bpname}")
    public ResponseEntity<?> controllerPutBluePrint(@PathVariable("author") String author,
            @PathVariable("bpname") String bpname, @RequestBody Blueprint bp) {
        try {
            service.updateBlueprint(author, bpname, bp.getPoints());
            return new ResponseEntity<>(service.getBlueprint(author, bpname), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(BlueprintAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error" + e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}