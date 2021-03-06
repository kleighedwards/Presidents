# Skill Distillery Week 6 Project

## Presidents - An Introduction to Java Web Programming


### Application Overview 

  Use Java Servlets, Java Beans, and JSP to create a functional website to display U.S. Presidents. 
  
  
### Execution

  - The user is able to select the President they wish to view by inputting their respective term number
    into the text field at the bottom of the page and clicking the "Submit" button. 
   
      - If the user wanted to view George Washington, for example, they would input 1 into the text field. 
      - If the user inputs an invalid term number (i.e. 55) the program will notify them of their mistake and they
        will be allowed to re-enter a valid term number into the text field.
      - If the user were to enter non-numeric values into the text field, the program will simply refresh the current page.
  
  - The user may also cycle through all 44 Presidents by selecting the "Next" and "Previous" buttons. 
  
      - If the user selects "Previous" while on George Washington, the program will display Barack Obama. Likewise, 
      if the user selects "Next" on Barack Obama, the program will display George Washington.
  
  - The user may also filter through the Presidents by party by selecting from the drop-down menu at the bottom
    of the page.
    
      - At this point, the text field will no longer display and the user will be able to cycle through each party
      by selecting "Next" and "Previous." These filtered lists will wrap similarly to the "All Presidents" default
      option. The only exception to this rule being "Independents" and Federalists" as there has been only one
      President from either of those parties. 

### Access on AWS

  - Kristen Edwards: http://52.34.37.216:8080/Presidents/
  
  - Toland Gooch: http://52.36.174.229:8080/Presidents/
  
  - Rod Hammond: http://rodhammond.info:8080/Presidents/
