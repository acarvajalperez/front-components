package es.opplus.front;

import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ss/*", name = "CustomServlet", loadOnStartup = 0)
//@VaadinServletConfiguration(ui = TestUI.class, productionMode = false, closeIdleSessions = true)
public class CustomServlet extends VaadinServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        setAccessControlHeaders((HttpServletResponse) res);
        super.service(req, res);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }
}