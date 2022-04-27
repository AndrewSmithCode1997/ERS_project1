# Expense Reimbursement App
The Expense Reimbursement App will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

# Technologies Used
- Intelij IDE
- Core Java
- JDBC
- DBeaver
- PostgreSql
- AWS EC2

# Features
- User login
- create reimbursement
- aprove or deny reimbursement (Manager only)
- review past reimbursements
- delete reimbursements

To-do list:
- delete user (with cascade)
- add picture to reimbursement (using AWS S3 bucket)
- fully develop functional front-end

# Getting Started 
1. clone the repo to your local machine (https://www.atlassian.com/git/tutorials/setting-up-a-repository/git-clone)
2. create an AWS account and set up the EC2 (recommend using the free version) 
3. create a database that utilizes postgreSQL (I used DBeaver for sever side) 
4. create **Enviroment Variables** on your local machine that match the ones inside the Utils package 
5. Make sure the names of the enviroment variables you create corrilate to the ones inside the package.
  - https://docs.oracle.com/en/database/oracle/machine-learning/oml4r/1.5.1/oread/creating-and-modifying-environment-variables-on-windows.html#GUID-DD6F9982-60D5-48F6-8270-A27EC53807D0
6. After all that is complete you can now run the backend! 
7. I recomend using postman or software similar to it for testing the endpoints to see it fully working.
