package com.theconnman

class Review {
	
	String title
	String content
	Date createdDate
	String author = 'Anonymous'
	boolean approved = false

    static constraints = {
		title()
		content maxSize: 2000
		createdDate()
		author()
		approved()
    }
}
