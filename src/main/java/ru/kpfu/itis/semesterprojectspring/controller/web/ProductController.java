package ru.kpfu.itis.semesterprojectspring.controller.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.semesterprojectspring.model.dto.RecordDto;
import ru.kpfu.itis.semesterprojectspring.model.entity.Product;
import ru.kpfu.itis.semesterprojectspring.model.entity.User;
import ru.kpfu.itis.semesterprojectspring.service.ProductService;
import ru.kpfu.itis.semesterprojectspring.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final UserService userService;

    @GetMapping("/list")
    public String view(
            ModelMap map,
            Principal principal
    ){
        if (principal != null){
            map.addAttribute("user",userService.findUserByEmail(principal.getName()));
        }
        List<Product> products = productService.getAll();
        map.addAttribute("products",products);
        return "product";
    }

    @GetMapping("/consume")
    public String consume(
            @RequestParam("productId") Long productId,
            @RequestParam Long grams,
            Principal principal
    ){
        User user = userService.findUserByEmail(principal.getName());
        Product product = productService.findById(productId);

        userService.updateUserRecord(
                user,
                RecordDto.builder()
                        .calorie(product.getCalories() * grams / 100)
                        .carb(product.getCarbs() * grams / 100)
                        .fat(product.getFat() * grams / 100)
                        .protein(product.getProteins() * grams / 100)
                        .build()
        );

        return "redirect:/products/list";
    }
}
