package com.website.dictionary.models;

import javax.persistence.*;

@Entity
@Table(name = "shop_products_property", schema = "online_shop", catalog = "")
public class ShopProductsProperty {
    private long id;
    private String value;
    private String valueType;
    private double valueNum;
    private String description;
    private ShopProducts shopProductsByIdProdutc;
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
    @Column(name = "VALUE", nullable = false, length = -1)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "VALUE_TYPE", nullable = false, length = 200)
    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @Basic
    @Column(name = "VALUE_NUM", nullable = false, precision = 0)
    public double getValueNum() {
        return valueNum;
    }

    public void setValueNum(double valueNum) {
        this.valueNum = valueNum;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProductsProperty that = (ShopProductsProperty) o;

        if (id != that.id) return false;
        if (Double.compare(that.valueNum, valueNum) != 0) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (valueType != null ? !valueType.equals(that.valueType) : that.valueType != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (valueType != null ? valueType.hashCode() : 0);
        temp = Double.doubleToLongBits(valueNum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTC", referencedColumnName = "ID", nullable = false)
    public ShopProducts getShopProductsByIdProdutc() {
        return shopProductsByIdProdutc;
    }

    public void setShopProductsByIdProdutc(ShopProducts shopProductsByIdProdutc) {
        this.shopProductsByIdProdutc = shopProductsByIdProdutc;
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
