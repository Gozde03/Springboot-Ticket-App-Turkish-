package com.example.controller;

import com.example.entity.Event;
import com.example.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/event")
@SessionAttributes("cart")
public class eventController {

    @Autowired
    private EventRepository eventRepository;

    @ModelAttribute("cart")
    public List<Event> createCart() {
        return new ArrayList<>();
    }

    @GetMapping
    public String showEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "event";  
    }

    @PostMapping("/add-to-cart/{eventId}")
    @ResponseBody
    public String addToCart(@PathVariable("eventId") Long eventId,
                            @ModelAttribute("cart") List<Event> cart) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null && !cart.contains(event)) {
            cart.add(event);
            return "Etkinlik sepete eklendi";
        }
        return "Etkinlik bulunamadı veya zaten sepette";
    }

    @GetMapping("/cart")
    public String showCart(@ModelAttribute("cart") List<Event> cart, Model model) {
        model.addAttribute("cart", cart);
        return "cart"; 
    }
}