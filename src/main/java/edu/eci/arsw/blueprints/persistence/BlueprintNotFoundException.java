/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.persistence;

/**
 * @author hcadavid
 */

public class BlueprintNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>BlueprintNotFoundException</code> without
     * detail message.
     */
    public BlueprintNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs an instance of <code>BlueprintNotFoundException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public BlueprintNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}