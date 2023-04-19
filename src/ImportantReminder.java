public class ImportantReminder implements Runnable {
    private Reminder reminder;

    public ImportantReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000 * 60);
                } catch (InterruptedException e) {}
                System.out.println("The Task: '" + reminder.getDescription() + "' is OverDue!!!!!");
            }
    }
}
