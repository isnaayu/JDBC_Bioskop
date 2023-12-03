package com.enigma.repository;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


}
