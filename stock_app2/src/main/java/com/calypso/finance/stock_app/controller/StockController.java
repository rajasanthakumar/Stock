package com.calypso.finance.stock_app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.calypso.finance.stock_app.model.StockPersistence;
import com.calypso.finance.stock_app.service.StockService;

@RestController
@RequestMapping("/app")
public class StockController {

	@Autowired
	private StockService stockService;

	@RequestMapping(value = "/stock", method = RequestMethod.GET)
	public ModelAndView fetchAll(Model model) {

		List<StockPersistence> stockPersistences = stockService.fetchAll();

		ModelAndView mav = new ModelAndView();
		mav.addObject("StockPresistence", stockPersistences);
		mav.setViewName("stock");
		return mav;
	}

	@RequestMapping(value = "/stock", method = RequestMethod.POST)
	public ModelAndView addStock(@RequestParam(value = "name") String name) throws IOException {

		ModelAndView mav = new ModelAndView();
		StockPersistence stockPersistence = stockService.addStock(name);
		if (stockPersistence == null) {
			String errorMessage = "Symbol not found";
			mav.addObject("errorMsg", errorMessage);
		}
		List<StockPersistence> stockPersistences = stockService.fetchAll();
		mav.addObject("StockPresistence", stockPersistences);
		mav.setViewName("stock");
		return mav;
	}

	@RequestMapping(value = "/stock/{id}", method = RequestMethod.DELETE)
	public RedirectView deleteStock(@PathVariable int id) throws IOException {

		stockService.deleteStock(id);
		RedirectView rv = new RedirectView();
		rv.setUrl("");
		return rv;
	}

}
