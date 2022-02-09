package com.yedam.myserver.pet.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PetVO {
    private int id;
    private String name;
    private String picture;
    private int age;
    private String breed;
    private String location;
}
