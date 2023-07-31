package Tetteh647;

//*******************************************************************
// Codes.java Java Foundations
//
// Uses a queue to encode and decode messages.
//*******************************************************************
public class Codes
{
    //-----------------------------------------------------------------
// Encode and decode a message using a key of values stored in
// a queue.
//-----------------------------------------------------------------
    public static void main ( String[] args)
    {
        int[] key = {5, 12, -3, 8, -9, 4, 10};
        Integer keyValue;
        String encoded = "", decoded = "";
        String message = "All programmers are playwrights and all " +
                "computers are lousy actors.";
        CircularArrayQueue<Integer> keyQueue1 = new CircularArrayQueue<Integer>();
        CircularArrayQueue<Integer> keyQueue2 = new CircularArrayQueue<Integer>();
// load key queue
        for (int scan=0; scan < key.length; scan++)
        {
            keyQueue1.enqueue (new Integer(key[scan]));
            keyQueue2.enqueue (new Integer(key[scan]));
        }
// encode message
        for (int scan=0; scan < message.length(); scan++)
        {
            keyValue = keyQueue1.dequeue();
            encoded += (char) ((int)message.charAt(scan) + keyValue.intValue());
            keyQueue1.enqueue (keyValue);
        }
        System.out.println ("Encoded Message:\n" + encoded + "\n");
// decode message
        for (int scan=0; scan < encoded.length(); scan++)
        {
            keyValue = keyQueue2.dequeue();
            decoded += (char) ((int)encoded.charAt(scan) - keyValue.intValue());
            keyQueue2.enqueue (keyValue);
        }
        System.out.println ("Decoded Message:\n" + decoded);
    }
}
