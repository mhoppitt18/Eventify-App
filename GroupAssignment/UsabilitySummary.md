SunRecognizeLaughter Eventify Usability Summary
======================
The Eventify application utilises the user interface design principles published by Nielsen's (1994) Ten Heuristics, as found below.

1. Visibility of system status  
The user is regularly informed of the system status in the application. An example of implementing this characteristic can be clearly seen when a user downloads the event invitation from the application. Clicking the download button redirects the user to a directory chooser, allowing them to select their desired file save location. After the user selects this location, text appears next to the download button with the text "Invitation has been downloaded". This clearly signals to the user that the action has been successful, and they can find the downloaded invitation in their specified location.
-------------------

2. Match between system and the real world  
All of the concepts used within the application are familiar to the user, as they include jargon specific to the event planning industry such as the concepts of events, runsheets, guests, and RSVPs. An example of matching items to their real-world counterparts is the display of each event's runsheet. This is simply displayed in two columns of Time and Event, which mimics runsheets that are made in the real-world. The images found in the sidebar on most pages also represent their real-world objects to ensure users understand what the buttons will do. For example, the Home button has an image of a house, the My Guests button has an image of a person, and the Help button has an image of a question mark which is a widely used and accepted standard.
-------------------

3. User control and freedom  
Every page in the application includes a Back button to allow users to easily navigate back to the previous screen. This ensures they can quickly exit an unwanted state, without having to go through an extended process. All key navigation options are also displayed on the sidebar, which allows the freedom to navigate to different parts of the application from any page.
-------------------

4. Consistency and standards  
Each word and action used in the application have only one meaning - there are no actions with duplicate meanings. We have ensured consistency by using a sidebar, which has all of the functions available to that specific user. This allows them to navigate to any key part of the application from any page after login. We have also followed platform conventions by including Back and Log Out buttons on every page that is not part of a process, at the top left of the screen. These buttons and actions are placed in the identical position on every page to maintain consistency.
-------------------

5. Error prevention  
An example of error prevention can be seen in the AdminCreateEvent page, specifically in the 'Event Date' field. A date picker element has been implemented to ensure the correct date format is entered into the database. If a simple string was required, different users may use different date formats, which would cause inconsistency in the database and, thus, contibute to an inconsistent application. Another example is the application completing the action of generating guest access codes, instead of the administator randomly assigning codes. The access codes must be unique to provide guests with unique logins and, if the administrator assigned them manually, there is a possibility for a 'double-up'. Ensuring the system takes care of this operation prevents any error occuring in relation to generating guest access codes - provided the algorithm is correct.
-------------------

6. Recognition rather than recall  
Instructions on how to use the Eventify application are readily available in the sidebar as a 'Help' button. Upon mouse-click, the user is redirected to a Help page where FAQs are listed, which can help users diagnose issues they are having with the system. This could be extended to include a search function or the ability to create a new question, however it is outside the scope of this assignment. The user's memory load is also minimised through the application's logical navigation system. By presenting core navigation options in the sidebar, the user can learn the layout very quickly and, thus, easily remember how to navigate throughout the application. This is also achieved by locating 'Back' and 'Log Out' buttons at the same position (top left corner) on every page.
-------------------

7. Flexibility and efficiency of use  
Accelerators such as keyboard shortcuts have not been implemented in the Eventify application, as the skills required are not made available in the course, and such actions were outside the scope of the assignment. Similarly, advanced settings have not been implemented because it is outside the scope of the assignment. However, expert users do have the option of devising an event runsheet, which is displayed on-screen. Novice users do not have to undertake this action.
-------------------

8. Aesthetic and minimalist design  
The Eventify application successfully implements a fairly minimalist design, with many aesthetically pleasing features. For example, the login pages for both administrators and guests only contain the Eventify logo, a TextField to input username, a PasswordField to input password, and the 'Log In' button. This has been implemented to reduce the cognitive burden on users and invites the user to enjoy a minimalistic design. If the user is greeted by a complicated login screen, they may not even venture past this out of fear that the whole application is complicated and overwhelming. Furthermore, almost every element of every screen in the application is able to fit on the scene without the need for a ScrollPane. This was implemented to compact the elements into a range that makes using the application easier. The few number of elements on each page ensures the design stays quite minimalistic.
--------------------

9. Help users recognise, diagnose, and recover from errors  
Error messages are crucial, as they convey issues to the user that must be rectified. These are very commonly implemented in login screens, and have certainly been implemented in both the administator and guest logins in the Eventify application. If an administrator enters incorrect login credentials, the text "Invalid username/password" is displayed, and if a guest enters incorrect login details, the text "Invalid access code" is displayed. These messages are displayed in red, bolded text to ensure the user sees the error, so they can attempt to rectify it. We were wary of presenting the error to the user through a dialogue box, for example, because they can be intrusive. Over-the-top error messages can also discourage the user from rectifying their error, as they may feel embarrassed from making the initial mistake. Presenting the error message in plain text also ensures the user can understand the issue, so that they can successfully solve it. An error message that only contains programming jargon is not helpful to the novice user, and may even make the issue worse.
-------------------

10. Help and documentation  
The user can access help from every screen of the application once signed in, as a Help button is located on the sidebar. This includes FAQ's, which can be used by users to diagnose their problems with using the application. As an extension, a link could be included to avenues to contact Eventify staff, such as a customer service line or email address, but this falls outside the scope of the assignment. 
-------------------
