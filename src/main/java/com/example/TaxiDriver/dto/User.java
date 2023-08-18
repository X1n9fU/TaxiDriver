package com.example.TaxiDriver.dto;

import com.example.TaxiDriver.entity.UserDB;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //손님 정보
    String phone;
    String currentX;
    String currentY;
    String destinationX;
    String destinationY;

    public static User toDTO(UserDB userDB) {
        User user = new User();
        user.setPhone(userDB.getUserName());
        user.setCurrentX(userDB.getCurrentX());
        user.setCurrentY(userDB.getCurrentY());
        user.setDestinationX(userDB.getDestinationX());
        user.setDestinationY(userDB.getDestinationY());
        return user;
    }
}

//기사님 앱