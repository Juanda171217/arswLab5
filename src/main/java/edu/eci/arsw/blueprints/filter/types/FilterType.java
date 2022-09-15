package edu.eci.arsw.blueprints.filter.types;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;

import java.util.Set;

public interface FilterType {

    /**
     * Filtra los puntos repetidos de un blueprint
     * 
     * @param bp blueprint
     * @return blueprint filtrado
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    public void filterBlueprint(Blueprint bp) throws BlueprintNotFoundException;

    /**
     * Retorna el Set de Blueprints filtrados
     * 
     * @return
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    public void filterBlueprints(Set<Blueprint> blueprints)
            throws BlueprintPersistenceException, BlueprintNotFoundException;

    /**
     * Retorna los Blueprints filtrados creados por un autor en especifico
     * 
     * @param author autor que se desea conocer que Blueprints genero
     * @return
     * @throws BlueprintNotFoundException si el autor no existe
     */
    public void filterPrintsByAuthor(String author, Set<Blueprint> blueprints) throws BlueprintNotFoundException;
}