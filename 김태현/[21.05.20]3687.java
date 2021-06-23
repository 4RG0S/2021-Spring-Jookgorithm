package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Matchstick {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String min, max;

        for(int i = 0; i < count; i++) {
            min = max = "0";
            int c = Integer.parseInt(br.readLine());
            String tmp = "";

            if(c % 2 == 0) {
                for(int j = 0; j < (c / 2); j++)
                    tmp += "1";
                max = tmp;
            } else {
                for(int j = 0; j < (c / 2 - 1); j++)
                    tmp += "1";
                max = "7" + tmp;
            }
            tmp = "";
            if(c >= 8) {
                int n = c % 7;
                if(n == 1) {
                    tmp += "10";
                    c -= 8;
                } else if(n == 2) {
                    tmp += "1";
                    c -= 2;
                } else if(n == 3) {
                    if(c == 10) {
                        tmp += "22";
                        c -= 10;
                    } else if(c >= 17) {
                        tmp += "200";
                        c -= 17;
                    } else {
                        tmp += "7";
                        c -= 3;
                    }
                } else if(n == 4) {
                    if(c >= 11) {
                        tmp += "20";
                        c -= 11;
                    } else {
                        tmp += "4";
                        c -= 4;
                    }
                } else if(n == 5) {
                    tmp += "2";
                    c -= 5;
                } else if(n == 6) {
                    tmp += "6";
                    c -= 6;
                }
                for(int j = 0; j < c / 7; j++)
                    tmp += "8";
                min = tmp;
            } else {
                if(c == 2) min = "1";
                else if(c == 3) min = "7";
                else if(c == 4) min = "4";
                else if(c == 5) min = "2";
                else if(c == 6) min = "6";
                else if(c == 7) min = "8";
            }
            System.out.println(min + " " + max);
        }
    }

}
