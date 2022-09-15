package edu.eci.arsw.blueprints.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Blueprint {

    private String author = null;

    private List<Point> points = null;

    private String name = null;

    /**
     * Constructor of the class Blueprint
     * 
     * @param author
     * @param points
     * @param name
     */
    public Blueprint(String author, String name, Point[] pnts) {
        this.author = author;
        this.name = name;
        points = Arrays.asList(pnts);
    }

    public Blueprint(String author, String name) {
        this.name = name;
        this.author = author;
        points = new ArrayList<>();
    }

    public Blueprint() {
    }

    public String getName() {
        return name;
    }

    /**
     * Get the author of the blueprint
     * 
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the points of the blueprint
     * 
     * @return
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * Set the author of the blueprint
     * 
     * @param author
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * Set the points of the blueprint
     * 
     * @param points
     */
    public void addPoint(Point p) {
        this.points.add(p);
    }

    /**
     * Set the name of the blueprint
     * 
     * @param name
     */
    @Override
    public String toString() {
        return "Blueprint{" + "author=" + author + ", name=" + name + '}';
    }

    /**
     * Compare the blueprint with another object
     * 
     * @param obj
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Compare the blueprint with another object
     * 
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blueprint other = (Blueprint) obj;
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.points.size() != other.points.size()) {
            return false;
        }
        for (int i = 0; i < this.points.size(); i++) {
            if (this.points.get(i) != other.points.get(i)) {
                return false;
            }
        }

        return true;
    }

}