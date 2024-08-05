package zjubiomedit.mafld_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zjubiomedit.mafld_backend.entity.Indicator;


@RestController
public class IndicatorController {
    @GetMapping("/indicator/{phoneNumber}")
    public Indicator getIndicator(@PathVariable String phoneNumber) {
        Indicator indicator=new Indicator();
        /*
        indicator=indicator_his.get(newest)

         */
        indicator.setWeight(65);
        indicator.setWaist(60);
        indicator.setBloodSugar(7);
        return indicator;
    }
}
