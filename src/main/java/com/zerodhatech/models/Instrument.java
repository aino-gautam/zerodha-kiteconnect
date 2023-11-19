package com.zerodhatech.models;

import java.util.Date;


/**
 *    @CsvBindByName(column = "instrument_token" )
    public void setInstrumentToken(String instrumentToken) {
        this.zerodhaOriginal.instrument_token = Long.parseLong(instrumentToken);
    }

    @CsvBindByName(column = "exchange_token")
    public void setExchangeToken(String exchangeToken) {
        this.zerodhaOriginal.exchange_token = Long.parseLong(exchangeToken);
    }

    @CsvBindByName(column = "tradingsymbol")
    public void setTradingSymbol(String tradingSymbol) {
        this.zerodhaOriginal.tradingsymbol = tradingSymbol;
    }

    @CsvBindByName(column = "name")
    public void setName(String name) {
        this.zerodhaOriginal.name = name;
    }

    @CsvBindByName(column = "last_price")
    public void setLastPrice(String lastPrice) {
        this.zerodhaOriginal.last_price = Double.parseDouble(lastPrice);
    }

    @CsvBindByName(column = "expiry")
    @CsvDate("yyyy-MM-dd") // Adjust the format as per your CSV
    public void setExpiry(Date expiry) {
        this.zerodhaOriginal.expiry = expiry;
    }

    @CsvBindByName(column = "strike")
    public void setStrikePrice(String strikePrice) {
        this.zerodhaOriginal.strike = strikePrice;
    }

    @CsvBindByName(column = "tick_size")
    public void setTickSize(String tickSize) {
        this.zerodhaOriginal.tick_size = Double.parseDouble(tickSize);
    }

    @CsvBindByName(column = "lot_size")
    public void setLotSize(String lotSize) {
        this.zerodhaOriginal.lot_size = Integer.parseInt(lotSize);
    }

    @CsvCustomBindByName(column = "instrument_type", converter = TypeConverter.class)
    public void setInstrumentType(MarketInstrument.Type instrumentType) {
        this.zerodhaOriginal.instrument_type = instrumentType.toString();
    }

    @CsvBindByName(column = "segment")
    public void setSegment(String segment) {
        this.zerodhaOriginal.segment = segment;
    }

    @CsvCustomBindByName(column = "exchange", converter = ExchangeConverter.class)
    public void setExchange(Exchange exchange) {
        this.zerodhaOriginal.exchange = exchange.toString();
    }

 */

/**
 * A wrapper for Instrument.
 */
public class Instrument {
	
	
    public long instrument_token,exchange_token;
    public String tradingsymbol,name;
    public double last_price, tick_size;
    public String instrument_type,segment,exchange, strike;
    public int lot_size;
    public Date expiry;


    public long getInstrument_token() {
        return instrument_token;
    }

    public void setInstrument_token(long instrument_token) {
        this.instrument_token = instrument_token;
    }

    public long getExchange_token() {
        return exchange_token;
    }

    public void setExchange_token(long exchange_token) {
        this.exchange_token = exchange_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTradingsymbol() {
        return tradingsymbol;
    }

    public void setTradingsymbol(String tradingsymbol) {
        this.tradingsymbol = tradingsymbol;
    }

    public double getLast_price() {
        return last_price;
    }

    public void setLast_price(double last_price) {
        this.last_price = last_price;
    }

    public double getTick_size() {
        return tick_size;
    }

    public void setTick_size(double tick_size) {
        this.tick_size = tick_size;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getInstrument_type() {
        return instrument_type;
    }

    public void setInstrument_type(String instrument_type) {
        this.instrument_type = instrument_type;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public int getLot_size() {
        return lot_size;
    }

    public void setLot_size(int lot_size) {
        this.lot_size = lot_size;
    }
}
