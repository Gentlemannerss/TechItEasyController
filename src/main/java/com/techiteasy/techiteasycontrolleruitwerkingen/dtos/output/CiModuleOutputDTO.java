package com.techiteasy.techiteasycontrolleruitwerkingen.dtos.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiModuleOutputDTO {
    private Long id;

    private String name;
    private String type;
    private Double price;
}