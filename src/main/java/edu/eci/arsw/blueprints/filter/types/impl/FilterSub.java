package edu.eci.arsw.blueprints.filter.types.impl;

import edu.eci.arsw.blueprints.filter.types.FilterType;
import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Qualifier("Sub")
public class FilterSub implements FilterType {
    /**
     * Filtra los puntos repetidos de un blueprint
     * 
     * @param bp blueprint
     * @return blueprint filtrado
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    @Override
    public void filterBlueprint(Blueprint bp) throws BlueprintNotFoundException {
        List<Point> points = new ArrayList<Point>(bp.getPoints());
        List<Point> pointsFilter = new ArrayList<Point>();
        for (int i = 0; i < points.size(); i++) {
            if (i % 2 == 1) {
                pointsFilter.add(points.get(i));
            }
        }
        bp.setPoints(pointsFilter);
    }

    /**
     * Retorna el Set de Blueprints filtrados
     * 
     * @return
     * @throws BlueprintNotFoundException
     * @throws BlueprintPersistenceException
     */
    @Override
    public void filterBlueprints(Set<Blueprint> blueprints)
            throws BlueprintPersistenceException, BlueprintNotFoundException {
        for (Blueprint print : blueprints) {
            filterBlueprint(print);
        }
    }

    /**
     * Retorna los Blueprints filtrados creados por un autor en especifico
     * 
     * @param author autor que se desea conocer que Blueprints genero
     * @return
     * @throws BlueprintNotFoundException si el autor no existe
     */
    @Override
    public void filterPrintsByAuthor(String author, Set<Blueprint> blueprints) throws BlueprintNotFoundException {
        for (Blueprint print : blueprints) {
            if (print.getAuthor().equals(author)) {
                filterBlueprint(print);
            }
        }
    }
}