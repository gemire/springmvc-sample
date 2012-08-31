run active mq locally
there should be a http site at http://localhost:8161

to run the sample, got to com.dhenton9000.worker.Sample

the program will go into a wait state

the activemq.xml file in this folder is the conf
config file for the activemq broker.

10/5/10

round robin policy is required
set consumers to 1
time delay in simulation

this combination yields an even distribution over
the consumers for a single thread see multiplework function
in worker.Sample