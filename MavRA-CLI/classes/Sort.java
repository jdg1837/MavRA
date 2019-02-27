// Sort resident objects by room number
package classes;
import java.util.*; 
import java.lang.*; 
import java.io.*; 

class Sortbyroll implements Comparator<Resident> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Resident a, Resident b) 
    { 
        return (a.return_id()) - (b.return_id()); 
    } 
} 
  
public class Sort 
{ 
    public ArrayList<Resident> sort_res (ArrayList<Resident> res) 
    { 
        Collections.sort(res, new Sortbyroll()); 
  
        return res;
    } 
}
