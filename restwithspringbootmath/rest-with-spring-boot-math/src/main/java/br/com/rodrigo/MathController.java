package br.com.rodrigo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable (value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Plase set a numeric value!");
			
		}
		 return convertToDouble(numberOne) + convertToDouble(numberTwo);
		}

	private double convertToDouble(String StringNumber) {
		String number = StringNumber.replaceAll(",",".");
		return Double.parseDouble(number);
	}

	private boolean isNumeric(String StringNumber) {
		if(StringNumber == null) {
			return false;
		}
		String number = StringNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
		
	
	
}
