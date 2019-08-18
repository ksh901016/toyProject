package com.corn.toy.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/init")
    public String init(Model model){
        model.addAttribute("name", "corn");
        return "init";
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
