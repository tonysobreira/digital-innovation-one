package br.com.globallabs.springwebmvc.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repository.JediRepository;

@Controller
public class JediController {

	@Autowired
	private JediRepository repository;

	@GetMapping("/jedi")
	public ModelAndView jedi() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("jedi");
		modelAndView.addObject("allJedi", repository.findAll());

		return modelAndView;
	}

	@GetMapping("/search")
	public ModelAndView search(@RequestParam(value = "name") final String name) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("jedi");
		modelAndView.addObject("allJedi", repository.findByNameContainingIgnoreCase(name));

		return modelAndView;
	}

	// 1st
//	@GetMapping("/new-jedi")
//	public String newJedi(Model model) {
//		model.addAttribute("jedi", new Jedi());
//		return "new-jedi";
//	}

	// 2nd
	@GetMapping("/new-jedi")
	public ModelAndView newJedi() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("new-jedi");
		modelAndView.addObject("jedi", new Jedi());
		return modelAndView;
	}

	@PostMapping("/jedi")
	public String createJedi(@Valid @ModelAttribute Jedi jedi, BindingResult result,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			if (jedi.getId() == null) {
				return "new-jedi";
			} else {
				return "edit-jedi";
			}
		}

		if (jedi.getId() == null) {
			redirectAttributes.addFlashAttribute("message", "Jedi successfully created.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		} else {
			redirectAttributes.addFlashAttribute("message", "Jedi successfully updated.");
			redirectAttributes.addFlashAttribute("alertClass", "alert-info");
		}

		repository.save(jedi);

		return "redirect:jedi";
	}

	@GetMapping("/jedi/{id}/delete")
	public String deleteJedi(@PathVariable("id") final Long id, RedirectAttributes redirectAttributes) {
		Optional<Jedi> jedi = repository.findById(id);
		repository.delete(jedi.get());

		redirectAttributes.addFlashAttribute("message", "Jedi successfully deleted.");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

		return "redirect:/jedi";
	}

	// 1st
//	@GetMapping("/jedi/{id}/update")
//    public String updateJedi(@PathVariable("id") final Long id, Model model) {
//        Optional<Jedi> jedi = repository.findById(id);
//        model.addAttribute("jedi", jedi.get());
//        return "edit-jedi";
//    }

	// 2nd
	@GetMapping("/jedi/{id}/update")
	public ModelAndView updateJedi(@PathVariable("id") final Long id) {
		Optional<Jedi> jedi = repository.findById(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit-jedi");
		modelAndView.addObject("jedi", jedi);
		return modelAndView;
	}

}
