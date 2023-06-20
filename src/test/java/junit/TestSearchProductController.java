package junit;
import com.example.foodo.engineering.dao.SearchDAO;
import com.example.foodo.engineering.exception.ProductNotFoundException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestSearchProductController {

    /* FLAVIO CAMPOBASSO
    il seguente test verifica che venga solletava un exception
    quando viene cercato un prodotto non presente nella dispensa o
    non esistente.
     */

    @Test
    void testSearchProduct(){
        int validProduct=0;
        
        try{
            SearchDAO.retriveBySearchText("pallone");
            validProduct = 1;
        }catch(ProductNotFoundException e){
            validProduct = 2;
        }catch (Exception ignored){
        }

        assertEquals(2, validProduct); // il test va a buon fine perche l'exception viene lanciata
    }
}
