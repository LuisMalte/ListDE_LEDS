package co.edu.umanizales.listleddde.model;



import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

    @Data
    public class ListDE {
        private NodeDE head;
        private  int size;
        private  List<Led> ledList = new ArrayList<>();


        public void add(Led led) {
            if (head == null) {
                head = new NodeDE(led);
            } else {
                NodeDE newNode = new NodeDE(led);
                NodeDE temp = head;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(newNode);
                newNode.setPrevious(temp);
            }

            size++;
        }

    public List<Led> print()  {
        ledList.clear();

        NodeDE temp = head;

        while (temp != null) {
            ledList.add(temp.getData());
            temp = temp.getNext();
        }

        return ledList;
    }

        public void addToStart(Led led) {
            NodeDE newNode = new NodeDE(led);
            if (head != null) {
                head.setPrevious(newNode);
                newNode.setNext(head);
            }
            head = newNode;
            size++;
        }

        public void turnOn() {
            if (head != null) {
            NodeDE temp= head;
            while (temp != null) {

                    temp.getData().setState(true);
                    temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));



                temp = temp.getNext();

            }}


        }
        public void turnOff() {
            if (head != null) {
            NodeDE temp= head;
            while (temp != null) {

                temp.getData().setState(false);
                temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));



                temp = temp.getNext();

            }
            }


        }

        public void delete() {
            NodeDE temp= head;
            if (temp != null) {
                head.getNext().setPrevious(null);
                head.setNext(null);
                head=null;

                size=0;


            }


        }


        public void restart() {
            if (head != null) {
            NodeDE temp= head;
            while (temp != null) {
                    temp.getData().setState(false);
                    temp.getData().setDateOff(null);
                    temp.getData().setDateOn(null);

                temp = temp.getNext();

            }
            }


        }

        /*Reviso si la lista no está vacía.
Creo una variable llamada "temp" y la igualo a "head". También creo e inicializo un contador llamado "count" con el valor 1.
Además, creo una variable llamada "start" que me ayudará a encontrar la mitad de la lista.
Luego, verifico si la lista es par o impar. Si es impar, asigno a "start" el valor de (size / 2) + 1 para tener el elemento del medio.
A continuación, recorro la lista mientras "temp" no sea nulo.
Dentro del bucle, verifico si el contador es igual a "start". Si no lo es, incremento el contador en 1 y paso al siguiente nodo.
Si el contador es igual a "start", creo otro nodo llamado "tempNext" y lo igualo a "temp". Esto lo hago para tener un nodo que avance hacia atrás y otro hacia adelante.
Luego, enciendo el nodo "temp" y le asigno la hora actual como su fecha de encendido.
Dentro del mismo "if", recorro la lista mientras "tempNext" tenga un siguiente nodo distinto de nulo. Esto es para asegurarme de que los extremos queden encendidos.
Dentro de este bucle, utilizo Thread.sleep(1000) para pausar durante un segundo.
Apago los dos nodos, "temp" y "tempNext", y les asigno la hora actual como su fecha de apagado.
Después de eso, muevo "temp" al nodo anterior y "tempNext" al siguiente nodo. Logrando asi que un “temp” vaya adelante y otro atrás
Enciendo estos nuevos nodos "temp" y "tempNext" y les asigno la hora actual como su fecha de encendido.
Una vez que salgo del bucle, detengo la iteración ya que se cumple la condición si el contador es igual a "start", ya que no tendría sentido seguir recorriendo la lista


En caso de la lista no sea impar
Hallo “start” dividiendo por 2
Recorro el bulce mientras temp  no sea nulo
Dentro del bucle, verifico si el contador es igual a "start". Si no lo es, incremento el contador en 1 y paso al siguiente nodo.
Si el contador es igual a "start", creo otro nodo llamado "tempNext" y lo igualo a "temp.getNext". Esto lo hago  para  que tempNext tome el valor siguiente de mi temp y asi tener dos medios y tengan los mismos tiempos de apagado y prendido. Luego uno ira para atrás y el otro para adelante
Luego, enciendo los  nodos  "temp" y  “tempNext ” y les asigno la hora actual como su fecha de encendido.
Dentro del mismo "if", recorro la lista mientras "tempNext" tenga un siguiente nodo distinto de nulo. Esto es para asegurarme de que los extremos queden encendidos.

Dentro de este bucle, utilizo Thread.sleep(1000) para pausar durante un segundo.
Apago los dos nodos, "temp" y "tempNext", y les asigno la hora actual como su fecha de apagado.
 Después de eso, muevo "temp" al nodo anterior y "tempNext" al siguiente nodo. Logrando asi que un temp vaya adelante y otro atrás
Enciendo estos nuevos nodos "temp" y "tempNext" y les asigno la hora actual como su fecha de encendido.
Una vez que salgo del bucle, detengo la iteración ya que se cumple la condición si el contador es igual a "start", ya que no tendría sentido seguir recorriendo la lista.
*/

        public  void turnOnAndOff(){
            if (head != null) {
                NodeDE temp = head;
                int count = 1;
                int start;
                if ((size%2)!=0){
                    start = (size / 2) + 1;
                    while (temp!= null){

                        if (count == start){
                            NodeDE tempNext = temp;
                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));

                            while (tempNext.getNext() != null){

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                temp.getData().setState(false);
                                temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));
                                tempNext.getData().setState(false);
                                tempNext.getData().setDateOff(LocalTime.from(LocalDateTime.now()));

                                temp = temp.getPrevious();
                                tempNext= tempNext.getNext();

                                temp.getData().setState(true);
                                temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                                tempNext.getData().setState(true);
                                tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));



                            }
                            break;

                        }
                        count++;
                        temp= temp.getNext();


                    }




                } else{
                    start = size/2;

                    while (temp!= null){
                        if (count == start){
                            NodeDE tempNext = temp.getNext();
                            temp.getData().setState(true);
                            temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                            tempNext.getData().setState(true);
                            tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));

                            while (tempNext.getNext() != null){

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                                temp.getData().setState(false);
                                temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));
                                tempNext.getData().setState(false);
                                tempNext.getData().setDateOff(LocalTime.from(LocalDateTime.now()));

                                temp = temp.getPrevious();
                                tempNext= tempNext.getNext();

                                temp.getData().setState(true);
                                temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));
                                tempNext.getData().setState(true);
                                tempNext.getData().setDateOn(LocalTime.from(LocalDateTime.now()));




                            }
                        }
                        count++;
                        temp= temp.getNext();

                    }

                }

            }

        }
    }







