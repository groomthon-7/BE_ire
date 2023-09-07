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
@Entity(name = "campingsite")
public class CampingSite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name="businessname")
    private String businessName;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "glampingcount")
    private String glampingCount;
    @Column(name = "caravancount")
    private String caravanCount;
    @Column(name = "campingdeckcount")
    private String campingDeckCount;
    @Column(name = "outdoorcampingcount")
    private String outdoorCampingCount;
    @Column(name = "hastoilet")
    private String hasToilet;
    @Column(name = "hasshower")
    private String hasShower;
    @Column(name = "haswashbasin")
    private String hasWashbasin;
    @Column(name = "parkingcapacity")
    private int parkingCapacity;
    @Column(name = "tags")
    private String tags;

    @Column(name="img")
    private String img;

}
