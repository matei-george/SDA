package exercise;

public class Clocktime {
    private int hour;
    private int minute;
    private String amPm;

    // Constructs a new time for the given hour/minute
    public Clocktime(int h, int m, String ap){
        this.hour=h;
        this.minute=m;
        this.amPm=ap;
    }
    public void advance(int timeframe){
        this.minute+=timeframe;
        if(this.minute>=60){
            this.hour+=this.minute/60;
            this.minute=this.minute%60;
        }
        if(this.hour>=12 && this.amPm=="AM"){
            this.hour=this.hour%12+1;
            this.amPm="PM";
        }
        else if(this.hour>=12 && this.amPm=="PM"){
            this.hour=this.hour%12;
            this.amPm="AM";
        }
        System.out.println(this.toString());
    }
    // returns the field values
    public int getHour(){return hour;}
    public int getMinute(){return minute;}
    public String getAmPm(){return amPm;}
    // returns a String for this time; for example, "6:27 PM"
    public String toString(){
        return hour+":"+minute+" "+amPm;
    }
    public boolean isWorkTime(){
        if(this.hour <=9 && this.amPm=="AM")
            return false;
        else if (this.hour >=5 && this.amPm=="PM")
            return false;
        else
            return true;
    }
}
