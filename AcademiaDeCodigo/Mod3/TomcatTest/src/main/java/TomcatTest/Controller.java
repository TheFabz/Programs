package TomcatTest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.sound.midi.Soundbank;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String startScreen(Model model) {

        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filled")
    public ModelAndView saySecretHello() {

        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("name", "Fábio");
        mv.addObject("email", "fabio@fabio");
        mv.addObject("phone", "910000000");

        return mv;
    }


}
