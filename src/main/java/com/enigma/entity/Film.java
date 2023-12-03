package com.enigma.entity;

public class Film {
    private Integer id;
    private String title;
    private Integer duration;
    private String show_date;
    private Integer price;
    private Integer rating_id;

    public Film() {
    }

    public Film(Integer id, String title, Integer duration, String show_date, Integer price, Integer rating_id) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.show_date = show_date;
        this.price = price;
        this.rating_id = rating_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getShow_date() {
        return show_date;
    }

    public void setShow_date(String show_date) {
        this.show_date = show_date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getRating_id() {
        return rating_id;
    }

    public void setRating_id(Integer rating_id) {
        this.rating_id = rating_id;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", show_date='" + show_date + '\'' +
                ", price=" + price +
                ", rating_id=" + rating_id +
                '}';
    }
}
