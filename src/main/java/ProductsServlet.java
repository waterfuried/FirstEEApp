import javax.servlet.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;

import org.slf4j.*;

@WebServlet(name="ProductsServlet",urlPatterns="/products")
public class ProductsServlet implements Servlet {
    private final static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);
    private transient ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        logger.info("servlet="+servletConfig.getServletName());
        logger.info("incoming request: "+req.getContentType());

        resp.getWriter().println("ProductId\tTitle\tPrice\n");
        final int MAX_PROD = 10;
        List<Product> prods = new ArrayList<>();
        for (int i = 1; i <= MAX_PROD; i++) {
            prods.add(new Product(i, "Product #" + i, Product.randomNumber(0, 100)));
            resp.getWriter().println(prods.get(i-1).getId()+"\t"+prods.get(i-1).getTitle()+"\t"+prods.get(i-1).getPrice());
        }
    }

    public ServletConfig getServletConfig() { return servletConfig; }

    public String getServletInfo() { return null; }

    public void destroy() {}
}