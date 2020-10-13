package com.training.ykb.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hesap/islem/v1")
public class CalculatorControllerv1 {

    @GetMapping("/toplama/{abc}/{dfg}")
    public int add(@PathVariable("abc") final int val1,
                   @PathVariable("dfg") final int val2) {
        return val1 + val2;
    }

    @GetMapping("/cikarma/{abc}/{dfg}")
    public int subs(@PathVariable("abc") final int val1,
                    @PathVariable("dfg") final int val2) {
        return val1 - val2;
    }

    @GetMapping("/carpma/{abc}/{dfg}")
    public int mult(@PathVariable("abc") final int val1,
                    @PathVariable("dfg") final int val2) {
        return val1 * val2;
    }


    @GetMapping("/bolme/{abc}/{dfg}")
    public int div(@PathVariable("abc") final int val1,
                   @PathVariable("dfg") final int val2) {
        return val1 / val2;
    }

    @GetMapping("/xyz/{abc}/{dfg}")
    public int xyz(@PathVariable("abc") final int val1,
                   @PathVariable("dfg") final int val2) {
        return val1 / val2;
    }

}
