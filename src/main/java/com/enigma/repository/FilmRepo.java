package com.enigma.repository;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmRepo {
    DbConnector dbConnector = new DbConnector();
    private Connection conn = dbConnector.startConnect();

    List<Film> FilmList = new ArrayList<>();
    public List<Film> getAll(){
        List<Film> data = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_film");
            ResultSet result = pr.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String title = result.getString("title");
                Integer duration = result.getInt("duration");
                String show_date = result.getString("show_date");
                Integer price = result.getInt("price");
                Integer rating_id = result.getInt("rating_id");
                data.add(new Film(id, title, duration, show_date, price, rating_id));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void save(Film film){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("INSERT INTO t_film (title, duration, show_date, price, rating_id) VALUES (?,?,?,?,?)");
            pr.setString(1,film.getTitle());
            pr.setInt(2,film.getDuration());
            pr.setDate(3, Date.valueOf(film.getShow_date()));
            pr.setInt(4,film.getPrice());
            pr.setInt(5,film.getRating_id());
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Film film){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("UPDATE t_film SET title=?, duration=?, show_date=?, price=?, rating_id=? WHERE id=?");
            pr.setString(1,film.getTitle());
            pr.setInt(2,film.getDuration());
            pr.setDate(3, Date.valueOf(film.getShow_date()));
            pr.setInt(4,film.getPrice());
            pr.setInt(5,film.getRating_id());
            pr.setInt(6, film.getId());
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public Film getByID(Integer id){
        Film film = null;
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_film WHERE id=?");
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();
            while (result.next()){
                id = result.getInt("id");
                String title = result.getString("title");
                Integer duration = result.getInt("duration");
                String show_date = result.getString("show_date");
                Integer price = result.getInt("price");
                Integer rating_id = result.getInt("rating_id");
                film = new Film(id, title, duration, show_date, price, rating_id);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return film;
    }



}
