public class Baekjoon10845{
 
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int orderCount = Integer.parseInt(st.nextToken());
        int[] queue = new int[10001];
        int dynamicSize = 0; 
        int bottom = 0;
        List<Integer> outputArray = new ArrayList<>();
        
        for(int i=0; i<orderCount; i++) {
            st = new StringTokenizer(br.readLine());
            
            switch(st.nextToken()) {
                case "push":
                    int inputNum = Integer.parseInt(st.nextToken());
                    
                    queue[dynamicSize] = inputNum;
                    dynamicSize++;
                    break;
                    
                case "pop":
                    
                    if(bottom >= dynamicSize){
                        outputArray.add(-1);
                    }else {
                        outputArray.add(queue[bottom]);
                        bottom++;
                    }
                    break;
                    
                case "size":
                    outputArray.add(dynamicSize-bottom);
                    break;
                    
                case "empty":
                    if(bottom >= dynamicSize) {
                        outputArray.add(1);
                    }else {
                        outputArray.add(0);
                    }
                    break;
                
                case "front":
                    if(bottom >= dynamicSize) {
                        outputArray.add(-1);
                    }else {
                        outputArray.add(queue[bottom]);
                    }
                    break;
                    
                case "back":
                    if(bottom >= dynamicSize) {
                        outputArray.add(-1);
                    }else {
                        outputArray.add(queue[dynamicSize-1]);
                    }
                    break;
            }
        }
        
        for(int output : outputArray) {
            bw.write(output+"\n");
            bw.flush();
        }       
    }
}