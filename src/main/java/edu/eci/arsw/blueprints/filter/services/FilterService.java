package edu.eci.arsw.blueprints.filter.services;

import edu.eci.arsw.blueprints.filter.types.FilterType;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class FilterService {
    @Autowired
    @Qualifier("Redundancy")
    FilterType filter;

    /**
     * Filtra los puntos repetidos de un blueprint
     * 
     * @param bp blueprint
     * @return blueprint filtrado
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    public void filterBlueprint(Blueprint bp) throws BlueprintNotFoundException {
        filter.filterBlueprint(bp);
    }

    /**
     * Retorna el Set de Blueprints filtrados
     * 
     * @return
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    public void filterBlueprints(Set<Blueprint> blueprints)
            throws BlueprintNotFoundException, BlueprintPersistenceException {
        filter.filterBlueprints(blueprints);

    }
}