package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a file path: ");
        String strPath = sc.nextLine();
        Map<String, Integer> numbersOfVotes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
            String line = br.readLine();

            int sum = 0;
            while (line != null) {
                String[] strings = line.split(",");

                String name = strings[0];
                Integer votes = Integer.parseInt(strings[1]);


                if (numbersOfVotes.containsKey(name)) {
                    int votesSoFar = numbersOfVotes.get(name);
                    numbersOfVotes.put(name, votes + votesSoFar);
                } else {
                    numbersOfVotes.put(name, votes);
                }
                line = br.readLine();
            }

            for (String political : numbersOfVotes.keySet()) {
                System.out.println(political + " : " + numbersOfVotes.get(political));
            }

        } catch (IOException e) {

        }
    }
}