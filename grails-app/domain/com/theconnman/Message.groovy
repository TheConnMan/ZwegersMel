package com.theconnman

class Message {
	
	String name
	String email
	Date date
	String comment

    static constraints = {
		name()
		email()
		date()
		comment maxSize: 500
    }
}
