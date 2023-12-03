package com.enigma;

import com.enigma.configuration.DbConnector;
import com.enigma.repository.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        CustomerRepo customerRepo = new CustomerRepo();
//        System.out.println(customerRepo.getAll());

//        ChairRepo chairRepo = new ChairRepo();
//        System.out.println(chairRepo.getAll());

//        FilmRepo filmRepo = new FilmRepo();
//        System.out.println(filmRepo.getAll());

//        RatingRepo ratingRepo = new RatingRepo();
//        System.out.println(ratingRepo.getAll());

        TheaterRepo theaterRepo = new TheaterRepo();
        System.out.println(theaterRepo.getAll());
    }
}
