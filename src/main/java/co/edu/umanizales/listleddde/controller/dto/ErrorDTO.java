package co.edu.umanizales.listleddde.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private int code;
    private String message;

}
