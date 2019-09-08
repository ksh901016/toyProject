package com.corn.toy.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("/init")
    public String init(Model model){
        model.addAttribute("name", "corn");
        return "init";
    }

    @GetMapping("/freemarker")
    public String freemarker(Model model){
        model.addAttribute("name", "corn!!");
        return "freemarker";
    }

    @GetMapping("/jsp/hello")
    public String jsp(){
        return "hello";
    }

    @GetMapping("/exception")
    public String exception(){
        throw new SampleException();
    }

    /*
    @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e){
        AppError error = new AppError();
        error.setMessage("error.app.key");
        error.setReaonse("I don't know");
        return error;
    }*/
}
