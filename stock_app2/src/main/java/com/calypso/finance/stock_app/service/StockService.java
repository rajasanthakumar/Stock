package com.calypso.finance.stock_app.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calypso.finance.stock_app.model.StockPersistence;
import com.calypso.finance.stock_app.repository.StockRepository;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service
public class StockService {
	@Autowired
	private StockRepository stockRepository;

	public List<StockPersistence> fetchAll() {
		return (List<StockPersistence>) stockRepository.findAll();
	}

	public StockPersistence addStock(String symbol) throws IOException {

		Stock stock = YahooFinance.get(symbol);
		String name=stock.getName();
		BigDecimal price = stock.getQuote().getPrice();
		if(name == null || price == null)
		{
			return null;
		}
		double value = price.doubleValue();

		StockPersistence stockPersistence = new StockPersistence();
		stockPersistence.setName(name);
		stockPersistence.setSymbol(symbol);
		stockPersistence.setStockval(value);
		return stockRepository.save(stockPersistence);
	}
	public void deleteStock(int id) {
		stockRepository.delete(id);
	}
	
}
