package com.example.project2.utils;

import com.example.project2.events.PhoneBookEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class SerializationUtils {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
            .create();

    public static byte[] serializePhoneBookEvent(PhoneBookEvent phoneBookEvent) {
        try {
            String jsonString = gson.toJson(phoneBookEvent);
            return jsonString.getBytes(); // Преобразование строки в массив байт
        } catch (Exception e) {
            // Обработка ошибок сериализации
            e.printStackTrace();
            return null;
        }
    }
}


