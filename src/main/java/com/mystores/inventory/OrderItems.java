package com.mystores.inventory;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Data
public class OrderItems {

        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        private String orderItemId;

        private String sku;

        @NumberFormat(pattern = "###.##")
        private float unitPrice;

        private long soldQuantity;

        @OneToMany(mappedBy = "orderItems")
        private Collection<Orders> ordercollection;

        @OneToMany(mappedBy = "orderItems")
        private Collection<Products> productsCollection;

        public Collection<Orders> getOrdercollection() {
                return ordercollection;
        }

        public void setOrdercollection(Collection<Orders> orderscoll) {
                this.ordercollection = orderscoll;
        }

        public String getOrderItemId() {
                return orderItemId;
        }

        public void setOrderItemId(String orderItemId) {
                this.orderItemId = orderItemId;
        }

        public String getSku() {
                return sku;
        }

        public void setSku(String sku) {
                this.sku = sku;
        }

        public float getUnitPrice() {
                return unitPrice;
        }

        public void setUnitPrice(float unitPrice) {
                this.unitPrice = unitPrice;
        }

        public long getSoldQuantity() {
                return soldQuantity;
        }

        public void setSoldQuantity(long soldQuantity) {
                this.soldQuantity = soldQuantity;
        }

        public Collection<Products> getProductsCollection() {
                return productsCollection;
        }

        public void setProductsCollection(Collection<Products> productsCollection) {
                this.productsCollection = productsCollection;
        }
}
