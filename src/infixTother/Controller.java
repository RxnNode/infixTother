package infixTother;

import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.awt.*;
import java.time.Instant;

public class Controller {
    //all UI to v
    public TextField inputbox;
    public TextArea LogArea;
    public TextField PrefixTextF;
    public TextField PostfixTextF;
    public TextField PrefixValue;
    public TextField PostfixValue;

    //Make controller accessible
    private static Controller Instance;
    public Controller(){
        Instance = this;
    }
    public static Controller getInstance(){
        return Instance;
    }

    //Submit Button
    public void SetInButtonClicked(){
        logger.ClearLog();
        infixTother.infixTother(inputbox.getText());
    }
    //Reset Button
    public void ResetButtonClicked(){
        logger.ClearLog();
        LogArea.setText(null);
        inputbox.setText(null);
        PostfixTextF.setText(null);
        PrefixTextF.setText(null);
        PrefixValue.setText(null);
        PostfixValue.setText(null);
    }


    public void setPrefixTextF(String f){
        PrefixTextF.setText(f);
    }

    public void setPostfixTextF(String f){
        PostfixTextF.setText(f);
    }

    public  void setPrefixValue(String r){
        PrefixValue.setText(r);
    }

    public void setPostfixValue(String r){
        PostfixValue.setText(r);
    }

    public void setLogArea(String Log){
        LogArea.appendText(Log);
        LogArea.appendText("\n");
    }


}
