package com.example

import spock.lang.Specification

class MathSpec extends Specification {
	
	def "maximum of two numbers"() {
		expect:
			// exercise math method for a few different inputs
			Math.max(1, 3) == 3
			Math.max(7, 4) == 7
			Math.max(0, 0) == 0
	}
	
	def "maximum of two numbers"(int a, int b, int c) {
		expect:
			Math.max(a, b) == c
		where:
			a | b | c
			1 | 3 | 3
			7 | 4 | 7
			0 | 0 | 0
	}
	
	def "one column number greater than 0"() {
		expect:
			a > 0
		where:
			a | _
			1 | _
			7 | _
			10 | _
	}
	
	def "maximum of two numbers without params"() {
		expect:
			Math.max(a, b) == c
		where:
			a | b || c
			1 | 3 || 3
			7 | 4 || 7
			0 | 0 || 0
	}
	
	def "maximum between #a and #b should be #c"() {
		expect:
			Math.max(a, b) == c
		where:
			a | b || c
			1 | 3 || 3
			7 | 4 || 7
			0 | 0 || 0
	}
}
