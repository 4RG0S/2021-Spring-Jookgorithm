import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] tokens = new int[10];

        for(int i = 0; i < s.length(); i++){
            tokens[Integer.parseInt(String.valueOf(s.charAt(i)))] += 1;
        }

        tokens[6] = (tokens[6] + tokens[9])/2 + (tokens[6] + tokens[9])%2;
        tokens[9] = 0;

        Arrays.sort(tokens);
        System.out.print(tokens[9]);
    }
}