package com.example.goormthon.model.dao;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampingSiteDao {
    private Integer id;
    private String businessName;
    private String phoneNumber;
    private String address;
    private Double latitude;
    private Double longitude;
    private String glampingCount;
    private String caravanCount;
    private String campingDeckCount;
    private String outdoorCampingCount;
    private String hasToilet;
    private String hasShower;
    private String hasWashbasin;
    private Integer parkingCapacity;
    private String tags;
}
//    CREATE TABLE `CampingSite` (
//        id INT AUTO_INCREMENT PRIMARY KEY,
//        businessName VARCHAR(255),
//        phoneNumber VARCHAR(20),
//        address VARCHAR(255),
//        latitude DECIMAL(9, 6),
//        longitude DECIMAL(9, 6),
//        glampingCount VARCHAR(255),
//        caravanCount VARCHAR(255),
//        campingDeckCount VARCHAR(255),
//        outdoorCampingCount VARCHAR(255),
//        hasToilet CHAR(1),
//        hasShower CHAR(1),
//        hasWashbasin CHAR(1),
//        parkingCapacity INT,
//        tags VARCHAR(255)
//        );