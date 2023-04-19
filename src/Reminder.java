import java.util.Calendar;
import java.util.Comparator;

public class Reminder {
    private Calendar expiration = Calendar.getInstance();
    private String description;
    private Boolean important = false, popped = false;

    public Reminder(Calendar expiration, String description, Boolean important) {
        this.expiration = expiration;
        this.description = description;
        this.important = important;
    }

    public Calendar getExpiration() {
        return expiration;
    }

    public void setExpiration(Calendar expiration) {
        this.expiration = expiration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getImportant() {
        return important;
    }

    public void setImportant(Boolean important) {
        this.important = important;
    }

    public Boolean getPopped() {
        return popped;
    }

    public void setPopped(Boolean popped) {
        this.popped = popped;
    }

    public boolean equals(Reminder o) {
        long temp1 = this.expiration.getTimeInMillis() / (1000 * 60);
        long temp2 = o.getExpiration().getTimeInMillis() / (1000 * 60);
        if (this.description.compareTo(o.getDescription()) == 0){
            if (temp1 == temp2)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Due: " + getExpiration().getTime() +" - Description: " + getDescription() + " - Popped: " + getPopped() +"\n";
    }
}
