package com.oretania.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
    @RequestMapping(value = "/matematicas")
    @PreAuthorize("hasAnyAuthority('Matemáticas')")
    public String matematicas() {
        return "matematicas";
    }

    @RequestMapping(value = "/lengua")
    public String lengua() {
        return "lengua";
    }

    @RequestMapping(value = "/ingles")
    public String ingles() {
        return "ingles";
    }

    @RequestMapping(value = "/religion")
    public String religion() {
        return "religion";
    }

    @RequestMapping(value = "/fisica")
    public String fisica() {
        return "fisica";
    }

    @RequestMapping(value = "/quimica")
    public String quimica() {
        return "quimica";
    }
}
