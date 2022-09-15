/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.services;

import edu.eci.arsw.blueprints.filter.types.FilterType;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class BlueprintsServices {

    @Autowired
    @Qualifier("Memory")
    BlueprintsPersistence bpp;

    @Autowired
    @Qualifier("Sub")
    FilterType filter;

    /**
     * Save a new blueprint
     * 
     * @param bp blueprint to be saved
     * @throws BlueprintPersistenceException
     */
    public void addNewBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        bpp.saveBlueprint(bp);
    }

    /**
     * Get all blueprints
     * 
     * @return all blueprints
     * @throws BlueprintPersistenceException
     */
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException, BlueprintPersistenceException {
        return bpp.getBluePrints();
    }

    /**
     * Get all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public Blueprint getBlueprint(String author, String name) throws BlueprintNotFoundException {
        return bpp.getBlueprint(author, name);
    }

    /**
     * Get all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public Set<Blueprint> getBlueprintsByAuthor(String author)
            throws BlueprintNotFoundException, BlueprintPersistenceException {
        return bpp.getBlueprintsByAuthor(author);
    }

    /**
     * Filter all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public void applyFilter(Blueprint bp) throws BlueprintNotFoundException {
        filter.filterBlueprint(bp);
    }

    /**
     * Filter all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public void applyFilter(Set<Blueprint> bps) throws BlueprintNotFoundException, BlueprintPersistenceException {
        filter.filterBlueprints(bps);
    }

    /**
     * Filter all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public void applyFilterByAuthor(Set<Blueprint> blueprints, String author) throws BlueprintNotFoundException {
        filter.filterPrintsByAuthor(author, blueprints);
    }

    /**
     * Filter all blueprints from an author
     * 
     * @param author author of the blueprints
     * @return all blueprints from an author
     * @throws BlueprintPersistenceException
     */
    public void updateBlueprint(String author, String bpname, List<Point> points) throws BlueprintNotFoundException {
        Blueprint bp = getBlueprint(author, bpname);
        bp.setPoints(points);
    }
}
