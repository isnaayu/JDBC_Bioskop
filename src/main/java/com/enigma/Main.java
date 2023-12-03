package com.enigma;

import com.enigma.configuration.DbConnector;
import com.enigma.repository.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Integer id = 1;
        CustomerRepo customerRepo = new CustomerRepo();
//        System.out.println(customerRepo.getAll());
        System.out.println(customerRepo.getByID(1));


        ChairRepo chairRepo = new ChairRepo();
////        System.out.println(chairRepo.getAll());
        System.out.println(chairRepo.getByID(1));

        FilmRepo filmRepo = new FilmRepo();
//        System.out.println(filmRepo.getAll());
        System.out.println(filmRepo.getByID(1));

        RatingRepo ratingRepo = new RatingRepo();
//        System.out.println(ratingRepo.getAll());
        System.out.println(ratingRepo.getByID(1));


        TheaterRepo theaterRepo = new TheaterRepo();
//        System.out.println(theaterRepo.getAll());
        System.out.println(theaterRepo.getByID(1));
    }
}
