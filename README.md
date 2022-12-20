# ContactsApp

This application is a good way for handling your contacts! It is easy and simple to use, employing CRUD functions.

When you have downloaded this project file, go to the src file with your command console and run the commands "javac ContactsApp.java" and "java ContactsApp" and you're good to go!

In the middle of the main frame is the list that will show all the contacts you have added. All the contacts are stored in the "contacts.csv" file.

## Adding new contacts
To add new contacts, click the "Add" button and fill the text fields for contact information. Filling address and email are optional while other personal information is required, otherwise a contact cannot be added. There also cannot be any duplicate IDs.

## Validation checks
In order to add new contacts, you need to pass validation checks. Each personal information type has it own unique requirements. The current version of the application accepts only Finnish model for the National Identification Number. Please familiarize yourself with it in order to make sure you pass the validation, as there are many validation checks to make sure the ID conforms to the norm. 

You need to enter a capital letter first, when entering names (using dash is allowed, but a capital letter must follow it). The phone numbers need to be given with a Finnish mobile phone prefix (+358) or with a regional number prefix (01-09). Address is optional, but it needs to follow the following model, if added: "street name, number, capital letter, number. Email is optional, but if added, has to follow the conventional model.

## Editting contacts
Editting contacts have to follow similar validation checks, only ID is unchangeable. To edit a contact, simply click on a contact from the list component and then click the "Edit" button.

## Deleting contacts
Deleting function works similarly as edit, where you have to first select a contact, then a new for window deletion appears and a user is prompted for confirmation before deleting a contact with a pop up window with options.

## Search bar
There is also a search bar that helps you find contacts when entering contact's id in the text field.

Enjoy using the application!

### Credits

Lecturer Jussi Pohjolainen, lecturer Teemu Havumäki and youtube channels Brocode and Lazic B.

### Presentation video
Link to presentation video: https://youtu.be/ycTJvs3DjV0