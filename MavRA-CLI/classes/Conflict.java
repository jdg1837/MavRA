package classes;
import java.util.ArrayList;

public class Conflict extends Goal
{
    private int severity;

    public Conflict(String title_in, String location_in, int severity_in)
    { 
        super(title_in, location_in);
        severity = severity_in;
    }

    public int getSeverity() 
    {
        return severity;
    }

    public void setSeverity(int severity) 
    {
        this.severity = severity;
    }
}