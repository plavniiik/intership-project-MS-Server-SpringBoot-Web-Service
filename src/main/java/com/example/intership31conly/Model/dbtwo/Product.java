package com.example.intership31conly.Model.dbtwo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HexFormat;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")

public class Product {
    @EmbeddedId
    private ProductKey productKey;

    @Column(name = "id_base")
    private int id_base;
    @Column(name = "Deleted")
    private byte Deleted;
    @Column(name = "Held")
    private byte Held;

    @Column(name = "document_start_date")
    private java.sql.Timestamp  document_start_date;
    @Column(name = "number_of_document")
    private String number_of_document;
    @Column(name = "price")
    private int price;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "id_org")
    private int id_org;

    @Column(name = "id_stock")
    private int id_stock;


    @Override
    public String toString() {
        return "" + productKey.getUIDDocument() +
                ""+productKey.getLine();
    }
}
