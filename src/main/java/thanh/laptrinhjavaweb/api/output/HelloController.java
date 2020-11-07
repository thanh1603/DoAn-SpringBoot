package thanh.laptrinhjavaweb.api.output;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    @RequestMapping(value = "hello1", method = RequestMethod.GET)
    public String helloPage() {
        return "web/hello1";
    }
}
