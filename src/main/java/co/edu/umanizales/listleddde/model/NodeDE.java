package co.edu.umanizales.listleddde.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NodeDE {
    private Led data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE(Led data) {
        this.data = data;
    }
}
