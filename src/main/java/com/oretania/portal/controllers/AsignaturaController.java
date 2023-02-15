package com.oretania.portal.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asignaturas")
public class AsignaturaController {
    
    @RequestMapping(value = "/matematicas")
    @PreAuthorize("hasAuthority('Matemáticas')")
    public String matematicas() {
        return "asignaturas/matematicas";
    }

    @RequestMapping(value = "/lengua")
    @PreAuthorize("hasAuthority('Lengua')")
    public String lengua() {
        return "asignaturas/lengua";
    }

    @RequestMapping(value = "/ingles")
    @PreAuthorize("hasAuthority('Inglés')")
    public String ingles() {
        return "asignaturas/ingles";
    }

    @RequestMapping(value = "/religion")
    @PreAuthorize("hasAuthority('Religión')")
    public String religion() {
        return "asignaturas/religion";
    }

    @RequestMapping(value = "/fisica")
    @PreAuthorize("hasAuthority('Física')")
    public String fisica() {
        return "asignaturas/fisica";
    }

    @RequestMapping(value = "/quimica")
    @PreAuthorize("hasAuthority('Química')")
    public String quimica() {
        return "asignaturas/quimica";
    }
}
