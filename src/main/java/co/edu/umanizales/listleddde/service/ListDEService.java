package co.edu.umanizales.listleddde.service;


import co.edu.umanizales.listleddde.model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {

    private ListDE pets;


    public ListDEService() {
        pets = new ListDE();


    }



}





