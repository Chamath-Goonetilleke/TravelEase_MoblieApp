package com.example.travelease_mobile.entities;

import com.example.travelease_mobile.dto.ReservationDTO;
import com.example.travelease_mobile.services.response.LoginResponse;

import java.util.List;

public class CurrentUser {
    private static CurrentUser singleton;
    private String nic;
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private Integer state;
    private String imageUrl;
    private String token;
    private List<ReservationDTO> reservationList;
    private List<ReservationDTO> reservationHistory;

    public static CurrentUser getInstance(){
        if(singleton==null){
            singleton = new CurrentUser();
        }
        return singleton;
    }

    public void MapResponse(LoginResponse response){
        this.nic=response.getNic();
        this.title=response.getTitle();
        this.firstName=response.getFirstName();
        this.lastName=response.getLastName();
        this.email=response.getEmail();
        this.phoneNumber=response.getPhoneNumber();
        this.city=response.getCity();
        this.state=response.getState();
        this.imageUrl=response.getImageUrl();
        this.token = response.getToken();

    }

    public static CurrentUser getSingleton() {
        return singleton;
    }

    public String getNic() {
        return nic;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public Integer getState() {
        return state;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getToken() {
        return token;
    }

    public List<ReservationDTO> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<ReservationDTO> reservationList) {
        this.reservationList = reservationList;
    }

    public List<ReservationDTO> getReservationHistory() {
        return reservationHistory;
    }

    public void setReservationHistory(List<ReservationDTO> reservationHistory) {
        this.reservationHistory = reservationHistory;
    }
}
