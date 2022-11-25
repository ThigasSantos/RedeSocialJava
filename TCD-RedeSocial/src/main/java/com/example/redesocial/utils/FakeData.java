package com.example.redesocial.utils;

import java.io.*;

public final class FakeData {

    public static final String fakeDataFile = "fakeData.json";

    public static String getFakeData() {
        //JSON parser object to parse read file
        try (InputStream reader = FakeData.class.getClassLoader().getResourceAsStream(fakeDataFile))
        {
            return new String(reader.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
