#152_Project2    

## Description:    
    
This project explores design patterns. Specifically the Publisher/Subscriber pattern, which is  
thought of to be similar to the observer pattern. However the Pub-Sub patten differs in that it   
uses a 'Broker' as an intermediate component abstacting the need to know about other classes  
away from the Publisher and the Subscriber. As to where the observer patten would dictate   
that the Publisher know about all of the Subscribers.  

**Parties:**  
In this project there will be 2 types of parties. 'Alex' the professor who will allow students to   
'self-subscribe' to his subscription roster, and gives out assessments to those students. And the   
Students who can subscribe and take the assessments.   
    
**Assessments:**    
There are 2 kinds of assessments, a question that will accept an integer ranging from 1 to 5,   
this emulates a multiple choice style question, and a Question Set, that is a set of the     
first type of questions.    
   
**Exam Process:**    
This project will emulate test taking in a way. 'Alex' will publish an IAssessment, then     
each student that is subscribed will then take the IAssessment. Upon completion,    
the IAssessment is 'returned' to 'Alex' for grading. When grading is complete,     
a report summarizing performance will be sent to back to each student.    