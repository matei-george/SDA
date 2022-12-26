package com.example.laborator10;

import java.util.Objects;
public class Nod<E> {
    private E info;
    private Nod<E> stg = null;
    private Nod<E> dr = null;
    Nod(E info) {
        this.info = info;
    }
    private boolean esteFrunza(){
        return stg==null && dr==null;
    }
    @Override
    public String toString() {
        return info.toString();
    }
    public E getInfo() {
        return info;
    }
    public void setInfo(E info) {this.info = info;
    }
    public Nod<E> getStg() {
        return stg;
    }
    public void setStg(Nod<E> stg) {
        this.stg = stg;
    }
    public Nod<E> getDr() {
        return dr;
    }
    public void setDr(Nod<E> dr) {
        this.dr = dr;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nod<?> nod = (Nod<?>) o;
        return Objects.equals(info, nod.info);
    }
    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}