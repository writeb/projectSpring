package com.example.project2.events;

import com.example.project2.dto.PhoneBookDTO;

public class PhoneBookEvent {
    private String eventType; // Тип события: "create", "update", "delete"
    private PhoneBookDTO phoneBookDTO; // Данные телефонного справочника, связанные с событием

    // Конструктор, геттеры и сеттеры
    public PhoneBookEvent(){}

    public PhoneBookEvent(String eventType, PhoneBookDTO phoneBookDTO) {
        this.eventType = eventType;
        this.phoneBookDTO = phoneBookDTO;
    }
}
