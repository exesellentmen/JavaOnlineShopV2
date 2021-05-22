package com.website.dictionary.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Testq {
    private int id;
    private String active;
    private String name;
    private int sort;
    private Timestamp timestampx;
    private Timestamp timestampX;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "active", nullable = true, length = 255)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sort", nullable = false)
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }


    @Basic
    @Column(name = "timestamp_x", nullable = false)
    public Timestamp getTimestampX() {
        return timestampX;
    }

    public void setTimestampX(Timestamp timestampX) {
        this.timestampX = timestampX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Testq testq = (Testq) o;

        if (id != testq.id) return false;
        if (sort != testq.sort) return false;
        if (active != null ? !active.equals(testq.active) : testq.active != null) return false;
        if (name != null ? !name.equals(testq.name) : testq.name != null) return false;
        if (timestampx != null ? !timestampx.equals(testq.timestampx) : testq.timestampx != null) return false;
        if (timestampX != null ? !timestampX.equals(testq.timestampX) : testq.timestampX != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + (timestampx != null ? timestampx.hashCode() : 0);
        result = 31 * result + (timestampX != null ? timestampX.hashCode() : 0);
        return result;
    }
}
