package com.example.intership31conly.Model.dbtwo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductKey implements Serializable {

    @Column(name = "UIDDocument", updatable = false, nullable = false)
    private byte[] UIDDocument;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductKey that = (ProductKey) o;
        return Line == that.Line && Arrays.equals(UIDDocument, that.UIDDocument);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(Line);
        result = 31 * result + Arrays.hashCode(UIDDocument);
        return result;
    }

    @Column(name = "Line")
    private int Line;
}
