package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    public static String getFirstName(){
        String str = RandomStringUtils.randomAlphabetic(1);
        return ("John"+str);

    }
    public static String getLastName(){
        String str = RandomStringUtils.randomAlphabetic(1);
        return ("Kenedy"+str);

    }
    public static String getUserName(){
        String str = RandomStringUtils.randomAlphabetic(3);
        return ("John"+str);
    }
    public static String getPassword(){
        String str = RandomStringUtils.randomAlphabetic(3);
        return ("John"+str);
    }
    public static String getEmail(){
        String str = RandomStringUtils.randomAlphabetic(3);
        return (str+"@gmail.com");
    }

    public static String getempName(){
       String str = RandomStringUtils.randomAlphabetic(1);
       return ("John"+str);
    }
    public static String getempSal(){
        String str = RandomStringUtils.randomNumeric(5);
        return (str);
    }
    public static String getempAge(){
        String str = RandomStringUtils.randomNumeric(2);
        return (str);
    }



}
