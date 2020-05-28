Problem statement: 
Design backend application for an Employee Management with different end-points (method as GET, POST, PUT and DELETE) using RESTful web services.
Implement unit testing to test all layers of the application with code coverage of 90%.
Functionalities and REST API details:
Functionality	Remarks	Request	Response
Get Employee by ID	Get employee details by EmpId using GET method	HTTP GET	Success 
•	200 – OK
•	Output: Employee response JSON data
Failure
•	400 – Bad Request (in case of bad input request)
•	404 – Not Found (in case of employee id not found)
•	500 – Internal Server (in case of server/system errors)

Get Employees details	Get list of employee using GET method	HTTP GET	Success 
•	200 – OK
Output: Employee collection response JSON 
Failure
•	400 – Bad Request (in case of bad input request)
•	500 – Internal Server (in case of server/system errors)

Add new employee details	Add new employee details	HTTP POST	Success 
•	201 – Created
Output: Success message
Failure
•	400 – Bad Request (in case of bad input request)
•	500 – Internal Server (in case of server/system errors)

Delete employee record	Delete employee record based on given employee id	HTTP DELETE	Success 
•	204 – No Content
•	Output: Confirmation message
Failure
•	400 – Bad Request (in case of bad input request)
•	404 – Not Found (in case of employee id not found)
•	500 – Internal Server (in case of server/system errors)


Project Submission Procedure:
-	Submit a zip file which consists of following documents:
o	Solution folders
o	Screen capture of end to end testing using SOAP UI/Postman tools
o	Screen capture of code coverage 
o	Screen capture of unit testing
