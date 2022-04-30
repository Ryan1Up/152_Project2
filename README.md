# 152_Project2    

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
  
## UML  
  
    
### Publisher-Subscriber UML Overview  
![Simple Pub Sub UML](https://github.com/Ryan1Up/152_Project2/blob/main/simpleUML_Pub-Sub.png?raw=true)

This UML shows a simplified overview of the interactions between the Professor class which implements 2 interfaces, Grader and Publisher. The Publisher  
interface is the one that defines responsibility for publishing assessments to a Broker. We see here that Broker is another interface, and a concrete  
implementation of AssessmentBroker is given. The Broker is then responsible to 'assign' or 'notify' the Subscribers, denoted by an 'Assignee' interface.
We see the abstract class 'Student' implements that interface. We also have a concrete implementation of Student and Assignee as the CSCI152Student class.

### Assessment UML Overview  
![Assessment UML](https://github.com/Ryan1Up/152_Project2/blob/main/simpleUML_Assessment.png?raw=true)  
Each assessment is comprised of Questions, in this case 'IQuestions'. An IQuestion is a class that has a set of functions available to it, and we see that  
the concrete class 'Question' implements IQuestion. For simplicities sake, we have also included an AssessmentFactory for the sake of creating assessments with
too much intermingles code.  

### Assessment and Report Simplified UML Flow  
![Simple Assessment and Report Publish Flow](https://github.com/Ryan1Up/152_Project2/blob/main/UML_SimpleFlow_Assessment_Reports.png?raw=true)   
This last UML shows how Assessments and Reports flow between the Professor class and the Student class. The professor takes on the responsibility of not  
only a Publisher but also that of a Grader. The professor publishes the Assessment to the Broker, the Broker then assigns the Assessment to all subscribed Assignees,
the Assignee (Student) will then complete and 'submit()' the assignment to the Grader. Each Assignee has a method setGrader() to ensure that they have a 'Grader' 
to submit to. The grader then 'Grades' the assessment, in this implementation, 'Grading' is extracted to a GraderUtil that implements the AssessmentGrader interface.  
This is to allow the GraderUtil to be replaced by anything else that implements the AssessmentGrader interface the need arises. This step was not necessary, but
it improved on the maintainability of the code, and attempted to adhere to the single responsibilty principle. The next step in the flow would have the Professor
publish the results to the Broker, and again the Broker sends them out to the assignees. This implementation of 'Broker' restricts the send of the Report ONLY  
to the desired recipient.
