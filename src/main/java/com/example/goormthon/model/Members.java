package com.example.goormthon.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Members")
public class Members extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(columnDefinition = "NVARCHAR(30) NOT NULL")
    private String loginEmail;
    @Column(columnDefinition = "NVARCHAR(30) NOT NULL")
    private String nickname;
}
