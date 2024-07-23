package com.example.model;

public class Student {

  private int id;
  private String name;
  private String address;
  private double fee;

  public Student() {
  }

  public Student(String name, String address, double fee) {
    this.name = name;
    this.address = address;
    this.fee = fee;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public double getFee() {
    return fee;
  }

  public void setFee(double fee) {
    this.fee = fee;
  }
}
