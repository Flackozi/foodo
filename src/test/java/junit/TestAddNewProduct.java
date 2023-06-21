package junit;

import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.ProductModel;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddNewProduct {


    /*  CARLO MARIA FIORAMANTI
    Questo test verifica che dopo l'aggiunta di una nuova ricetta, chiamando
    un metodo nella DAO che restituisce la lista delle ricette, il numero delle
    ricette sia stato effettivamente incrementato
     */

    @Test
    void AddProduct() throws SQLException, ConnectionDbException {
        int size1;
        int size2;

        ProductDAO productDAO=new ProductDAO();
        List<ProductModel> productModels=new ArrayList<>();
        productModels=productDAO.getAllProduct("flacko");
        size1=productModels.size();
        ProductModel productModel= new ProductModel("Fanta", "1 cassa", "liquid", 12, 6, 2025);
        productDAO.insProduct(productModel, "flacko");
        productModels=productDAO.getAllProduct("flacko");
        size2=productModels.size();

        assertEquals(size1+1, size2); //il test va a buon fine perché il numero delle ricette è stato incrementato
    }
}
