/*
 * (c) Copyright 2005-2011 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/controllerwithPathVariable.e.vm.java
 */
package com.dhenton9000.springfuse.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dhenton9000.springfuse.domain.Account;
import com.dhenton9000.springfuse.service.AccountService;
import com.dhenton9000.springfuse.domain.Role;
import com.dhenton9000.springfuse.service.RoleService;

@Controller
@RequestMapping("/domain/account/")
public class AccountControllerWithPathVariable {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;

    /**
     * This method is invoked by Spring MVC before the handler methods.
     * <p>
     * The path variable is converted by SpringMVC to a Account via the {@link AccountFormatter}.
     * Before being passed as an argument to the handler, SpringMVC binds the attributes on the resulting model,
     * then each handler method may receive the entity, potentially modified, as an argument.
     */
    @ModelAttribute
    public Account getAccount(@PathVariable("pk") Account account) {
        return account;
    }

    /**
     * Serves the show view for the entity.
     */
    @RequestMapping("show/{pk}")
    public String show(@ModelAttribute Account account) {
        return "domain/account/show";
    }

    /**
     * Serves the update form view.
     */
    @RequestMapping(value = "update/{pk}", method = GET)
    public String update(Model model) {
        bindListForSelectInputFields(model);
        return "domain/account/update";
    }

    /**
     * Performs the update action and redirect to the show view.
     */
    @RequestMapping(value = "update/{pk}", method = { PUT, POST })
    public String update(@Valid @ModelAttribute Account account, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return update(model);
        }

        accountService.save(account);
        return "redirect:/domain/account/show/" + account.getPrimaryKey();
    }

    /**
     * Serves the delete form asking the user if the entity should be really deleted.
     */
    @RequestMapping(value = "delete/{pk}", method = GET)
    public String delete() {
        return "domain/account/delete";
    }

    /**
     * Performs the delete action and redirect to the search view.
     */
    @RequestMapping(value = "delete/{pk}", method = { PUT, POST, DELETE })
    public String delete(@ModelAttribute Account account) {
        accountService.delete(account);
        return "redirect:/domain/account/search";
    }

    /**
     * Binds to the passed model the possible values for select input fields.
     */
    private void bindListForSelectInputFields(Model model) {
        model.addAttribute("roles", roleService.find());
    }
}