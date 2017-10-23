package com.calypso.finance.stock_app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class StockPersistence {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STOCKID")
	private int stockid;

	@Column(name = "STOCKNAME")
	private String name;
	
	@Column(name = "STOCKSYMBOL")
	private String symbol;
	

	@Column(name = "STOCKVALUE")
	private double stockval;

	public String getName() {
		return name;
	}

	public int getStockid() {
		return stockid;
	}

	public double getStockval() {
		return stockval;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public void setStockval(double stockval) {
		this.stockval = stockval;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
