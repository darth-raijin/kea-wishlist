package com.example.demo.controllers;


import com.example.demo.models.Item;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.WishList;
import com.example.demo.utility.Database;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DecimalFormat;
import java.util.ArrayList;

@Controller
public class FrontPageController {

    Database database = new Database();
    
    @GetMapping("/")
    public String index() {
        return "root";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam String id, Model model){
        // Brugt til at se en liste som ejer
        // TODO SELECT Wishlist baseret på id
        String[] result = database.getWishlist(id);
        ArrayList<Item> itemList = new ArrayList<>();

        if (result != null) {
            WishList wl = new WishList(result[1], result[2], Integer.parseInt(result[0]));

            model.addAttribute("sharelink", String.format("/view?id=%s", wl.getId()));
            model.addAttribute("Wishlist", wl);

            ArrayList<String[]> otherResult = new ArrayList<>();
            otherResult = database.getWishlistItems(wl.getId());

            if (otherResult != null){
                for (String[] item : database.getWishlistItems(wl.getId()) ){
                    if (item[0] == "error"){
                        return "fail";
                    }
                    itemList.add(new Item(Integer.parseInt(item[0]),item[1],Double.parseDouble(item[2]),item[3]));
                }
                System.out.println("ITEM LIST HER: " + itemList);
                model.addAttribute("list", itemList);
            }
            }
        return "edit";
    }

    @GetMapping("/view")
    public String view(@RequestParam String id, Model model){
        String[] result = database.getWishlist(id);
        ArrayList<Item> itemList = new ArrayList<>();

        if (result != null) {
            WishList wl = new WishList(result[1], result[2], Integer.parseInt(result[0]));
            model.addAttribute("Wishlist", wl);

            ArrayList<String[]> otherResult = new ArrayList<>();
            otherResult = database.getWishlistItems(wl.getId());

            if (otherResult != null){
                for (String[] item : database.getWishlistItems(wl.getId()) ){
                    if (item[0] == "error"){
                        return "fail";
                    }
                    itemList.add(new Item(Integer.parseInt(item[0]),item[1],Double.parseDouble(item[2]),item[3]));
                }
                System.out.println("ITEM LIST HER: " + itemList);
                model.addAttribute("list", itemList);
            }
        }
        return "view";
    }

    @PostMapping("/edit")
    public String updateWishlist(@RequestParam MultiValueMap body, RedirectAttributes redirectAttrs, @RequestParam String id) {
        int wishID = Integer.parseInt(id);
        String name = String.valueOf(body.get("name")).replace("[","").replace("]","");
        double price = Double.parseDouble(String.valueOf(body.get("price")).replace("[","").replace("]",""));
        String link = String.valueOf(body.get("link")).replace("[","").replace("]","");


        System.out.println(wishID + " " + name + " "  + price + " " + link);

        // Database metode her
        int result = database.addItem(name, wishID, price, link);

        // Håndtering af godt og dårligt resultat
        if (result == 200) {
            redirectAttrs.addAttribute("id", wishID);
            return "redirect:/edit?id={id}";

        }
        return "fail";
    }


    @PostMapping("/create")
    public String postCreate(@RequestParam MultiValueMap body, RedirectAttributes redirectAttrs) {
        String name = String.valueOf(body.get("name"));
        String description = String.valueOf(body.get("description"));

        // TODO database kald der returnere id
        String result = database.createWishList(name, description);

        if (result == "400") {
            System.out.println("Failed to create " + name);
            return "fail";
        }

        // Tilføjer attributter 
        redirectAttrs.addAttribute("id", result);
        return "redirect:/edit?id={id}";

    }

    @GetMapping ("/share")
    public String shareWishList (@RequestParam String id){
        return "share";
    }

    @DeleteMapping ("/delete")
    public String delete (@RequestParam String id) {
        return "";
    }






}

