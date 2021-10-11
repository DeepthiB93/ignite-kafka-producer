# kafka-spring

Kafka, A distributed streaming platform. Asynchronous messaging and data transformation in real time using kafka and and Java Springboot

Important concepts:

* Producer/Publisher : clients which generate message and queue them into Kafka model.
* Consumer/Subscriber :  Subscribing to read/consume message from one or more topics and one or more partitions of a topic
* Storage room Structure : 
   1. Storage room(Topic)
   2. Storage room counter(Partition)

   In a storage room, there can be multiple counters and messages. In each counter the messages are stored in sequence, which order across counters are not guaranteed. Message in each counter is independent of other.
   
   Example : Counter 0 : 0,1,2,3.. <message order id>
             Counter 1 : 0,1,2,3,4..
             Counter 2 : 0,1,2,...
             
* Topic : Can have any number of topic. Messages in topic has default retention period, which is 2 weeks. But can be altered according to the need. Messages are immutable. Each topic has name.
  
* Partition : Every topic will have 1 or more partitions. Each message starts at offset 0. Partition is a way to achieve parallelism.
   Offset per partition.
   1. Partition 0; offset 0|1|2|3...
   2. Partition 1; offset 0|1|2|...
   Each partition is independent. Can have varying offsets in each partition.
