package com.eduful9877;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Codes demonstrates the use of queues to encrypt and decrypt messages.
 * @author Kelvin Eduful
 * id = 10889877
 */
public class Codes {

    /**
     * Encode and decode a message using a key of values stored in
     * a queue.
     */
    public static void main(String[] args) {
        int[] key = {5, 12, -3, 8, -9, 4, 10};
        Integer keyValue;
        String encoded = "", decoded = "";

        String message = "All programmers are playwrights and all " +
                "computers are lousy actors.";
        Queue<Integer> encodingQueue = new LinkedList<>();
        Queue<Integer> decodingQueue = new LinkedList<>();

        // load key queues
        for (int scan = 0; scan < key.length; scan++) {
            encodingQueue.add(key[scan]);
            decodingQueue.add(key[scan]);
        }

        // encode message
        for (int scan = 0; scan < message.length(); scan++) {
            keyValue = encodingQueue.remove();
            encoded += message.charAt(scan) + keyValue;
            encodingQueue.add(keyValue);
        }

        System.out.println("Encoded Message:\n" + encoded + "\n");

        // decode the message
        for (int scan = 0; scan < encoded.length(); scan++) {
            keyValue = decodingQueue.remove();
            decoded += encoded.charAt(scan) - keyValue;
            decodingQueue.add(keyValue);
        }
        System.out.println("Decoded Message:\n" + decoded);
    }
}
