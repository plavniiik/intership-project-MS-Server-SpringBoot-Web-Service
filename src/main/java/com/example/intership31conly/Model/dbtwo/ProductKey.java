package com.example.intership31conly.Model.dbtwo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;
import javax.xml.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductKey implements Serializable {

    @Column(name = "UIDDocument", updatable = false, nullable = false,columnDefinition = "BINARY(16)")
    private UUID UIDDocument;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductKey that = (ProductKey) o;

        if (Line != that.Line) return false;
        return Objects.equals(UIDDocument, that.UIDDocument);
    }

    @Override
    public int hashCode() {
        int result = UIDDocument != null ? UIDDocument.hashCode() : 0;
        result = 31 * result + Line;
        return result;
    }

    @Column(name = "Line")
    private int Line;

    @Override
    public String toString() {
        return  UIDDocument +
                " - " + Line;
    }
    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
