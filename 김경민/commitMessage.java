import java.time.LocalDate;
public class commitMessage {
  public static void main(String args[]) {
    LocalDate currentDate = LocalDate.now();
    String split[] = args[0].split("\n");
    for (String line : split) {
      if (line.contains("new file:")) {
        String fileName = (line.split(" "))[4];
        System.out.println("[" + currentDate.getYear() % 100 + "." + currentDate.getMonthValue() + "." + currentDate.getDayOfMonth() + "]" + fileName);
      }
    }
  }
}

