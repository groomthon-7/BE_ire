package com.example.goormthon.model.dto;

import com.example.goormthon.model.entity.Seogipo;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class seogipoDto {
    private Integer id;
    private Double latitude;
    private Double longitude;
    private String businessName;
    private String address;

    public static seogipoDto from(Seogipo seogipo){
        return seogipoDto.builder()
                .id(seogipo.getId())
                .address(seogipo.getAddress())
                .businessName(seogipo.getBusinessName())
                .latitude(seogipo.getLatitude())
                .longitude(seogipo.getLongitude())
                .build();
    }
}
