/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence;

import edu.eci.arsw.blueprints.model.Blueprint;

import java.util.Set;

/**
 *
 * @author hcadavid
 */
public interface BlueprintsPersistence {

    /**
     * Save a new blueprint
     * 
     * @param bp blueprint to be saved
     * @throws BlueprintPersistenceException
     */
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException;

    /**
     * Get all blueprints
     * 
     * @return all blueprints
     * @throws BlueprintPersistenceException
     */
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException;

    /**
     * Get all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public Set<Blueprint> getBluePrints() throws BlueprintPersistenceException, BlueprintNotFoundException;

    /**
     * Get all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException;

}