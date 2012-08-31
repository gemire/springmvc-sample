/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/controller.e.vm.java
 */
package com.dhenton9000.springfuse.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dhenton9000.springfuse.domain.Document;
import com.dhenton9000.springfuse.service.DocumentService;

@Controller
@RequestMapping("/domain/document/")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * Performs the list action.
     */
    @RequestMapping(value = { "list", "" })
    public String list(@ModelAttribute DocumentSearchForm documentSearchForm, Model model) {
        model.addAttribute("documentsCount", documentService.findCount(documentSearchForm.getDocument(),
                documentSearchForm.toSearchTemplate()));
        model.addAttribute("documents", documentService.find(documentSearchForm.getDocument(), documentSearchForm
                .toSearchTemplate()));
        return "domain/document/list";
    }

    /**
     * Serves the create form.
     */
    @RequestMapping(value = "create", method = GET)
    public String create(@ModelAttribute Document document) {
        return "domain/document/create";
    }

    /**
     * Performs the create action and redirect to the show view.
     */
    @RequestMapping(value = "create", method = { POST, PUT })
    public String create(@Valid @ModelAttribute Document document, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return create(document);
        }

        if (document.getAccount() != null) {
            // use the other side
            document.getAccount().addDocument(document);
        }

        documentService.save(document);
        return "redirect:/domain/document/show/" + document.getPrimaryKey();
    }

    /**
     * Serves search by example form, search by pattern form and search by named query form.
     */
    @RequestMapping(value = "*", method = GET)
    public void catchAll(@ModelAttribute DocumentSearchForm documentSearchForm) {
    }

}