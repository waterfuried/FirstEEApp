/*
    Задание.
        создать сервлет ProductsServlet (/products)
        создать объект Product с 3 полями - id, title, price
        при обращении к /products вывести список из 10 продуктов
*/

import javax.servlet.*;
import javax.servlet.annotation.*;

import java.io.*;

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
        for (int i = 1; i <= MAX_PROD; i++) {
            Product p = new Product(i, "Product #"+i, Product.randomNumber(0, 100));
            resp.getWriter().println(p.getId()+"\t"+p.getTitle()+"\t"+p.getPrice());
        }
    }

    public ServletConfig getServletConfig() { return servletConfig; }

    public String getServletInfo() { return null; }

    public void destroy() {}
}