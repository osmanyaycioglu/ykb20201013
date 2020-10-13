package com.training.ykb.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hesap")
public class CalculatorController {

    @GetMapping("/islem/{abc}/{dfg}")
    public int add(@PathVariable("abc") final int val1,
                   @PathVariable("dfg") final int val2) {
        return val1 + val2;
    }

    @PostMapping("/islem/{abc}/{dfg}")
    public int subs(@PathVariable("abc") final int val1,
                    @PathVariable("dfg") final int val2) {
        return val1 - val2;
    }

    @PutMapping("/islem/{abc}/{dfg}")
    public int mult(@PathVariable("abc") final int val1,
                    @PathVariable("dfg") final int val2) {
        return val1 * val2;
    }


    @PatchMapping("/islem/{abc}/{dfg}")
    public int div(@PathVariable("abc") final int val1,
                   @PathVariable("dfg") final int val2) {
        return val1 / val2;
    }

}
