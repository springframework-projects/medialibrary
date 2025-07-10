//package com.jyx.medialibrary.movies.model;
//
//import com.jyx.medialibrary.common.model.Item;
//import com.jyx.medialibrary.domain.Price;
//import com.jyx.medialibrary.model.enums.Category;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.DiscriminatorValue;
//import jakarta.persistence.Entity;
//
//@Entity
//@DiscriminatorValue("MOVIES")
//public class MovieItem extends Item {
//
//    @Column
//    private String director;
//
//    @Column
//    private Integer runtimeMinutes;
//    
//    @Column
//    private String format;
//    
//    @Column
//    private MovieGenre genre;
//
//    // Default constructor for JPA
//    public MovieItem() {
//        super();
//        this.category = Category.MOVIES;
//    }
//
//    // Constructor
//    public MovieItem(String name, String description, int quantity, Price price, String director, Integer runtimeMinutes) {
//        super(name, description, quantity, Category.MOVIES, price);
//        this.director = director;
//        this.runtimeMinutes = runtimeMinutes;
//    }
//
//    // Getters and Setters
//    public String getDirector() {
//        return director;
//    }
//
//    public void setDirector(String director) {
//        this.director = director;
//    }
//
//    public Integer getRuntimeMinutes() {
//        return runtimeMinutes;
//    }
//
//    public void setRuntimeMinutes(Integer runtimeMinutes) {
//        this.runtimeMinutes = runtimeMinutes;
//    }
//
//    // toString
//    @Override
//    public String toString() {
//        return "MovieItem{" +
//               super.toString() +
//               ", director='" + director + '\'' +
//               ", runtimeMinutes=" + runtimeMinutes +
//               '}';
//    }
//}