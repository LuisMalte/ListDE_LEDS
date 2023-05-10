package co.edu.umanizales.listleddde.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
public class Led {

    private String  id ;
    private boolean  state;
    private LocalTime dateOn;
    private LocalTime dateOff;


public Led(String id)
{
    this.id = id;
    state = false;
}


}
