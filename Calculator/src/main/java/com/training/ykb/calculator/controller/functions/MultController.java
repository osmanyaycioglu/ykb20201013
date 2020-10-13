package com.training.ykb.calculator.controller.functions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculation/mult")
public class MultController {

    @GetMapping("/{abc}/{dfg}")
    public int add(@PathVariable("abc") final int val1,
                   @PathVariable("dfg") final int val2) {
        return val1 * val2;
    }

}
