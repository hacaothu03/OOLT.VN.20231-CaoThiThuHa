package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String filename = "E:\\_2020-06-22-1426-8707-de_inferno--vs-.dem";
        byte[] inputBytes = { 0 };
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (Exception e) {
            System.out.println(e);
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputString = new StringBuilder();
        for (byte b : inputBytes) {
            outputString.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time elapsed when using StringBuilder: " + (endTime - startTime) + "ms");
    }
}