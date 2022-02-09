package com.yedam.myserver.pet.vo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AdoptVO {
    private int id;
    private int price;
    
    public void setId(int id) {
    	this.id = id;
    }
    public void setPrice(int price) {
    	this.price = price;
    }
    public int getId() {
    	return this.id;
    }
    public int getPrice() {
    	return this.price;
    }
}
