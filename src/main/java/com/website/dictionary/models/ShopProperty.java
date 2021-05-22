package com.website.dictionary.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "shop_property", schema = "online_shop", catalog = "")
public class ShopProperty {
    private long id;
    private String name;
    private String active;
    private Timestamp timestampX;
    private String propertyType;
    private String multiple;
    private String title;
    private String sku;
    private Collection<ShopPropertyGuide> shopPropertyGuidesById;
    private Collection<ShopProductsProperty> shopProductsPropertiesById;

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
    @Column(name = "PROPERTY_TYPE", nullable = false, length = -1)
    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Basic
    @Column(name = "MULTIPLE", nullable = false, length = 1)
    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    @Basic
    @Column(name = "TITLE", nullable = false, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

        ShopProperty that = (ShopProperty) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (timestampX != null ? !timestampX.equals(that.timestampX) : that.timestampX != null) return false;
        if (propertyType != null ? !propertyType.equals(that.propertyType) : that.propertyType != null) return false;
        if (multiple != null ? !multiple.equals(that.multiple) : that.multiple != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (timestampX != null ? timestampX.hashCode() : 0);
        result = 31 * result + (propertyType != null ? propertyType.hashCode() : 0);
        result = 31 * result + (multiple != null ? multiple.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shopPropertyByIdPropery")
    public Collection<ShopPropertyGuide> getShopPropertyGuidesById() {
        return shopPropertyGuidesById;
    }

    public void setShopPropertyGuidesById(Collection<ShopPropertyGuide> shopPropertyGuidesById) {
        this.shopPropertyGuidesById = shopPropertyGuidesById;
    }

    @OneToMany(mappedBy = "shopPropertyByIdPropery")
    public Collection<ShopProductsProperty> getShopProductsPropertiesById() {
        return shopProductsPropertiesById;
    }

    public void setShopProductsPropertiesById(Collection<ShopProductsProperty> shopProductsPropertiesById) {
        this.shopProductsPropertiesById = shopProductsPropertiesById;
    }
}
