package com.azienda.eccezioni.esempio3.utils;

import com.azienda.eccezioni.esempio3.exception.TooShortStringException;

public class InputValidator {

	public static void check(String s) {
		if (s.length() <= 4) {
			throw new TooShortStringException("Stringa troppo corta, almeno 5 caratteri", null);
		}
	}
}
