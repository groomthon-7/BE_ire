package com.example.goormthon.model.dto;

import com.example.goormthon.model.entity.CampingSite;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class outPutMap {
    private Integer id;
    private Double latitude;
    private Double longitude;
    private String address;
    private String businessName;

    public outPutMap toEntity(){
        return outPutMap.builder()
                .id(id)
                .latitude(latitude)
                .longitude(longitude)
                .address(address)
                .businessName(businessName)
                .build();
    }
}
