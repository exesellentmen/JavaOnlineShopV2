package com.website.dictionary.models;

import javax.persistence.*;

@Entity
@Table(name = "shop_products_image", schema = "online_shop", catalog = "")
public class ShopProductsImage {
    private long id;
    private String url;
    private ShopProducts shopProductsByIdProduct;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "URL", nullable = false, length = -1)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProductsImage that = (ShopProductsImage) o;

        if (id != that.id) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID", nullable = false)
    public ShopProducts getShopProductsByIdProduct() {
        return shopProductsByIdProduct;
    }

    public void setShopProductsByIdProduct(ShopProducts shopProductsByIdProduct) {
        this.shopProductsByIdProduct = shopProductsByIdProduct;
    }
}
