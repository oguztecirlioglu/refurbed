package com.github.oguztecirlioglu.refurbedservice.domain.dto;

import com.github.oguztecirlioglu.refurbedservice.domain.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ProductTypeDTO {

    @Setter @Getter
    private ProductType type;

    public ProductTypeDTO(ProductType productType) {
        setType(productType);
    }
}
