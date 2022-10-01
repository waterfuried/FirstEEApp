import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.*;

import org.slf4j.*;

@WebServlet(name="ProductsServlet2",urlPatterns="/getProducts")
public class ProductsServlet2 extends HttpServlet {
    private final static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("incoming request: "+req.getContentType());

        resp.getWriter().println("ProductId\tTitle\tPrice\n");
        final int MAX_PROD = 10;
        for (int i = 1; i <= MAX_PROD; i++) {
            Product p = new Product(i, "Product #"+i, Product.randomNumber(0, 100));
            resp.getWriter().println(p.getId()+"\t"+p.getTitle()+"\t"+p.getPrice());
        }
    }
}