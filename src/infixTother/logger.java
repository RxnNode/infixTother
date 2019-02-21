

package infixTother;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class logger {

    private static String StackLog = "";
    private static String CurrentOutput = "";


    public static void StackPushLog(char Log, String Name){
        StackLog = StackLog + Log;
        Controller.getInstance().setLogArea("["+Name+"]Push in：" + Log);
        Controller.getInstance().setLogArea("["+Name+"]Current Stack：" + StackLog);
        OutputLog('\0', Name);
    }

    public static void StackPopLog(char Log, String Name){
        if (!StackLog.isEmpty() && StackLog.charAt(StackLog.length()-1) == Log){
            StackLog = StackLog.substring(0,StackLog.length()-1);
        }
        Controller.getInstance().setLogArea("["+Name+"]Now Pop：" + Log);
        Controller.getInstance().setLogArea("["+Name+"]Current Stack：" + StackLog);
        if (Log !='(' && Log !=')')OutputLog(Log, Name);
    }

    public static void OutputLog(char OLog, String Name){
        if (OLog != '\0') {
            CurrentOutput = CurrentOutput + OLog;
            Controller.getInstance().setLogArea("[" + Name + "]Output：" + CurrentOutput);
        }System.out.println("Skip null");
    }

    public static void MessageLog(String Message, String Name){
        Controller.getInstance().setLogArea("["+Name+"]"+Message);
    }

    public static void UnnamedMessageLog(String  NnMessage){
        Controller.getInstance().setLogArea(NnMessage);
    }

    public static void ClearLog(){
        StackLog = "";
        CurrentOutput = "";
    }
}
