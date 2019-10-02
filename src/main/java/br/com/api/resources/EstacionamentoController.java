package br.com.api.resources;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.api.models.Carro;
import br.com.api.models.Vaga;
import br.com.api.repositories.CarroRepository;
import br.com.api.services.CarroService;

@RestController
@RequestMapping(value = "/estacionamento")
public class EstacionamentoController {

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private CarroService carroService;

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(Carro carro) {
		ModelAndView mv = new ModelAndView("estacionamento/registrar-carro");
		mv.addObject(carro);
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView registrar(@Valid Carro carro, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(carro);
		}

		Date horarioEntrada = new Date();
		carro.setHorarioEntrada(horarioEntrada);
		carroRepository.save(carro);
		attributes.addFlashAttribute("mensagem", "Carro registrado com sucesso!");

		return new ModelAndView("redirect:/estacionamento/novo");

	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/estacionamento/listar-carros");
		mv.addObject("carros", carroRepository.findAll());
		
		if(carroRepository.findAll().isEmpty()) {
			return mv;
		}
		
		for(Carro carro : carroRepository.findAll()) {
			BigDecimal horas = carroService.calcularDiferenca(carro.getHorarioEntrada(), new Date());
			BigDecimal totalPagar = carroService.calcularPagamento(carro.getPrecoHora(), horas);
			carro.setTotPagar(totalPagar);
		}
		
		return mv;
	}
	
	@RequestMapping("estacionamento/relatorio/{id}")
	@ResponseBody
	public BigDecimal relatorio(@PathVariable("id") Carro carro, Vaga vagas) {
			return carroService.emitirRelatorio(carro.getTotPagar(), vagas.getEstacionadas());
		}
	
	
	
	@RequestMapping(method = RequestMethod.DELETE)
	public String deletar(@PathVariable Integer id, RedirectAttributes attributes) {
		carroService.excluir(id);
		attributes.addFlashAttribute("mensagem", "Carro deletado com sucesso!");
		return "redirect:/estacionamento";
	}
	
}
