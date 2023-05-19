package com.techiteasy.techiteasycontrolleruitwerkingen.dtos;

import com.techiteasy.techiteasycontrolleruitwerkingen.models.Television;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TelevisionDto {
    //id kun je meegeven, maar dit is een afweging. Misschien wil iemand het id wel opvragen.
    private Long id; //property is changed to private. This is to ensure that the id is not directly modified from outside the class.
    @NotNull //dit zorgt dat je kunt controleren en invloed hebt op de inhoud.
    public String type;
    public String brand;
    @NotBlank
    public String name;
    @Min(1) //deze annotaties gebruik je voornamelijk bij input, bij output is dit al gecheckt (behalve misschien wachtwoord)
    public Double price;
    public Double availableSize;
    public Double refreshRate;
    public String screenType;
    public String screenQuality;
    public Boolean smartTv;
    public Boolean wifi;
    public Boolean voiceControl;
    public Boolean hdr;
    public Boolean bluetooth;
    public Boolean ambiLight;
    public Integer originalStock;
    public Integer sold;

    // Constructor
    public TelevisionDto() {
    }

    // Getters:
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }


    // Setters:
    public void setName(String name) {
    }

    public void setBrand(String brand) {
    }


    // Static method to create a TelevisionDto from a Television object
    public static TelevisionDto fromTelevision(Television television) {
        TelevisionDto dto = new TelevisionDto();
        dto.id = television.getId();
        dto.type = television.getType();
        dto.brand = television.getBrand();
        dto.name = television.getName();
        dto.price = television.getPrice();
        dto.availableSize = television.getAvailableSize();
        dto.refreshRate = television.getRefreshRate();
        dto.screenType = television.getScreenType();
        dto.screenQuality = television.getScreenQuality();
        dto.smartTv = television.getSmartTv();
        dto.wifi = television.getWifi();
        dto.voiceControl = television.getVoiceControl();
        dto.hdr = television.getHdr();
        dto.bluetooth = television.getBluetooth();
        dto.ambiLight = television.getAmbiLight();
        dto.originalStock = television.getOriginalStock();
        dto.sold = television.getSold();
        return dto;
    }
}
