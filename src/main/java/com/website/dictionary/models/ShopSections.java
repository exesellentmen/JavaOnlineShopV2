package com.website.dictionary.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "shop_sections", schema = "online_shop", catalog = "")
public class ShopSections {
    private long id;
    private String name;
    private String active;
    private Timestamp timestampX;
    private Timestamp dateCreate;
    private long createdBy;
    private long modifiedBy;
    private int sort;
    private String picture;
    private String xmlId;
    private String previewText;
    private String detailText;
    private String sku;
    private Collection<ShopSectionProducts> shopSectionProductsById;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ACTIVE", nullable = false, length = 1)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "TIMESTAMP_X", nullable = false)
    public Timestamp getTimestampX() {
        return timestampX;
    }

    public void setTimestampX(Timestamp timestampX) {
        this.timestampX = timestampX;
    }

    @Basic
    @Column(name = "DATE_CREATE", nullable = false)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "CREATED_BY", nullable = false)
    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "MODIFIED_BY", nullable = false)
    public long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Basic
    @Column(name = "SORT", nullable = false)
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "PICTURE", nullable = false, length = -1)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "XML_ID", nullable = false, length = -1)
    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }

    @Basic
    @Column(name = "PREVIEW_TEXT", nullable = false, length = -1)
    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    @Basic
    @Column(name = "DETAIL_TEXT", nullable = false, length = -1)
    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    @Basic
    @Column(name = "SKU", nullable = false, length = -1)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopSections that = (ShopSections) o;

        if (id != that.id) return false;
        if (createdBy != that.createdBy) return false;
        if (modifiedBy != that.modifiedBy) return false;
        if (sort != that.sort) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (timestampX != null ? !timestampX.equals(that.timestampX) : that.timestampX != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        if (xmlId != null ? !xmlId.equals(that.xmlId) : that.xmlId != null) return false;
        if (previewText != null ? !previewText.equals(that.previewText) : that.previewText != null) return false;
        if (detailText != null ? !detailText.equals(that.detailText) : that.detailText != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (timestampX != null ? timestampX.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (int) (createdBy ^ (createdBy >>> 32));
        result = 31 * result + (int) (modifiedBy ^ (modifiedBy >>> 32));
        result = 31 * result + sort;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (xmlId != null ? xmlId.hashCode() : 0);
        result = 31 * result + (previewText != null ? previewText.hashCode() : 0);
        result = 31 * result + (detailText != null ? detailText.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shopSectionsByIdSection")
    public Collection<ShopSectionProducts> getShopSectionProductsById() {
        return shopSectionProductsById;
    }

    public void setShopSectionProductsById(Collection<ShopSectionProducts> shopSectionProductsById) {
        this.shopSectionProductsById = shopSectionProductsById;
    }
}
