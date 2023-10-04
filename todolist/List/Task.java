package List;

public class Task {
    private String title;
    private String description;
    private String Duodate;
    private boolean completed;

    public Task() {

    }

    public Task(String title, String description, String duodate) {
        this.title = title;
        this.description = description;
        Duodate = duodate;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuodate() {
        return Duodate;
    }

    public void setDuodate(String duodate) {
        Duodate = duodate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
