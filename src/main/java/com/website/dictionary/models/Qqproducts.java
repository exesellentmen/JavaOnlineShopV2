package com.website.dictionary.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Qqproducts {
    private long id;
    private String active;
    private Timestamp dateCreate;
    private String detailText;
    private Timestamp modifiedBy;
    private String name;
    private String previewText;
    private Long sort;
    private Timestamp timestampX;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "active", nullable = true, length = 1)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "date_create", nullable = true)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "detail_text", nullable = true, length = -1)
    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    @Basic
    @Column(name = "modified_by", nullable = true)
    public Timestamp getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Timestamp modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "preview_text", nullable = true, length = -1)
    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    @Basic
    @Column(name = "sort", nullable = true)
    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "timestamp_x", nullable = true)
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

        Qqproducts that = (Qqproducts) o;

        if (id != that.id) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (detailText != null ? !detailText.equals(that.detailText) : that.detailText != null) return false;
        if (modifiedBy != null ? !modifiedBy.equals(that.modifiedBy) : that.modifiedBy != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (previewText != null ? !previewText.equals(that.previewText) : that.previewText != null) return false;
        if (sort != null ? !sort.equals(that.sort) : that.sort != null) return false;
        if (timestampX != null ? !timestampX.equals(that.timestampX) : that.timestampX != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (detailText != null ? detailText.hashCode() : 0);
        result = 31 * result + (modifiedBy != null ? modifiedBy.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (previewText != null ? previewText.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (timestampX != null ? timestampX.hashCode() : 0);
        return result;
    }
}
