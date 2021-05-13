import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Gold_2_10775 {
    static int result = 0;
    static int parent[];
    static int findParent(int input) {
        if (parent[input] == input) {
            return input;
        }
        return parent[input] = findParent(parent[input]);
    }
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i=0;i<G + 1;i++) {
            parent[i] = i;
        }
        for (int i=0;i<P;i++) {
            int input = Integer.parseInt(br.readLine());
            int ancestor = findParent(input);
            if (ancestor == 0)
                break;
            parent[ancestor] = findParent(ancestor - 1);
            result++;
        }
        System.out.println(result);
    }
}
