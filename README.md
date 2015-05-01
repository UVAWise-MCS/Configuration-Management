#Software Configuration Management Project, Spring 2015
Create an application which allows a professor to create an exam from a set of questions in JSON format. 


##Project Management
 You will need to submit the following forms of documentation: 
 * Risk Mitigation Plan (Create a new version every 4 weeks with updated risks, probabilities, and impact values.) 
 * Schedule (Create your schedule using Microsoft Project.) 
 * Software Estimates (Estimate LOC count at the beginning of the project and describe your methodology.)  
 
 
##Requirements
 You need to come up with the requirements for the program but they must follow these guidelines: 
 * There will be two separate input JSON files.
 * One for the set of questions.
 * One to guide the application as to how many questions of particular types and categories should be selected for the resulting output file. 
 * Each question is an element in the JSON file. * Each question has the following attributes:     
    * Type = Short Answer/ Matching / True-False / Multiple Choice     
    * Question     
    * Answer     
    * Category
* The resulting output file should be a plain text file that lists the questions grouped together by type.  


##Design 
You must create the following diagrams for your software:  Class Diagrams, Sequence Diagrams     

Each one of the diagrams must be complete and correct; however, you don't need to put everything on one diagram. You may create these diagrams using any modeling tool and place them into the design document. Other diagrams can be added if necessary.


##Coding and Unit Test  
You may code your program in any one of the following languages: C++, C#, Java  

The program does not need to be a GUI. You must also use revision control software to keep track of the changes to your source code. After each major section of your code is done, you must perform a unit test. After the unit test is complete, you must hold a code and unit test review for that section of code. Instructions for the code and unit test review will be provided. Code and Unit Test Reviews You will need to perform at least three code and unit test reviews. For each code review, copy the code into a Microsoft Word document and turn 'Track Changes' on in the Review tab so any changes made to the code in the Word document will be captured. Also, use the comment features in Word to provide to and respond to comments during the peer reviews. For each review, you must also fill out a unit test report before the review to describe what steps you have taken to test the code being reviewed. At the end of each code review, you must fill out an inspection report and input any defects found into ClearQuest for tracking. You must update the ClearQuest records as you complete the fixes for all the defects discovered. 

##System Testing 
You must prepare a software test document and document the results during system testing in order to verify the system meets the requirements. You must also submit sample JSON files that you have used to test the system. 

##Documentation 

You will turn in several pieces of documentation in one zip file. Only one team member needs to submit the documentation for the entire team project. Templates will be provided for some of the documentation to submit. 

The documentation to be included is:
 1. Project Management Documentation
 2. Requirements Documentation
 3. Design Documentation
 4. Source Code
 5. Code and Unit Test Review Documentation
 6. Test Documentation with Results and Input Data
 7. Final Report and Presentation
 8. Revision Control Software History Log

##Assessments
Each team member will perform a self-assessment of how they did on the project and a peer assessment of how each of their team members performed. Items to include in the assessments are:
 * Responsibilities
 * Strengths
 * Weaknesses
 * Recommended Score (0-100)
 
Each person will turn in their assessments separately from the documentation listed previously. Give specific examples and write at least 2 paragraphs for each item (responsibilities, strengths, weaknesses). 

***

##How to import into Eclipse:
  1. File
  2. Import
  3. Git
  4. Projects From Git
  5. Clone URI
  6. Use https://github.com/UVAWise-MCS/Configuration-Management.git as the URI
  7. Enter in your GitHub login information.
  8. Select at least the master branch
  9. Initial Branch as master
  10. Import Existing Projects
  11. Next until Finished

##How to run: 
 * Open command prompt, point to JAR file using java. E.G. ```java -jar ExamGenerator.jar```
 * ```java -jar ExamGenerator.jar load <question JSON data file> <attributes JSON data file>```
