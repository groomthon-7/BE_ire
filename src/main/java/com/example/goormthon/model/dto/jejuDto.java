package com.example.goormthon.model.dto;

import com.example.goormthon.model.entity.Jeju;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class jejuDto {
    private Integer id;
    private Double latitude;
    private Double longitude;
    private String businessName;
    private String address;

    public static jejuDto from(Jeju jeju){
        return jejuDto.builder()
                .id(jeju.getId())
                .businessName(jeju.getBusinessName())
                .address(jeju.getAddress())
                .latitude(jeju.getLatitude())
                .longitude(jeju.getLongitude())
                .build();
    }
}
