import nl.saxion.app.CsvReader;
import nl.saxion.app.SaxionApp;

import java.awt.*;
import java.util.ArrayList;

public class Application implements Runnable {

    public static void main(String[] args) {
        SaxionApp.start(new Application(), 1024, 768);
    }
    public void run() {
        CsvReader fileReader = new CsvReader("Lists1/Exercise8/titanic-survivors.csv");
        fileReader.setSeparator(','); // This file uses a comma to separate values.
        fileReader.skipRow(); // We need to skip the header because it contains no data, just labels.
        int first = 0;
        int second = 0;
        int third = 0;
        int surv1 = 0;
        int surv2 = 0;
        int surv3 = 0;
        while(fileReader.loadRow()) {
            // TODO: Decide what to do for each row.. That code goes here!
            int valueFromLine = fileReader.getInt(2);
            if(valueFromLine == 3){
                third++;
            } else if (valueFromLine == 2) {
                second++;
            }else{
                first++;
            }

            int valueFromLine2 = fileReader.getInt(1);

            if (valueFromLine == 3 && valueFromLine2 == 1) {
                surv3++;
            } else if (valueFromLine  == 2 && valueFromLine2==1 ) {
                surv2++;
            } else if (valueFromLine == 1 && valueFromLine2 == 1 ) {
                surv1++;
            }



        }
        double procent1= ((  (double)surv1/first)*100);
        double procent2= ((surv2/second))*100;
        double procent3= ((surv3/third))*100;
        SaxionApp.printLine("first class",Color.orange);
        SaxionApp.printLine("number of passengers: " + first);
        SaxionApp.printLine("number of survivors: "+ surv1 );
        SaxionApp.printLine("chance of survival " + procent1);
        SaxionApp.printLine();
        SaxionApp.printLine("second class",Color.orange);
        SaxionApp.printLine("number of passengers: " + second);
        SaxionApp.printLine("number of survivors: "+surv2 );
        SaxionApp.printLine("chance of survival "+ procent2);
        SaxionApp.printLine();
        SaxionApp.printLine("third class",Color.orange);
        SaxionApp.printLine("number of passengers: " + third);
        SaxionApp.printLine("number of survivors: "+ surv3 );
        SaxionApp.printLine("chance of survival "+ procent3);
      //  return 0;


    }
}
