import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*;

import org.slf4j.*;

@WebServlet(name="ProductsServlet2",urlPatterns="/getProducts")
public class ProductsServlet2 extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("incoming request: "+req.getContentType());

        resp.getWriter().println("ProductId\tTitle\tPrice\n");
        final int MAX_PROD = 10;
        List<Product> prods = new ArrayList<>();
        for (int i = 0; i < MAX_PROD; i++) {
            prods.add(new Product(i+1, "Product #"+(i+1), Product.randomNumber(0, 100)));
            resp.getWriter().println(prods.get(i).getId()+"\t"+prods.get(i).getTitle()+"\t"+prods.get(i).getPrice());
        }
    }
}