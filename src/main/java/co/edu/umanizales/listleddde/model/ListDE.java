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







