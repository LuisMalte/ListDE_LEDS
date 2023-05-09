package co.edu.umanizales.listleddde.controller;

import co.edu.umanizales.listleddde.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/listde")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;






}





