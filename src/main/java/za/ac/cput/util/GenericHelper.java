package za.ac.cput.util;

//Group13
//Capstone - Front-End
//Generic Helper

import java.util.UUID;
public class GenericHelper {

    public static String IDGenerator()
    {
        return UUID.randomUUID().toString();
    }
}
