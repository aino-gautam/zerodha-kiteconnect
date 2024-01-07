package com.zerodhatech.models;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 * Deba implemented class to read instruments csv file with supercsv into instruments
 */
public class CsvInstrumentReader {
	
	private String filePath = null ;
	
	public CsvInstrumentReader(String file) {
		this.filePath = file ;
	}
	
	/**
	 * An example of reading using CsvBeanReader.
	 */
	public List<Instrument> readWithCsvBeanReader() throws Exception {
	        
	        ICsvBeanReader beanReader = null;
	        List<Instrument> instrumentsList = new ArrayList<Instrument>();
	        try {
	                beanReader = new CsvBeanReader(new FileReader(this.filePath), CsvPreference.STANDARD_PREFERENCE);
	                
	                // the header elements are used to map the values to the bean (names must match)
	                final String[] header = beanReader.getHeader(true);
	                final CellProcessor[] processors = getProcessors();
	                
	                Instrument instr;
	               
	                while( (instr = beanReader.read(Instrument.class, header, processors)) != null ) {
	                        //System.out.println(String.format("lineNo=%s, rowNo=%s, customer=%s", beanReader.getLineNumber(),
	                        //        beanReader.getRowNumber(), instr));
	                        
	                        instrumentsList.add(instr);
	                }
	                
	        }
	        finally {
	                if( beanReader != null ) {
	                        beanReader.close();
	                }
	        }
	        
	        return instrumentsList ;
	}
	
	/**
	 * Sets up the processors used for the examples. There are 10 CSV columns, so 10 processors are defined. Empty
	 * columns are read as null (hence the NotNull() for mandatory columns).
	 * 
	 * @return the cell processors
	 */
	
	// instrument_token	exchange_token	tradingsymbol	name	last_price	expiry	strike	tick_size	lot_size	instrument_type	segment	exchange

	private CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { 
	                new ParseLong(), // instrument_token
	                new ParseLong(), // exchange_token
	                new Optional(), // tradingsymbol
	                new Optional(), // name
	                new Optional(new ParseDouble()), // last_price
	                new Optional(new ParseDate("yyyy-MM-dd")), // expiry
	                new Optional(), // strike
	                new Optional(new ParseDouble()), // tick_size
	                new Optional(new ParseInt()), // lot_size
	                new Optional(), // instrument_type
	                new Optional(), // segment
	                new Optional(), // exchange
	                
	        };
	        
	        return processors;
	}

}
