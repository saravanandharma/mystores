package com.mystores.inventory;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
      ================================================================
       This class uses Spring Boot JPA, generates and maps the tables
       entity at run time, this class captures the Product Entity.

       Author: Saravanan Dharmalingam.
       ================================================================
 */

@Entity
@Data
public class Products {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String sku;

    private int quantity;

    @NumberFormat(pattern = "###.##")
    private float unit_price;

    @ManyToOne
    private OrderItems orderItems;

    public Products() {
    }

    public Products(String sku, String this_is_my_order, int integer, float aFloat) {
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItems orderItems) {
        this.orderItems = orderItems;
    }


}
