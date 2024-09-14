

===================================================================================================================================================
------------------------------   	Few Assumptions and Clarifications
===================================================================================================================================================

1) Security Config file not created for testing easiness of task (adding authentication in headers to test in postman etc)
2) Service Implementation Class created for application only. Best practice for abstraction is to make interface and declare functions in it and
Implement all functions in interfaces in service implementation class(as done in application work)

3) Not added clear naming conventions for DTO's as of now for quick delivery ()
4) Removed dependency of encrypting passwords when saving (including role based encryption). I know how to do that and removed purposely.

5) Passwords are saved as string right now. they can be saved by encrypting at backend. Skipped right now and can elabrate in interview.
6) No field level validations included rn at controller , service and entity layer.


7) Postman collection also provided with email. Extra schema for given requirment also provided.
8) CORS validation overlooked for your easiness and testing.

9) Video also provided in email of running code.
10) Willing to discuss further more.
