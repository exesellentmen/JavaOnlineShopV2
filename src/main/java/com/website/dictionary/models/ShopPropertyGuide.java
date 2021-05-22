package com.website.dictionary.models;

import javax.persistence.*;

@Entity
@Table(name = "shop_property_guide", schema = "online_shop", catalog = "")
public class ShopPropertyGuide {
    private long id;
    private String name;
    private String xmlId;
    private String description;
    private String fullDescription;
    private ShopProperty shopPropertyByIdPropery;

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
    @Column(name = "XML_ID", nullable = false, length = -1)
    public String getXmlId() {
        return xmlId;
    }

    public void setXmlId(String xmlId) {
        this.xmlId = xmlId;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "FULL_DESCRIPTION", nullable = false, length = -1)
    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopPropertyGuide that = (ShopPropertyGuide) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (xmlId != null ? !xmlId.equals(that.xmlId) : that.xmlId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (fullDescription != null ? !fullDescription.equals(that.fullDescription) : that.fullDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (xmlId != null ? xmlId.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (fullDescription != null ? fullDescription.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PROPERY", referencedColumnName = "ID", nullable = false)
    public ShopProperty getShopPropertyByIdPropery() {
        return shopPropertyByIdPropery;
    }

    public void setShopPropertyByIdPropery(ShopProperty shopPropertyByIdPropery) {
        this.shopPropertyByIdPropery = shopPropertyByIdPropery;
    }
}
