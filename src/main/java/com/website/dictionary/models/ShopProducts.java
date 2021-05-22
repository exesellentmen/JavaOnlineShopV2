package com.website.dictionary.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "shop_products", schema = "online_shop", catalog = "")
public class ShopProducts {
    private long id;
    private String name;
    private String active;
    private Timestamp dateCreate;
    private String detailText;
    private int modifiedBy;
    private String previewText;
    private int sort;
    private Timestamp timestampX;
    private String sku;
    private int price;
    private int oldPrice;
    private String previewImgUrl;
    private Collection<ShopProductsImage> shopProductsImagesById;
    private Collection<ShopSectionProducts> shopSectionProductsById;
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
    @Column(name = "DATE_CREATE", nullable = false)
    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
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
    @Column(name = "MODIFIED_BY", nullable = false)
    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
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
    @Column(name = "SORT", nullable = false)
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
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
    @Column(name = "SKU", nullable = false, length = -1)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "PRICE", nullable = false, precision = 0)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "OLD_PRICE", nullable = false, precision = 0)
    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Basic
    @Column(name = "PREVIEW_IMG_URL", nullable = false, length = -1)
    public String getPreviewImgUrl() {
        return previewImgUrl;
    }

    public void setPreviewImgUrl(String previewImgUrl) {
        this.previewImgUrl = previewImgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopProducts that = (ShopProducts) o;

        if (id != that.id) return false;
        if (modifiedBy != that.modifiedBy) return false;
        if (sort != that.sort) return false;
        if (price != that.price) return false;
        if (oldPrice != that.oldPrice) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (dateCreate != null ? !dateCreate.equals(that.dateCreate) : that.dateCreate != null) return false;
        if (detailText != null ? !detailText.equals(that.detailText) : that.detailText != null) return false;
        if (previewText != null ? !previewText.equals(that.previewText) : that.previewText != null) return false;
        if (timestampX != null ? !timestampX.equals(that.timestampX) : that.timestampX != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;
        if (previewImgUrl != null ? !previewImgUrl.equals(that.previewImgUrl) : that.previewImgUrl != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (detailText != null ? detailText.hashCode() : 0);
        result = 31 * result + modifiedBy;
        result = 31 * result + (previewText != null ? previewText.hashCode() : 0);
        result = 31 * result + sort;
        result = 31 * result + (timestampX != null ? timestampX.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + oldPrice;
        result = 31 * result + (previewImgUrl != null ? previewImgUrl.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "shopProductsByIdProduct")
    public Collection<ShopProductsImage> getShopProductsImagesById() {
        return shopProductsImagesById;
    }

    public void setShopProductsImagesById(Collection<ShopProductsImage> shopProductsImagesById) {
        this.shopProductsImagesById = shopProductsImagesById;
    }

    @OneToMany(mappedBy = "shopProductsByIdProdutc")
    public Collection<ShopSectionProducts> getShopSectionProductsById() {
        return shopSectionProductsById;
    }

    public void setShopSectionProductsById(Collection<ShopSectionProducts> shopSectionProductsById) {
        this.shopSectionProductsById = shopSectionProductsById;
    }

    @OneToMany(mappedBy = "shopProductsByIdProdutc")
    public Collection<ShopProductsProperty> getShopProductsPropertiesById() {
        return shopProductsPropertiesById;
    }

    public void setShopProductsPropertiesById(Collection<ShopProductsProperty> shopProductsPropertiesById) {
        this.shopProductsPropertiesById = shopProductsPropertiesById;
    }
}
