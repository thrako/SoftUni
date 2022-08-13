package phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import phonebook.entity.Contact;
import phonebook.repository.ContactRepository;

@Controller
public class ContactController {

    @Autowired
    ContactRepository contactRepository = new ContactRepository();

    public ContactController() {
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("contacts", this.contactRepository.getAllAsList());
        modelAndView.addObject("options", this.contactRepository.getNamesAsList());

        return modelAndView;
    }

    @PostMapping("/add")
    public String add(Contact contact) {
        this.contactRepository.add(contact);

        return "redirect:/";
    }

    @PutMapping("/update")
    public String updateByName(Contact contact) {
        this.contactRepository.update(contact);

        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(String name) {
        this.contactRepository.delete(name);

        return "redirect:/";
    }

}
