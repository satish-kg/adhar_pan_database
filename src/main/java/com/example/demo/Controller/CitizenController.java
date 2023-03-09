package com.example.demo.Controller;

import com.example.demo.DTO.CitizenDTO;
import com.example.demo.Service.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adhar")
public class CitizenController {

    @Autowired
    CitizenService citizenService;

    @PostMapping("/addCitizen")
    public ResponseEntity<String> addCitizen(@RequestBody CitizenDTO citizenDTO){
        try{
            String result = citizenService.addCitizen(citizenDTO);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/findByAdhar")
    public String findByAdhar(@RequestParam("adhar")String adhar) throws Exception {
        String result = "";
        result = result + citizenService.findPanByAdhar(adhar);
        result = result +" "+ citizenService.findNameByAdhar(adhar);
//        String result = citizenService.findNameByAdhar(adhar);
        return result;
    }

    @GetMapping("/findByPan")
    public String findByPanNo(@RequestParam("panNo")String panNo){
        String result = citizenService.findAdharByPanNo(panNo);
        result = result +" "+ citizenService.findNameByPanNo(panNo);
        return result;
    }


}
