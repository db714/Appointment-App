package lambdas;

import java.time.ZoneId;

/**Class that holds a lambda expression for notifications.*/
public interface Notification_Interface {

    /**Method takes in a zoneId and converts it to a string on the login screen.*/
    //Lambda takes in a ZoneId and converts it to String
    String getMessage(ZoneId curr);
}
