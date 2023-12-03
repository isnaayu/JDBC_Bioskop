package com.enigma.repository;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.Chair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChairRepo {
    DbConnector dbConnector = new DbConnector();
    private Connection conn = dbConnector.startConnect();

    List<Chair> SeatList = new ArrayList<>();
    public List<Chair> getAll(){
        List<Chair> data = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_seat");
            ResultSet result = pr.executeQuery();
            while (result.next()){
                Integer id = result.getInt("id");
                String seat_number = result.getString("seat_number");
                Integer theater_id = result.getInt("theater_id");
                data.add(new Chair(id, seat_number, theater_id));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return data;
    }

    public void save(Chair chair){

    }

    public Chair update(Integer id){
        return null;
    }

    public Chair delete(Integer id){
        return null;
    }

    public Chair getByID(Integer id){
        return null;
    }




}