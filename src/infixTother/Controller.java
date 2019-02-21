package infixTother;

import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import java.awt.*;
import java.time.Instant;

public class Controller {

    public TextField inputbox;
    public TextArea LogArea;
    public TextField PrefixTextF;
    public TextField PostfixTextF;
    public TextField PrefixValue;
    public TextField PostfixValue;

    private static Controller Instance;

    public Controller(){
        Instance = this;
    }

    public static Controller getInstance(){
        return Instance;
    }

    public void SetInButtonClicked(){

        logger.ClearLog();
        infixTother.infixTother(inputbox.getText());
        //TextInput.StrToChar(inputbox.getText());
        //PostfixTextF.setText(infixTother.infixToPostfix(inputbox.getText()));
        //infixTother.infixToPostfix(inputbox.getText());
        //PrefixTextF.setText(infixTother.infixToPrefix(inputbox.getText()));
        //LogArea.appendText("\n");
    }

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
