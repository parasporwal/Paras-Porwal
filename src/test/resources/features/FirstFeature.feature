Feature : Login and compose a mail

Background :
Given : user opens gmail sign in page
When : user enters his email address 
And : user select next Btn
Then : User land on password page
When : user enters the password
And : user click on next button
Then : user lands on inbox page 

Scenario: compose a mail and send it
When : user click on compose button
Then : a message box appears
When :user enter receipant mail
And : user enter subject 
And : user enter body
And : user click on send button
Then : Message will be sent successfully







