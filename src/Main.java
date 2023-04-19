import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reminder> reminders = new ArrayList<>();
        Thread t1 = new Thread(new ReminderTask(reminders));
        Scanner scan = new Scanner(System.in);
        boolean flow = true;
        t1.start();
        while (flow) {
            System.out.println("1 - Add Reminder" +
                    "\n2 - Show Reminders" +
                    "\n3 - Exit");
            switch (scan.nextInt()) {
                case 1: {
                    System.out.println("Reminder Due Date" +
                            "\nEnter Year");
                    int year = scan.nextInt();
                    System.out.println("Enter Month");
                    int month = scan.nextInt();
                    System.out.println("Enter Day");
                    int day = scan.nextInt();
                    System.out.println("Enter Hour");
                    int hour = scan.nextInt();
                    System.out.println("Enter Minuets");
                    int minuets = scan.nextInt();
                    Calendar expiration = Calendar.getInstance();
                    expiration.set(year, month-1, day, hour, minuets);
                    if (!expiration.after(Calendar.getInstance())){
                        System.out.println("The date is invalid");
                        break;
                    }
                    System.out.println("Enter Description");
                    String description = scan.next();
                    System.out.println("Is The Task Important?" +
                            "\n1 - Yes" +
                            "\n2 - No");
                    int important = scan.nextInt();
                    Reminder newReminder;
                    if (important == 1)
                        newReminder = new Reminder(expiration, description, true);
                    else if (important == 2) {
                        newReminder = new Reminder(expiration, description, false);
                    } else {
                        System.out.println("Invalid Answer");
                        break;
                    }
                    boolean validation = true;
                    for (Reminder r : reminders) {
                        if (r.equals(newReminder)) {
                            validation = false;
                            System.out.println("Already exists");
                            break;
                        }
                    }
                    if (validation)
                        reminders.add(newReminder);
                    break;
                }
                case 2: {
                    ArrayList<Reminder> sortedReminders = (ArrayList<Reminder>) reminders.stream().sorted(new Comparator<Reminder>() {
                        @Override
                        public int compare(Reminder o1, Reminder o2) {
                            return o1.getExpiration().getTime().compareTo(o2.getExpiration().getTime());
                        }
                    }).collect(Collectors.toList());
                    System.out.println(sortedReminders);
                    break;
                }
                case 3: {
                    flow = false;
                    System.out.println("bye bye");
                    break;
                }
                default: {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}