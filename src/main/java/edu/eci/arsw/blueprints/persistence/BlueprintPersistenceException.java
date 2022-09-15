/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence;

/**
 *
 * @author hcadavid
 */
public class BlueprintPersistenceException extends Exception {

    /**
     * Creates a new instance of <code>BlueprintPersistenceException</code> without
     * detail message.
     */
    public BlueprintPersistenceException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of <code>BlueprintPersistenceException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BlueprintPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}