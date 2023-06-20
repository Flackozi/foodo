package junit;
import com.example.foodo.controllerappl.LoginController;
import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.LoginBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.dao.SearchDAO;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.model.ProductModel;
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
            SearchDAO.retriveBySearchText("flacko");
            validProduct = 1;
        }catch(ProductNotFoundException e){
            validProduct = 2;
        }catch (Exception ignored){
        }

        assertEquals(2, validProduct);
    }
}
