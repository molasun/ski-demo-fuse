package com.example.tademo.pojo.common;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseInputDto {
	
    private String id;
    private Date timestamp;
    private String source;
    private String data;

}
