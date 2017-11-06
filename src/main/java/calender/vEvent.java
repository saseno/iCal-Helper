package calender;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class vEvent {
    private String terminName;
    private Date startDate;
    private String startTime;
    private Date endDate;
    private String endTime;
    private String place;
    private String repeat;
    private String desc;
    private String wholeDay;

    vEvent(){}
    public void setTerminName(String terminName){this.terminName = terminName;}

    public void setStartDate(String startDate) throws ParseException {
        if(getStartTime() != null){
            String tStartTime = getStartTime();
            startDate = startDate + " " + tStartTime;
            Date date = new SimpleDateFormat("dd.MM.yy HH:mm").parse(startDate);
            String dateString2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString2);
            this.startDate = parsedDate;
        }else {
            Date date = new SimpleDateFormat("dd.MM.yy").parse(startDate);
            String dateString2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString2);
            this.startDate = parsedDate;
        }
    }
    public void setStartTime(String startTime){this.startTime = startTime;}
    public void setEndDate(String endDate) throws ParseException {
        if(getEndTime() != null){
            String tEndTime = getEndTime();
            endDate = endDate + " " + tEndTime;
            Date date = new SimpleDateFormat("dd.MM.yy HH:mm").parse(endDate);
            String dateString2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString2);
            this.endDate = parsedDate;
        }else {
            Date date = new SimpleDateFormat("dd.MM.yy").parse(endDate);
            String dateString2 = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
            Date parsedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString2);
            this.endDate = parsedDate;
        }
    }
    public void setEndTime(String endTime){this.endTime = endTime;}
    public void setPlace(String place){this.place = place;}
    public void setRepeat(String repeat){this.repeat = repeat;}
    public void setDesc(String desc){this.desc = desc;}
    public void setWholeDay(String wholeDay){this.wholeDay = wholeDay;}

    public String getDesc() { return desc; }
    public Date getEndDate() { return endDate; }
    public String getEndTime() { return endTime; }
    public String getPlace() { return place; }
    public String getRepeat() { return repeat; }
    public Date getStartDate() { return startDate; }
    public String getStartTime() { return startTime; }
    public String getTerminName() { return terminName; }
    public String getWholeDay() { return wholeDay; }

    public void printElement(){
        System.out.print("\n--------------------------------\n");
        System.out.print("Name: " + getTerminName() + " am " + getStartDate());
        if(startTime != null){
            System.out.print(":"+getStartTime());
        }
        if(endDate != null){
            System.out.print(" endet am " + getEndDate());
        }
        if(endTime != null){
            System.out.print(":" + getEndTime());
        }
        if(desc != null){
            System.out.print(" Beschreibung: " + getDesc());
        }
        if(place!= null){
            System.out.print(" in " + getPlace());
        }
        if(wholeDay != null){
            System.out.print(" ganztägig " + getWholeDay());
        }
        if(repeat != null){
            System.out.print(" Wiederholt sich: " + getRepeat());
        }

    }
}
