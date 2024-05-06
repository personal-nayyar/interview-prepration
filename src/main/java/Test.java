import code.problems.DSImpl.CustomMap;

import java.sql.DriverManager;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        printClassLoaders();
    }
    public static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + CustomMap.class.getClassLoader());

        System.out.println("Classloader of DriverManager:"
                + DriverManager.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}
