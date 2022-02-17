package log4shell.vulnerableapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static java.lang.System.out;

@RestController
public class MainController {

    private static final Logger logger = LogManager.getLogger("HelloWorld");

    @GetMapping("/param")
    public String index(@RequestParam("some-parameter") String param) {
        logger.info("Parameter: " + param);
        return "<h1>Hello, world!</h1>"+"<h3>Recived param: "+ param+"</h3>";
    }

    @GetMapping("/header")
    public String index2(@RequestHeader("some-parameter") String param) {
        logger.info("Parameter: " + param);
        return "<h1>Hello, world!</h1>"+"<h3>Recived param: "+ param+"</h3>";
    }
}