import java.time.LocalDate;
public class commitMessage {
  public static void main(String args[]) {
    LocalDate currentDate = LocalDate.now();
    String split[] = args[0].split("\n");
    for (String line : split) {
      System.out.println(line + "1");
      if (line.contains("new file:") || line.contains("modified:")) {
        String lines[] = line.split(" ");
        String fileName = "";
        for (String temp : lines) {
          if (temp.length() > 0 && temp.charAt(0) != '\t' && !temp.equals("file:")) {
            fileName = temp;
            break;
          }
        }
        System.out.println("[" + currentDate.getYear() % 100 + "." + currentDate.getMonthValue() + "." + currentDate.getDayOfMonth() + "]" + fileName);
        break;
      }
    }
  }
}
