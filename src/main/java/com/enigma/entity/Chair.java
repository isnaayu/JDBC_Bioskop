package com.enigma.entity;

public class Chair {
    private Integer id;
    private String seat_number;
    private Integer theater_id;

    public Chair() {
    }

    public Chair(Integer id, String seat_number, Integer theater_id) {
        this.id = id;
        this.seat_number = seat_number;
        this.theater_id = theater_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public Integer getTheater_id() {
        return theater_id;
    }

    public void setTheater_id(Integer theater_id) {
        this.theater_id = theater_id;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "id=" + id +
                ", seat_number='" + seat_number + '\'' +
                ", theater_id=" + theater_id +
                '}';
    }
}
