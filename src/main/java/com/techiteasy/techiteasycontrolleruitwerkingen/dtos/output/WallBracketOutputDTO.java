package com.techiteasy.techiteasycontrolleruitwerkingen.dtos.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallBracketOutputDTO {
    private Long id;
    private String size;
    private Boolean ajustable;
    private String name;
    private Double price;
}
