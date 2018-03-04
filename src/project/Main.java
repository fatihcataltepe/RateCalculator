package project;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //check arguments
        if (args.length != 2) {

            System.err.println("Missing arguments");
            System.exit(1);
        }

        String path = args[0];
        File file = new File(path);
        System.out.println(file.exists());

        String value = args[1];
        System.out.println(value);
    }
}
