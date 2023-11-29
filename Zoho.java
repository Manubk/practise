import java.util.HashMap;
import java.util.Map;

public class Zoho {
    /* 
     * input  aaabbcccc
       output a3b2c4
     * 
    */
    public static String stringEncode(String val){
        int len = val.length();
        int count = 0;
        char firstChar = val.charAt(0);
        String encodedVal ="";

        for(int i=0;i<len;i++){
            if(val.charAt(i) != firstChar){
                encodedVal = encodedVal + firstChar +count;
                firstChar = val.charAt(i);
                count =1;
            }else{
                count++;
            }
        }

        return encodedVal + firstChar +count;
    }


    /* 
     * input  a3b2c4
       output aaabbcccc
     * 
    */
    public static String stringDecode(String val){

        int len = val.length();
        char tempVal ;
        int charLoop = 0 ;
        String decodedVal = "";

        for(int i=0;i<len-1;i++){
            if(Character.isAlphabetic(val.charAt(i))){
                tempVal = val.charAt(i);

                if(Character.isDigit(val.charAt(i+1))){
                    charLoop = charLoop*10 +Character.getNumericValue(val.charAt(i+1));
                    i++;

                    if(i<len && Character.isDigit(i+1)){
                        charLoop = charLoop*10 + Character.getNumericValue(val.charAt(i+1));
                        i++;
                    }

                }

                for(int j=0;j<charLoop;j++){
                    decodedVal = decodedVal + tempVal;
                }

                charLoop =0;

            }
        }

        return decodedVal;
    }
}
