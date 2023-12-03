package com.enigma;

import com.enigma.configuration.DbConnector;
import com.enigma.entity.*;
import com.enigma.repository.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Integer id = 1;
        CustomerRepo customerRepo = new CustomerRepo();
//        System.out.println(customerRepo.getAll());
//        System.out.println(customerRepo.getByID(1));
//        Customer customer = new Customer();
//        customer.setName("Yuni Pujiastuti");
//        customer.setBirth_date("2001-01-02");
//        customerRepo.save(customer);
//        Customer customer = new Customer();
//        customer.setName("Yuni Puji astuti");
//        customer.setBirth_date("2001-01-02");
//        customer.setId(2);
//        customerRepo.update(customer);
//        customerRepo.delete(2);


        ChairRepo chairRepo = new ChairRepo();
////        System.out.println(chairRepo.getAll());
//        System.out.println(chairRepo.getByID(1));
        Chair chair = new Chair();
//        chair.setSeat_number("3A");
//        chair.setTheater_id(1);
//        chairRepo.save(chair);
//        chair.setSeat_number("1A");
//        chair.setTheater_id(1);
//        chair.setId(1);
//        chairRepo.update(chair);
        chairRepo.delete(5);



        FilmRepo filmRepo = new FilmRepo();
//        System.out.println(filmRepo.getAll());
//        System.out.println(filmRepo.getByID(1));
        Film film = new Film();
//        film.setTitle("Home Alone");
//        film.setDuration(90);
//        film.setPrice(45000);
//        film.setRating_id(2);
//        film.setShow_date("2023-12-25");
//        filmRepo.save(film);
//        film.setId(3);
//        film.setShow_date("2023-12-25");
//        film.setRating_id(1);
//        film.setDuration(75);
//        film.setPrice(50000);
//        film.setTitle("Home Alone 2");
//        filmRepo.update(film);
        filmRepo.delete(3);

        RatingRepo ratingRepo = new RatingRepo();
//        System.out.println(ratingRepo.getAll());
//        System.out.println(ratingRepo.getByID(1));
        Rating rating = new Rating();
//        rating.setCode("K");
//        rating.setDescription("Kartun semua umur");
//        ratingRepo.save(rating);
//        rating.setId(6);
//        rating.setCode("K");
//        rating.setDescription("umum");
//        ratingRepo.update(rating);
        ratingRepo.delete(5);


        TheaterRepo theaterRepo = new TheaterRepo();
//        System.out.println(theaterRepo.getAll());
//        System.out.println(theaterRepo.getByID(1));
//        theaterRepo.save("B", 10,2);
//        Theater theater = new Theater();
//        theater.setTheater_number("C");
//        theater.setStock(10);
//        theater.setFilm_id(3);
//        theaterRepo.save(theater);
//        Theater theater = new Theater();
//        theater.setTheater_number("D");
//        theater.setStock(12);
//        theater.setFilm_id(3);
//        theater.setId(4);
//        theaterRepo.update(theater);
        theaterRepo.delete(4);
    }
}
