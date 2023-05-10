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
            NodeDE temp= head;
            while (temp != null) {

                    temp.getData().setState(true);
                    temp.getData().setDateOn(LocalTime.from(LocalDateTime.now()));



                temp = temp.getNext();

            }


        }
        public void turnOff() {
            NodeDE temp= head;
            while (temp != null) {

                temp.getData().setState(false);
                temp.getData().setDateOff(LocalTime.from(LocalDateTime.now()));



                temp = temp.getNext();

            }


        }

        public void restart() {
            NodeDE temp= head;
            while (temp != null) {
                    temp.getData().setState(false);
                    temp.getData().setDateOff(null);
                    temp.getData().setDateOn(null);

                temp = temp.getNext();

            }


        }








    }






