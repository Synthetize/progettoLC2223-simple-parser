import java.util.ArrayList;
import java.util.Arrays;

public class stringValidation {
    private String string;
    private NFAThompson thompsonGraph;

    public stringValidation(String string, NFAThompson thompsonGraph){
        this.thompsonGraph = thompsonGraph;
        this.string = string;
    }

    public void validation(){
        System.out.println("String to validate: "+ string);
        ArrayList<String> toValidate = new ArrayList<>(Arrays.asList(string.split(",")));
        toValidate.remove(0);
        System.out.println("String to validate: "+ toValidate);
    }
}
