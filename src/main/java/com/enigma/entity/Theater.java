package com.enigma.entity;

public class Theater {
    private Integer id;
    private String theater_number;
    private Integer stock;
    private Integer film_id;

    public Theater() {
    }

    public Theater(Integer id, String theater_number, Integer stock, Integer film_id) {
        this.id = id;
        this.theater_number = theater_number;
        this.stock = stock;
        this.film_id = film_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheater_number() {
        return theater_number;
    }

    public void setTheater_number(String theater_number) {
        this.theater_number = theater_number;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    @Override
    public String toString() {
        return "TheaterRepo{" +
                "id=" + id +
                ", theater_number='" + theater_number + '\'' +
                ", stock=" + stock +
                ", film_id=" + film_id +
                '}';
    }
}
