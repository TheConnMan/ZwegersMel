ZwegersMel
==========

### [INTO THE GARDEN](http://melaniemzwegers.com/)
#### Verses for Hearts Young & Old

A website for the author Melanie Zwegers where you can:

- [Buy the book](http://melaniemzwegers.com/book)
- [Read about the author](http://melaniemzwegers.com/about)
- [See upcoming events](http://melaniemzwegers.com/events)
- [Contact the author](http://melaniemzwegers.com/contact)
- [Read and submit reviews](http://melaniemzwegers.com/reviews)

## Recovery Steps
- Download latest H2 backup script
- Modify the dev environment to be in update mode
- Run in dev mode with the bootstrap turned off
- Remove the `create` and `alter` statements from the H2 backup script
- Apply the script to the local DB through **/dbconsole**
- SCP the new DB over to the app server
- Restart the app server
