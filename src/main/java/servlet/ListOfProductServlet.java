package servlet;

import com.google.gson.Gson;
import domain.Basket;
import domain.Product;
import dto.BusketDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BasketService;
import service.ProductService;
import service.impl.BasketServerImpl;
import service.impl.ProductServerImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListOfProductServlet extends HttpServlet {
    private BasketService basketService = BasketServerImpl.getBasketServiceImpl();
    private ProductService productService = ProductServerImpl.getProductService();

    public ListOfProductServlet() throws SQLException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Basket> buckets = basketService.readAll();
        Map<Integer, Product> idToProduct = productService.readAllMap();
        List<BusketDto> listOfBucketDtos = map(buckets, idToProduct);

        String json = new Gson().toJson(listOfBucketDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }


    public List<BusketDto> map(List<Basket> buckets, Map<Integer, Product> idToProduct){

        return	buckets.stream().map(bucket->{
            BusketDto bucketDto = new BusketDto();
            bucketDto.bucketId = bucket.getIdBasket();

            Product product = idToProduct.get(bucket.getIdProduct());
            bucketDto.title = product.getTitle();
            bucketDto.description = product.getDescription();
            bucketDto.author = product.getAuthor();
            bucketDto.pages = product.getPages();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());

    }
}
