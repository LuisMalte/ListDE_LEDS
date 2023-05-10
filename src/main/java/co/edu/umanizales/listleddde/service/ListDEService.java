package co.edu.umanizales.listleddde.service;


import co.edu.umanizales.listleddde.model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {

    private ListDE leds;


    public ListDEService() {
        leds = new ListDE();


    }



}





