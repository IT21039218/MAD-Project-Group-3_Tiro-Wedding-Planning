package com.example.tirowedding;

public class Model {

    private  int id;
    private  String ordername;
    private  String orderid;
    private  String orderdetail;


    public Model(int id, String ordername, String orderid, String orderdetail) {
        this.id = id;
        this.ordername = ordername;
        this.orderid = orderid;
        this.orderdetail = orderdetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(String orderdetail) {
        this.orderdetail = orderdetail;
    }
}
