package com.techiteasy.techiteasycontrolleruitwerkingen.dtos.input;

import com.techiteasy.techiteasycontrolleruitwerkingen.models.Television;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TelevisionInputDto {
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
    public TelevisionInputDto() {
    }

    // Getter and Setter methods

    // Function to convert TelevisionInputDto to Television
    public Television toTelevision() {
        Television television = new Television();
        television.setId(this.id);
        television.setType(this.type);
        television.setBrand(this.brand);
        television.setName(this.name);
        television.setPrice(this.price);
        television.setAvailableSize(this.availableSize);
        television.setRefreshRate(this.refreshRate);
        television.setScreenType(this.screenType);
        television.setScreenQuality(this.screenQuality);
        television.setSmartTv(this.smartTv);
        television.setWifi(this.wifi);
        television.setVoiceControl(this.voiceControl);
        television.setHdr(this.hdr);
        television.setBluetooth(this.bluetooth);
        television.setAmbiLight(this.ambiLight);
        television.setOriginalStock(this.originalStock);
        television.setSold(this.sold);
        return television;
    }
}
