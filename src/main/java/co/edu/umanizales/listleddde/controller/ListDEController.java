package co.edu.umanizales.listleddde.controller;

import co.edu.umanizales.listleddde.controller.dto.LedDTO;
import co.edu.umanizales.listleddde.controller.dto.ResponseDTO;
import co.edu.umanizales.listleddde.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/LedListDE")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;


    @PostMapping (path = "/add")
    public ResponseEntity<ResponseDTO> addKid(@RequestBody LedDTO ledDTO){
        listDEService.getPets().add(
                    new Pet(ledDTO.getIdentification(),
                            ledDTO.getNameOwner(),ledDTO.getName(), ledDTO.getSex().charAt(0),ledDTO.getSpecies(),ledDTO.getAge(),location));



        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha adicionado la mascota",
                null), HttpStatus.OK);

    }



}





