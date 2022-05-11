# 152_Project2    

## Description:    

For this assignment, we are implementing a 'Publisher-Subscriber' pattern, using a Professor, Student, and Assessment as a basis.
From the prompt I have extracted the following 'Responsibilities' for each of these classes:  


**Professor:**  
* Allow Students to 'self-subscribe' to Roster  
* Introduce Questions to Assessment
* Notify all subscribed students on assessment creation  
* Grade Student's answers using an Answer Key  
* Publish a Report with Student's results  
  
**Student:**  
* Recieve an Assessment  
* Take an Assessment (inferred)  
* Return Assessment to be graded  
* Subscribe to a Roster  
  
**Assessment:**  
* Contain 'Questions'
* Store students answers (inferred)
  
As a note, the 'Questions' in the Assessment are a 'Composite' type of structure, in which 1 question may contain multiple sub-questions.  

## Design  
I decided to narrow down the scope of each responsibility outlined above, and represent these scopes using interfaces.  

**Publisher:**
* Notify all subscribed students

**AssessmentCreator:**
* Create Assessments (Introduce questions)
* Provide Assessment
* Register Assessment Subscriber (Design Decision left as optional, see below)  

**Grader:**  
* Grade Students answer using answer key
* Publish Report with Student's Results  

These above responsibilities are all found under the aforementioned 'Professor'. Separating each responsibility into their own interface helps with extensibility.
For instance, if a professor want's to create an assignment, but let a different professor be the 'Grader', it is possible, so long as the other 'Professor' implements the 'Grader' interface.  
This also makes the code more understandable by clearly outlining ALL the EXPECTED responsibilities of the Professor class. As a bonus, the 'Assessment' class in this implementation only needs to worry that it gets assigned a 'Grader', meaning that it is not exposed to the other functions and responsibilities in the Professor class, only those relavent to Grading activities.  
  
**Assignee:**  
* Recieve an Assessment  
* Take an Assessment (left up to implementer, not a required responsibility)
* Return Assessment to be graded  
* Subscribe to a Roster  

You'll notice that these are all found under the Student class above. It was a personal decision to encapsulate these into an interface, however, encapsulating them into an abstract base class would have worked as well. Incidently, I currently have an abstract 'Student' class as a base that is declared to implement the 'Assignee' interface. This is a bit redundant, but I felt that it made the code a bit more readable, and more effectively get's at what a 'Student' is supposed to do.  

**IAssessment:**  
* Contain 'Questions'
* Store students answers (inferred)  

The above shows the assessment responsibilities being defined in the IAssessment interface. However, I also decided to use the 'Assessment' as the 'Roster' as well. This allows students to 'Subscribe' to the Assessment directly. The Assessment will have to store a list of Subscribers, each of which is defined as 'Assignee', indicating that the subscribers will then be able to recieve and 'submit' the assessment.  
This will give the assessment new responsibilities being `Register Subscriber` and `Notify All Subscribers`. Furthermore, as a way of reducing overall coupling, the Assessment will need to be graded, and instead of having the Student need a reference to the 'Grader', a 'Grader' is set inside the assessment. This hides the 'Grader' object from the student entirely, and only exposes a function called 'sendToGrader' as a means of 'returning' the assessment.  
  
This leaves our IAssessment responsibilities as the following:
**IAssessment:**  
* Contain 'Questions'
* Register Subscriber
* Notify All Subscribers
* Return to Grader
* Set Grader  

You'll notice I dropped the 'Store Students answers' responsibility. This is because I decided to fully encapsulate that within a 'Question' class instead. A question class will need to have a question, store an answer, give the next question, (optionally) give the previous question, and be able to retrieve the base question (root) as it is a composite structure.  
  
**IQuestion:**  
* Store Question
* Store Answer
* Give next/prev Question access
* Return root
* Set Question
* Provide a Deep Copy of the structure


Because of the properties of Java, I also need to provide 'fresh' copies of the questions so different students don't overwrite the same object, therefore I also added a clone responsibility, this is done simply by having IQuestion extend cloneable  
Another design decision I made was to include a 'Builder', which simplifies Question creation. This builder is designed to return the 'Root' question after fully 
building the Question structure. The concrete Question class I designed emulates a Doubly Linked list instead of Tree Structure as it's easier to iterate through without losing your place. Recursion on a tree structure is possible, but I felt that added a bit too much complexity. The current implementation can be built from a Single Question, or a Set of questions, or a combination of both.  
 
 A side note: Because the QuestionBuilder will build an IQuestion structure using the concrete base class, the Builder is to be defined as a nested class inside the concrete class. The 'getBuilder' function defined by the Interface ensures that any IQuestion class provides an IQuestionBuilder. IQuestionBuilder is the interface that the QuestionBuilder implements.  
 
A final note before the UML's. As I didn't want the Professor class to become bloated with bits of un-related code, I extracted the business logic code from each function, and encapsulated them into their own classes. For example, All activities related to Grading, such as Storing an Answer Key, and Processing Assessments with said answer key and producing a report with results, has been encapsulated into an 'AutoGrader' class.   
  
As such, I want to be able to adhere to Open/Close principle, so I ensured the Professor class only depends on an interface for the Grader Utility. This interface is aptly named as 'GraderUtil'. This approach allows the 'GraderUtil' to be changed out at anytime with anything else that may be even more effective. This allows for extensibility while not having to touch the original code.  
  
  
A similar method was used for Assessment Building. As it is a complicated process, those activities were encapsulated under an IAssessmentBuilder interface, and given a concrete implementation with the 'AssessmentBuilder' class.   


## UML Class Diagrams  
**Create Assessment Flow**  
![Create Assessment V3 UML](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/assessmentCreationV3_UML.png)  
  
**Publish->Grade->Report Flow**  
![Publish and Grade Flow](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/mainSequenceDataFlowV3_UML.png)
  
**Professor Aggregation**  
![Professor Aggregation](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/professorV3_UML.png)  
  
**Assessment Aggregation**  
![Assessment Aggregation](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/studentV3_UML.png)

**Assessment Builder Dependencies**  
![Assessment Builder](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/assessmentBuilderDependencyV3.png)  

**Assessment Dependencies**  
![Assessment Dependencies](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/assessmentDependenciesV3.png)  

**Grading Utility Dependencies**  
![Grading Utility](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/gradingUtilDependencyV3.png)  

**Professor Dependencies**  
![Professor Dependencies](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/professorDependencyV3.png)  

**Report Dependencies**  
![Report](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/reportDependencyV3.png)  

**Student Dependencies**  
![Student](https://raw.githubusercontent.com/Ryan1Up/152_Project2/main/studentDependencyV3.png)  

