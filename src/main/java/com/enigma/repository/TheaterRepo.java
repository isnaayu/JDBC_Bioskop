package com.enigma.repository;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.Chair;
import com.enigma.entity.Customer;
import com.enigma.entity.Theater;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheaterRepo {
    DbConnector dbConnector = new DbConnector();
    private Connection conn = dbConnector.startConnect();

    List<Theater> TheaterList = new ArrayList<>();
    public List<Theater> getAll(){
        List<Theater> data = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_theater");
            ResultSet result = pr.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String theater_number = result.getString("theater_number");
                Integer stock = result.getInt("stock");
                Integer film_id = result.getInt("film_id");
                data.add(new Theater(id, theater_number, stock, film_id));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public Theater getByID(Integer id){
        Theater theater = null;
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_theater WHERE id=?");
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();
            while (result.next()){
                id = result.getInt("id");
                String theater_number = result.getString("theater_number");
                Integer stock = result.getInt("stock");
                Integer film_id = result.getInt("film_id");
                theater = new Theater(id, theater_number, stock, film_id);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return theater;
    }

    public void save(Theater theater){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("INSERT INTO t_theater (theater_number, stock, film_id) VALUES (?,?,?)");
            pr.setString(1,theater.getTheater_number());
            pr.setInt(2,theater.getStock());
            pr.setInt(3, theater.getFilm_id());
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Theater theater){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("UPDATE t_theater SET theater_number=?, stock=?, film_id=? WHERE id=?");
            pr.setString(1,theater.getTheater_number());
            pr.setInt(2,theater.getStock());
            pr.setInt(3, theater.getFilm_id());
            pr.setInt(4, theater.getId());
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
