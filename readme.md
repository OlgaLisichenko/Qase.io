## *[Qase.io](https://app.qase.io/login)* it is an all-in-one test management solution. It includes test case management, defect management, test plans, test runs with informative reports, rich API, and webhooks.
***
##The following has been applied in this project:
1. Maven
2. TestNG with Retry, TestListener, Data Provider and running in parallel in multiple browsers
3. Selenide
4. REST API (Rest Assured)
5. Cucumber
6. Allure reporting
7. Running tests via Jenkins
8. Logging
***
## [Checklist](https://app.qase.io/project/ATQI) of tests
***
## UI tests
***
1. ***Login page tests***
    1. Checking the possibility of login with valid credentials [link](https://app.qase.io/case/ATQI-1);
    2. Checking the possibility of login with invalid credentials [link](https://app.qase.io/case/ATQI-2).
***
2. ***Tests for creating a new project***
    1. Checking the possibility of creating a new project [link](https://app.qase.io/case/ATQI-3);
    2. Checking the possibility of deleting a created project [link](https://app.qase.io/case/ATQI-4).
***
3. ***Tests for creating a new project (negative)***
    1. Checking the possibility of creating a new project with filling in the "Project Code" field
   with invalid data [link](https://app.qase.io/case/ATQI-5);
    2. Checking the possibility of creating a new project with filling in the "Project Code" field
   with data containing less than two characters [link](https://app.qase.io/case/ATQI-6); 
    3. Checking the possibility of creating a new project by filling in the "Project Code" field 
   with an existing code [link](https://app.qase.io/case/ATQI-7).
***
4. ***Test for creating a Test Case***
    1. Checking the possibility of creating a Test Case 
   with filling in fields and selecting values from drop-downs [link](https://app.qase.io/case/ATQI-8).
***   
5. ***Test for creating a Suite***
    1. Checking the possibility of creating a set with filling in the fields [link](https://app.qase.io/case/ATQI-9).
***
6. ***Search tests***
    1. Checking the ability to search for an existing project by Project name [link](https://app.qase.io/case/ATQI-10);
    2. Checking the ability to search for a non-existent project by name [link](https://app.qase.io/case/ATQI-11).
***
7. ***UI tests using Cucumber***
    1. Search for a project by full and partial project name [link](https://app.qase.io/case/ATQI-12);
    2. Search for cases in the project [link](https://app.qase.io/case/ATQI-13).
***
## API tests
***
1. ***Projects tests***
    1. Checking the creating of a new project through API [link](https://app.qase.io/case/ATQI-14);
    2. Checking the retrieve of a specific project by code [link](https://app.qase.io/case/ATQI-15);
    3. Checking the deletion of a specific project by code [link](https://app.qase.io/case/ATQI-16).
***   
2. ***Runs tests***
    1. Checking the scenario with the creation of the run in selected project, retrieve, 
   deletion the run from the repository by ID [link](https://app.qase.io/case/ATQI-17);
    2. Checking the retrieve of all runs stored in selected project [link](https://app.qase.io/case/ATQI-18);
    3. Checking the deletion a run from repository with incorrect ID Identifier [link](https://app.qase.io/case/ATQI-19).
***
3. ***Run results tests***
    1. Checking the scenario with the creation of the test run result 
   in selected project, retrieve, deletion the run result from the repository by ID [link](https://app.qase.io/case/ATQI-20).
***   
4. ***Defects tests***
    1. Checking the creation of a defect in selected project [link](https://app.qase.io/case/ATQI-21);
    2. Checking the retrieve of a specific defect by code and ID [link](https://app.qase.io/case/ATQI-22);
    3. Checking the retrieve of all defects by code [link](https://app.qase.io/case/ATQI-23);
    4. Checking the updating of a defect in selected project [link](https://app.qase.io/case/ATQI-24).