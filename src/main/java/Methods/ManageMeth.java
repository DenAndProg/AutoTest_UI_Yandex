package Methods;

import InitialDriver.InitialDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ManageMeth {
    public static Map<Integer, String> handles = new HashMap<Integer, String>();

    public static void setWindowHandels(int position){
        Set<String> mySet = InitialDriver.driver.getWindowHandles();
        handles.clear();
        int i = 0;
       for(String g : mySet){
           handles.put(i, g);
           i++;
       }
        InitialDriver.driver.switchTo().window(handles.get(position));
    }

}
