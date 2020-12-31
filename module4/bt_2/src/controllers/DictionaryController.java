package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.SplittableRandom;

@Controller
public class DictionaryController {

    @GetMapping("/translate")
    public String showTranslate(){
        return "translate";
    }

    @GetMapping("/eng-vn")
    public String translate(@RequestParam String eng, Model model){
        String vn;
        switch (eng){
            case "laptop":
                vn = "Máy tính cá nhân";
                break;
            case "bottle":
                vn = "Chai nước";
                break;
            case "mouse":
                vn = "Con chuột";
                break;
            case "desk":
                vn = "Cái bàn học";
                break;
            case "chair":
                vn = "Cái ghế đẩu";
                break;
            default:
                vn = "Not find";
                break;
        }
        model.addAttribute("vn",vn);
        return "translate";
    }
}
