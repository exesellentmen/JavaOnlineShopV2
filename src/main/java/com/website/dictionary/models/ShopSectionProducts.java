package com.website.dictionary.models;

import javax.persistence.*;

@Entity
@Table(name = "shop_section_products", schema = "online_shop", catalog = "")
public class ShopSectionProducts {
    private long id;
    private ShopProducts shopProductsByIdProdutc;
    private ShopSections shopSectionsByIdSection;

    @Id
    @Column(name = "ID", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopSectionProducts that = (ShopSectionProducts) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
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
    @JoinColumn(name = "ID_SECTION", referencedColumnName = "ID", nullable = false)
    public ShopSections getShopSectionsByIdSection() {
        return shopSectionsByIdSection;
    }

    public void setShopSectionsByIdSection(ShopSections shopSectionsByIdSection) {
        this.shopSectionsByIdSection = shopSectionsByIdSection;
    }
}
