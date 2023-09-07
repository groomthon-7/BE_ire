package com.example.goormthon.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class TagDto {
        private String people;
        private String view;
        private String camp;
        private String weather;
        private List<String> other;

}
