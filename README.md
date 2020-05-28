### Problem statement: 
Design backend application for an Employee Management with different end-points (method as GET, POST, PUT and DELETE) using RESTful web services.
Implement unit testing to test all layers of the application with code coverage of 90%.
### Functionalities and REST API details:

### 1
#### Functionality
Get Employee by ID
#### Remarks
Get employee details by EmpId using GET method
#### Request
HTTP GET
#### Response
Success 
*	200 – OK
*	Output: Employee response JSON data
Failure
*	400 – Bad Request (in case of bad input request)
*	404 – Not Found (in case of employee id not found)
*	500 – Internal Server (in case of server/system errors)

### 2
#### Functionality
Get Employees details
#### Remarks
Get list of employee using GET method
#### Request
HTTP GET
#### Response
Success 
*	200 – OK
Output: Employee collection response JSON 
Failure
*	400 – Bad Request (in case of bad input request)
*	500 – Internal Server (in case of server/system errors)

### 3
#### Functionality
Add new employee details
#### Remarks
Add new employee details
#### Request
HTTP POST
#### Response
Success 
*	201 – Created
Output: Success message
Failure
*	400 – Bad Request (in case of bad input request)
*	500 – Internal Server (in case of server/system errors)

### 4
#### Functionality
Delete employee record
#### Remarks
Delete employee record based on given employee id
#### Request
HTTP DELETE
#### Response
Success 
*	204 – No Content
*	Output: Confirmation message
Failure
*	400 – Bad Request (in case of bad input request)
*	404 – Not Found (in case of employee id not found)
*	500 – Internal Server (in case of server/system errors)

### Project Submission Procedure:
Submit a zip file which consists of following documents:
*	Solution folders
*	Screen capture of end to end testing using SOAP UI/Postman tools
*	Screen capture of code coverage 
*	Screen capture of unit testing






