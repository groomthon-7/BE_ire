package com.example.goormthon.model.dto;

import com.example.goormthon.model.entity.CampingSite;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class detailsDto {
    private Integer id;
    private Double latitude;
    private Double longitude;
    private String phone;
    private String businessName;

    private String img;

    public static detailsDto from(CampingSite campingSite){
        return detailsDto.builder().id(campingSite.getId())
                .businessName(campingSite.getBusinessName())
                .longitude(campingSite.getLongitude())
                .latitude(campingSite.getLatitude())
                .phone(campingSite.getPhoneNumber())
                .img(campingSite.getImg())
                .build();
    }
}
