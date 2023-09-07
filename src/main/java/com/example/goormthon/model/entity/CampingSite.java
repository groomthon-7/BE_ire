package com.example.goormthon.model.entity;

import com.example.goormthon.model.dao.CampingSiteDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CampingSite")
public class CampingSite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="businessName")
    private String businessName;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "glampingCount")
    private String glampingCount;
    @Column(name = "caravanCount")
    private String caravanCount;
    @Column(name = "campingDeckCount")
    private String campingDeckCount;
    @Column(name = "outdoorCampingCount")
    private String outdoorCampingCount;
    @Column(name = "hasToilet")
    private String hasToilet;
    @Column(name = "hasShower")
    private String hasShower;
    @Column(name = "hasWashbasin")
    private String hasWashbasin;
    @Column(name = "parkingCapacity")
    private int parkingCapacity;
    @Column(name = "tags")
    private String tags;


}
