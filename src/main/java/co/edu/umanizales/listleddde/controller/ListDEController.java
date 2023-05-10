package co.edu.umanizales.listleddde.controller;


import co.edu.umanizales.listleddde.controller.dto.ResponseDTO;
import co.edu.umanizales.listleddde.model.Led;
import co.edu.umanizales.listleddde.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/ledlist")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;


    @GetMapping (path = "/add/{id}")
    public ResponseEntity<ResponseDTO> add(@PathVariable String id){


        listDEService.getLeds().add(new Led(id));



        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha adicionado un nuevo led",
                null), HttpStatus.OK);

    }


    @GetMapping
    public ResponseEntity<ResponseDTO> getPets()  {

        return new ResponseEntity<>(new ResponseDTO(
                200, listDEService.getLeds().print(), null), HttpStatus.OK);
    }

    @GetMapping(path = "/addtostar/{id}")
    public ResponseEntity<ResponseDTO> addToStar(@PathVariable String id) {
        listDEService.getLeds().addToStart(new Led(id));
        return new ResponseEntity<>(new ResponseDTO(200, "Led adicionada al inicio", null),
                HttpStatus.OK);

    }

    @GetMapping(path = "/encender")
    public ResponseEntity<ResponseDTO> turnOn()  {
        listDEService.getLeds().turnOn();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se encendieron  todos los leds", null), HttpStatus.OK);
    }

    @GetMapping(path = "/apagar")
    public ResponseEntity<ResponseDTO> turnoff()  {
        listDEService.getLeds().turnOff();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se apagaron  todos los leds", null), HttpStatus.OK);
    }


    @GetMapping(path = "/reiniciar")
    public ResponseEntity<ResponseDTO> restart()  {
        listDEService.getLeds().restart();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se reiniciaron todos los leds", null), HttpStatus.OK);
    }


    @GetMapping(path = "/onof")
    public ResponseEntity<ResponseDTO> turnOnAndOff() throws InterruptedException {
        listDEService.getLeds().turnOnAndOff();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se prendió y apago desde el medio", null), HttpStatus.OK);
    }




}





