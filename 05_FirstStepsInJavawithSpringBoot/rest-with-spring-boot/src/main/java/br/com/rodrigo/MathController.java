package br.com.rodrigo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable (value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
		}
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable (value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
		}
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable (value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
		}
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@RequestMapping(value = "/raiz/{numberOne}", method = RequestMethod.GET)
	public Double raiz(@PathVariable (value = "numberOne") String numberOne) throws Exception{
		if (!isNumeric(numberOne)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
		}
		return Math.sqrt(convertToDouble(numberOne));
	}
	
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable (value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
		}
		return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
	}
	

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		String number = strNumber.replaceAll(",", ".");
		return Double.parseDouble(number);
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}