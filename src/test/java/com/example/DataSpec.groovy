package com.example

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification

class DataSpec extends Specification {

	@Shared
	def sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")
	
	def setupSpec() {
		sql.execute '''
		CREATE TABLE maxdata (
		a	INTEGER,
		b	INTEGER,
		c	INTEGER);
		'''
		sql.execute '''
		INSERT INTO maxdata (a,b,c) VALUES
		(1,3,3),
		(7,4,7),
		(0,0,0);
		'''
	}
	
	def cleanupSpec() {
		sql.close()
	}

	def "adding an element leads to size increase"() {
		setup: "a new stack instance is created"
			def stack = new Stack()
		when:
			stack.push(42)
		then:
			stack.size() == 1
	}

	def "maximum of two numbers"() {
		expect:
			Math.max(a, b) == c

		where:
			[a, b, c] << sql.rows("select a, b, c from maxdata")
	}
}
