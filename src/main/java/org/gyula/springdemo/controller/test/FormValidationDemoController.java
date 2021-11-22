package org.gyula.springdemo.controller.test;

import org.gyula.springdemo.domain.test.OrganizationRepresentative;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/formValidationDemo")
public class FormValidationDemoController {

    private static Logger LOGGER = LoggerFactory.getLogger(FormValidationDemoController.class);

    @RequestMapping("/home")
    public ModelAndView home(Model model) {
        return new ModelAndView("test/formValidationTestViews/formValidationHome",
                "orgrep", new OrganizationRepresentative());
    }

    public String organizationRepresentativeRegistration(@Valid @ModelAttribute("orgrep") OrganizationRepresentative orgRepresentative,
                                                         BindingResult result, Model model) {
        // debug code
        if (result.hasErrors()) {
            model.addAttribute("formerrors", result.getAllErrors());
            List<FieldError> ferrList = result.getFieldErrors();
            for (FieldError ferr : ferrList) {
                LOGGER.info("field error: " + ferr.getDefaultMessage());
            }

            List<ObjectError> gerrFeList = result.getGlobalErrors();
            for (ObjectError gerr : gerrFeList) {
                LOGGER.info("global error: " + gerr.getDefaultMessage());
            }
            return "test/formValidationTestViews/formValidationHome";
        } else {
            return "test/formValidationTestViews/formValidationResult";
        }
    }
}
