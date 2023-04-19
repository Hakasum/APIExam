import java.util.ArrayList;
import java.util.Calendar;

public class ReminderTask implements Runnable {
    ArrayList<Reminder> reminders;

    public ReminderTask(ArrayList<Reminder> reminders) {
        this.reminders = reminders;
    }

    @Override
    public void run() {
            while (true) {
                for (Reminder r : reminders) {
                    Calendar today = Calendar.getInstance();
                    if (r.getExpiration().getTimeInMillis() / (1000 * 60) == today.getTimeInMillis() / (1000 * 60) && !r.getPopped()) {
                        System.out.println("The Task: '" + r.getDescription() + "' is OverDue");
                        if (r.getImportant()) {
                            Thread t1 = new Thread(new ImportantReminder(r));
                            t1.start();
                        }
                        r.setPopped(true);
                    }
                }
                try {
                    Thread.sleep(1000 * 60);
                } catch (InterruptedException e) {
                }
            }
    }
}
