package main.utils;

import java.util.UUID;

public class RandomString {

    public static String uid() {

        UUID randomUUID = UUID.randomUUID();

        return "#" + randomUUID.toString().replaceAll("_", "").substring(0 , 8).toUpperCase();
    }
}
