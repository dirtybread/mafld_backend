package zjubiomedit.mafld_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zjubiomedit.mafld_backend.entity.Food;
import zjubiomedit.mafld_backend.entity.FoodUnit;
import zjubiomedit.mafld_backend.service.FoodService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/inputfoodSearch")
    public ResponseEntity<Map<String, Object>> inputfoodSearch(@RequestParam String word) {
        List<Food> foodList = new ArrayList<>();
        String[] foodNames = word.split("，");
        List<Food> tempfoodList =new ArrayList<>();
        for (String foodName : foodNames) {
            tempfoodList = foodService.findByAlias(foodName);
            if (tempfoodList.size()!=0){
                foodList.add(tempfoodList.get(0));
            }
        }
        Map<String, Object> response = new HashMap<>();
        response.put("list", foodList);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/foodunitSearch")
    public ResponseEntity<Map<String, Object>> foodUnitSearch(@RequestParam Integer foodSerialNo) {
        List<FoodUnit> foodUnits = foodService.findBySerialNo(foodSerialNo);
//        System.out.println(foodUnits);
        Map<String, Object> response = new HashMap<>();
        response.put("list", foodUnits);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/foodSearch")
    public ResponseEntity<Map<String, Object>> foodSearch(@RequestParam String name) {
        List<Food> foodList = foodService.findByName(name);
//        System.out.println(foodList);
        Map<String, Object> response = new HashMap<>();
        response.put("list", foodList);
        return ResponseEntity.ok(response);
    }



}
