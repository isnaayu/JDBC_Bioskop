package com.enigma.repository;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingRepo {
    DbConnector dbConnector = new DbConnector();
    private Connection conn = dbConnector.startConnect();

    List<Rating> RatingList = new ArrayList<>();
    public List<Rating> getAll(){
        List<Rating> data = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_rating");
            ResultSet result = pr.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String code = result.getString("code");
                String description = result.getString("description");
                data.add(new Rating(id, code, description));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public Rating getByID(Integer id){
        Rating rating = null;
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_rating WHERE id=?");
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();
            while (result.next()){
                id = result.getInt("id");
                String code = result.getString("code");
                String description = result.getString("description");
                rating = new Rating(id, code, description);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rating;
    }
}
