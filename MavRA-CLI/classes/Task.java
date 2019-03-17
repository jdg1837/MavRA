package classes;
import java.util.ArrayList;
import java.util.Date;

public class Task
{ 
    public String title;
    public String description;
    private ArrayList<String> log = new ArrayList<String>();
    private ArrayList<String> TODO = new ArrayList<String>();
    private boolean completed = false;
    private Date deadline;

	public Task(String title_in)
	{
        title = title_in;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public ArrayList<String> getLog() 
    {
        return log;
    }

    public void setLog(ArrayList<String> log) 
    {
        this.log = log;
    }

    public void addToLog(String entry) 
    {
        this.log.add(entry);
    }

    public void removeFromLog(int entry) 
    {
        this.log.remove(entry);
    }

    public ArrayList<String> getTODO() 
    {
        return TODO;
    }

    public void setTODO(ArrayList<String> tODO) 
    {
        TODO = tODO;
    }

    public void addToTODO(String entry) 
    {
        this.TODO.add(entry);
    }

    public void removeFromTODO(int entry) 
    {
        this.TODO.remove(entry);
    }

    public boolean isCompleted() 
    {
        return completed;
    }

    public void setCompleted(boolean completed) 
    {
        this.completed = completed;
    }

    public Date getDeadline() 
    {
        return deadline;
    }

    public void setDeadline(Date deadline) 
    {
        this.deadline = deadline;
    }
}