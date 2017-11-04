package calender;

import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.Summary;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class iCal {

    //private String csvFile;
    private File csvFile;
    List<vEvent> eventList = new ArrayList<>();

    iCal(File file){
        this.csvFile = file;
    }

    public void createCalenderFile(List<vEvent> eventList){
        ICalendar ical = new ICalendar();
        VEvent event = new VEvent();
        
    }

    List createEvents(List<String[]> calStrings){
        List<vEvent> evList = new ArrayList<>();

        for(int z = 1; z < calStrings.size(); z++){
            vEvent csvEvent = new vEvent();
            //TODO find more efficiant way to do this
            if(calStrings.get(z)[0] != null){
                csvEvent.setTerminName(calStrings.get(z)[0]);
            }
            if(calStrings.get(z)[1] != null){
                csvEvent.setStartDate(calStrings.get(z)[1]);
            }
            if(calStrings.get(z)[2] != null){
                csvEvent.setStartTime(calStrings.get(z)[2]);
            }
            if(calStrings.get(z)[3] != null){
                csvEvent.setEndDate(calStrings.get(z)[3]);
            }
            if(calStrings.get(z)[4] != null){
                csvEvent.setEndTime(calStrings.get(z)[4]);
            }
            if(calStrings.get(z)[5] != null){
                csvEvent.setPlace(calStrings.get(z)[5]);
            }
            if(calStrings.get(z)[6] != null){
                csvEvent.setRepeat(calStrings.get(z)[6]);
            }
            if(calStrings.get(z)[7] != null){
                csvEvent.setDesc(calStrings.get(z)[7]);
            }
            if(calStrings.get(z)[8] != null){
                csvEvent.setWholeDay(calStrings.get(z)[8]);
            }
            evList.add(csvEvent);
            }
        return evList;
    }

    void readCSV() {

        try{
            String filePath = csvFile.getCanonicalPath();
            CSVReader reader2 = new CSVReader(new FileReader(filePath), ',');

            String [] nextLine;
            List<String[]> calStrings = new ArrayList<>();
           while ((nextLine = reader2.readNext()) != null) {
                   calStrings.add(nextLine);
            }

           List<vEvent> eventList;

           eventList = createEvents(calStrings);
           createCalenderFile(eventList);
           /*
           for(int i = 0; i < eventList.size(); i++){
               eventList.get(i).printElement();
           }

    for(int z = 0; z < calStrings.size(); z++){
        for(int y = 0; y < calStrings.get(z).length; y++) {
            System.out.print(calStrings.get(z)[y] + " ");
               }
               System.out.print("\n");
    }
    */
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

}
