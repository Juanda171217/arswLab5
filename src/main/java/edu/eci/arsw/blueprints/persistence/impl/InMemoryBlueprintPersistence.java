/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author hcadavid
 */
@Component
@Qualifier("Memory")
public class InMemoryBlueprintPersistence implements BlueprintsPersistence {

    private final Map<Tuple<String, String>, Blueprint> blueprints = new HashMap<>();

    /**
     * Add new Blueprint in the class InMemoryBluePrintPersistence
     * 
     * @param bp
     * @throws BlueprintPersistenceException
     */
    public InMemoryBlueprintPersistence() {
        // load stub data
        Point[] pts = new Point[] { new Point(140, 140), new Point(115, 115) };
        Blueprint bp = new Blueprint("_authorname_", "_bpname_ ", pts);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        for (int i = 0; i < 2; i++) {
            int p1 = (int) (Math.random() * 100);
            int p2 = (int) (Math.random() * 100);
            Point[] pt = new Point[] { new Point(p1, p1), new Point(p2, p2) };
            bp = new Blueprint("santiago", ("plano" + (i + 1)), pt);
            blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        }
        bp = new Blueprint("wanna", "plano3", pts);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
    }

    /**
     * Add new Blueprint in the class InMemoryBluePrintPersistence
     * 
     * @param bp
     * @throws BlueprintPersistenceException
     */
    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (this.blueprints.containsKey(new Tuple<>(bp.getAuthor(), bp.getName()))) {
            throw new BlueprintPersistenceException("The given blueprint already exists: " + bp);
        } else {
            this.blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        }
    }

    /**
     * Get the Set of Blueprints
     * 
     * @return
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        System.out.println(blueprints.size());
        return blueprints.get(new Tuple<>(author, bprintname));
    }

    /**
     * Get the Set of Blueprints
     * 
     * @return
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    @Override
    public Set<Blueprint> getBluePrints() throws BlueprintPersistenceException, BlueprintNotFoundException {
        Set<Blueprint> bprints = new HashSet<>();
        for (Tuple<String, String> tuple : this.blueprints.keySet()) {
            bprints.add(blueprints.get(tuple));
        }
        return bprints;
    }

    /**
     * Get the Set of Blueprints by author
     * 
     * @return
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> bprints = new HashSet<>();
        for (Tuple<String, String> tuple : this.blueprints.keySet()) {
            if (tuple.o1.equals(author)) {
                bprints.add(blueprints.get(tuple));
            }
        }
        return bprints;
    }
}