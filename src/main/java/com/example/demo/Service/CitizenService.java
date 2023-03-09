package com.example.demo.Service;

import com.example.demo.Convertor.CitizenDTOtoEntityConvertor;
import com.example.demo.Convertor.CitizenDTOtoEntityConvertor.*;
import com.example.demo.DTO.CitizenDTO;
import com.example.demo.Entity.CitizenEntity;
import com.example.demo.Repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {

    @Autowired
    CitizenRepository citizenRepository;

    public String addCitizen(CitizenDTO citizenDTO) throws Exception{
        CitizenEntity citizenEntity = CitizenDTOtoEntityConvertor.citizenDTOtoEntityConvertor(citizenDTO);
        citizenRepository.save(citizenEntity);
        return "Citizen added successfully.";
    }

    public String findPanByAdhar(String adhar){
        String pan = citizenRepository.findPanByAdhar(adhar);
        return pan;
    }
//
    public String findNameByAdhar(String adhar) throws Exception{
        String name = citizenRepository.findNameByAdhar(adhar);
        return name;
    }
//
    public String findAdharByPanNo(String panNo){
        String adhar = citizenRepository.findAdharByPanNo(panNo);
        return adhar;
    }

    public String findNameByPanNo(String panNo){
        String name = citizenRepository.findNameByPanNo(panNo);
        return name;
    }


//    WASTE
//    public CitizenEntity findNameByPanNo(String panNo){
//        CitizenEntity citizenEntity = citizenRepository.findBy();
//        return citizenEntity.getName();
//    }


}
