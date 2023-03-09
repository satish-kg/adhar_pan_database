package com.example.demo.Convertor;

import com.example.demo.DTO.CitizenDTO;
import com.example.demo.Entity.CitizenEntity;

public class CitizenDTOtoEntityConvertor {

    public static CitizenEntity citizenDTOtoEntityConvertor(CitizenDTO citizenDTO){

        CitizenEntity citizenEntity = CitizenEntity.builder()
                .adhar(citizenDTO.getAdharId())
                .panNo(citizenDTO.getPanNo())
                .name(citizenDTO.getName())
                .build();

        return citizenEntity;

    }
}
