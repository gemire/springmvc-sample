package com.dhenton9000.spring.mvc.controllers.bootstrap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Bootstrap demonstation controller
 *
 */
@Controller
@RequestMapping(value = "/bootstrap/demos/*")
public class BasicBootstrapController {

    private static Logger log = LogManager
            .getLogger(BasicBootstrapController.class);

    @RequestMapping(value = "tabledemo")
    public String goToTableDemo() {

        return "tiles.bootstrap.tabledemo";


    }

    @RequestMapping("buttons")
    public String buttonsPage() {

        return "tiles.bootstrap.buttons.layout";
    }

    @RequestMapping("dropdowns")
    public String dropDownsPage() {

        return "tiles.bootstrap.dropdowns.layout";
    }

    @RequestMapping("tabs")
    public String tabsPage() {

        return "tiles.bootstrap.tabs.layout";
    }

    @RequestMapping("modals")
    public String modalsPage() {

        return "tiles.bootstrap.modals.layout";
    }
}
