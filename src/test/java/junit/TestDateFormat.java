package junit;

import com.example.foodo.engineering.exception.DateFormatNotValidException;
import com.example.foodo.graphic.controllercli.AddProductCLIController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDateFormat {

    /* FLAVIO CAMPOBASSO
        il seguente test verifica che venga solletava un exception
    quando viene inserito un prodotto con data di scadenza errata.
     */

    @Test
    void testDateFormat(){
        int validDate = 0;
        AddProductCLIController addProductCLIController = new AddProductCLIController();
        try{
            addProductCLIController.addProduct("olive", "200g", "other", "34/13/2022", "34", "13", "2022");
            validDate = 1;
        }catch (DateFormatNotValidException e){
            validDate = 2;
        }catch (Exception ignored){

        }
        assertEquals(2, validDate);//il test va a buon fine perche l'exception viene lanciata

    }
}
