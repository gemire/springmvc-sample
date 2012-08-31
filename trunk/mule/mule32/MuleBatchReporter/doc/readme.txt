This is a demo of a processing system that will take a collection of objects
process them, and then report when the process of the collection is complete.

The reporter object does the reporting, it maintains a hashmap of 
correlation ids and counters, which it increments as messages come in

the WorkGenerator can set the correlation id to some value other than the 
Mule generated default to allow for real world meaning 

The demo as currently configured assumes that the processors pass a message
with the correlation id intact, only the correlation id, and has to make it
to the reporter