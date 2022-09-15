package edu.eci.arsw.blueprints.persistence.impl;

import java.util.Objects;

public class Tuple<T1, T2> {

    T1 o1;
    T2 o2;

    /**
     * Constructor of the class Tuple
     * 
     * @param o1
     * @param o2
     */
    public Tuple(T1 o1, T2 o2) {
        super();
        this.o1 = o1;
        this.o2 = o2;
    }

    /**
     * Get the first object of the tuple
     * 
     * @return
     */
    public T1 getElem1() {
        return o1;
    }

    /**
     * Get the second object of the tuple
     * 
     * @return
     */
    public T2 getElem2() {
        return o2;
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.o1);
        hash = 17 * hash + Objects.hashCode(this.o2);
        return hash;
    }

    /**
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
        final Tuple<?, ?> other = (Tuple<?, ?>) obj;
        if (!Objects.equals(this.o1, other.o1)) {
            return false;
        }
        if (!Objects.equals(this.o2, other.o2)) {
            return false;
        }
        return true;
    }

}