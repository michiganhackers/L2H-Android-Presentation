# Learn-to-Hack Android Presenation
This project is an Android presentation given to the Learn-to-Hack team in the in University of Michigan student organization called Michigan Hackers.

## Contents
* The androidPresentation.pptx contains basic information about Android as well as some resources for learning.
* The rest of the files pertain to the to-do list demo app.

## To-do List App
<img src="demoAppGif.gif" alt="drawing" height="400" />  

### Prerequisites

#### Integrated Development Environment (IDE)
Install Android Studio, the official IDE for Android development. An IDE makes developing the application faster and easier.  
[Download](https://developer.android.com/studio/)

#### Git
Install git, a software for version control.  
[Download](https://git-scm.com/downloads)

#### Github Account
Create a Github account to interact with the remote repository.  
[Join](https://github.com/join)

### Installing
Fork this GitHub repository and clone the resulting repository. This is recommended so you may make expand upon the app and keep your changes under version control.
1. Select "Fork" at the top right of this repository
2. Open Android Studio
3. If Android Studio does not automatically open a previous project of yours, skip to step 6
4. Select File > New > Project from Version Control > Git
5. Skip to step 8
6. Select "Check out project from Version Control"
7. Select "Github"
8. Paste the link to the new GitHub repository you created after forking and select "Clone"

### Improving the To-do List App

If you're interested in expanding upon the demo app, or you just want some ideas for creating an app of your own, refer to the following feature list. The list is roughly ordered in increasing difficulty.
* Support configuration changes
	* Hint: Learn about the onSaveInstanceState method of the Activity class. You can also use the ViewModel class, though this is more difficult.
* Add more content to to the to-do list items
	* Hint: Learn about creating a custom ArrayAdapter
* Create an indicator for completed tasks e.g. a check box
* Support more comprehensive notes e.g. in a new activity when a list item is selected
* Create a trash bin to restore delete items
* Change the way that items are deleted e.g. swipe to dismiss
	* Hint: For swipe to dismiss, learn about the RecyclerView and ItemTouchHelper classes
* Support reordering of items e.g. drag and drop
	* Hint: For drag and drop, learn about the RecyclerView and ItemTouchHelper classes
* Support organization of the to-do list items e.g. separation into categories such as work, school, etc.
* Support persistence of the data
	* Hint: Learn about the Room Persistence Library if you want to save the data locally. Learn about a cloud database, such as Firebase's Cloud Firestore, if you want to be able to access the data across multiple devices.

## Contact Info
Feel free to contact me at vnagel@umich.edu if you have any questions about the demo app or Android development in general. I invite you join the Michigan Hackers Android development team if you're interested in learning more.