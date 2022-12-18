package com.example.tirowedding;
//data base ekata  value danna kailn store karana model class eka
//use karanawa meka
public class Feedmodel {

    private  int id;
    private  String  feedback;

    public Feedmodel(){

    }


    public Feedmodel(int id, String feedback){

        this.id=id;
        this.feedback=feedback;



    }

    public Feedmodel(String feedback){
        this.feedback=feedback;


    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }





















}
