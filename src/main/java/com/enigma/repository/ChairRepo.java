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
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("INSERT INTO t_seat (seat_number, theater_id) VALUES (?,?)");
            pr.setString(1,chair.getSeat_number());
            pr.setInt(2,chair.getTheater_id());
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(Chair chair){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pr = conn.prepareStatement("UPDATE t_seat SET seat_number=? , theater_id=? WHERE id=? ");
            pr.setString(1, chair.getSeat_number());
            pr.setInt(2, chair.getTheater_id());
            pr.setInt(3, chair.getId());
            pr.executeUpdate();
            conn.commit();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public Chair delete(Integer id){
        return null;
    }

    public Chair getByID(Integer id){
        Chair chair = null;
        try {
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM t_seat WHERE id=?");
            pr.setInt(1, id);
            ResultSet result = pr.executeQuery();
            while (result.next()){
                id = result.getInt("id");
                String seat_number = result.getString("seat_number");
                Integer theater_id = result.getInt("theater_id");
                chair = new Chair(id, seat_number, theater_id);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return chair;
    }


}
