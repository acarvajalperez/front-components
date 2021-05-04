package es.opplus.front;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * A demo of a simple ServletContextListener which is able to e.g. prepare
 * database connectivity before the app starts (and tear it down afterwards).
 * @author Martin Vysny <mavi@vaadin.com>
 */
@WebListener
public class Bootstrap implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(Bootstrap.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("Server starting");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Server stopping");
    }
}
